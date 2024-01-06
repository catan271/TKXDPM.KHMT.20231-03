package views.screen.manage.order;

import controller.ManageOrderController;
import entity.media.Media;
import entity.order.Order;
import entity.order.OrderMedia;
import entity.shipping.Shipment;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.home.MediaHandler;
import views.screen.manage.ManageScreenHandler;
import views.screen.popup.PopupScreen;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class OrderManageScreenHandler extends ManageScreenHandler implements Initializable {
    private static Logger LOGGER = Utils.getLogger(MediaHandler.class.getName());

    @FXML
    private TableView<Order> orderTableView;

    @FXML
    private TableColumn<Order, Integer> idColumn;

    @FXML
    private TableColumn<Order, String> nameColumn;

    @FXML
    private TableColumn<Order, String> phoneColumn;

    @FXML
    private TableColumn<Order, String> addressColumn;

    @FXML
    private TableColumn<Order, String> provinceColumn;

    @FXML
    private TableColumn<Order, String> shipTypeColumn;

    @FXML
    private TableColumn<Order, String> statusColumn;

    @FXML
    private TableColumn<Order, Order> actionColumn;


    public OrderManageScreenHandler(Stage stage, String screenPath) throws IOException {
        super(stage, screenPath);
    }

    public ManageOrderController getBController() { return (ManageOrderController) super.getBController(); }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        super.setBController(new ManageOrderController());
        try {
            showAllOrder();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void showAllOrder() throws SQLException {
        List<Order> listOrder = getBController().getAllOrder();

        // Log shipType for all shipments
//        listOrder.forEach(order -> {
//            Shipment shipment = order.getShipment();
//            if (shipment != null) {
//                LOGGER.info("ShipType for Order ID " + order.getId() + ": " + shipment.getShipType());
//            }
//        });

        idColumn.setCellValueFactory(new PropertyValueFactory<Order, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("address"));
        provinceColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("province"));
        // Set the cell value factory for shipTypeColumn
        shipTypeColumn.setCellValueFactory(cellData -> {
            Order order = cellData.getValue();
            Shipment shipment = order.getShipment();
            String shipType = shipment.getShipType() == 1 ? "Rush Delivery" : "Standard Delivery";

            // Log shipType
//            LOGGER.info("ShipType for Order ID " + order.getId() + ": " + shipType);

            return new ReadOnlyObjectWrapper<>(shipType);
        });
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
        statusColumn.setCellFactory(column -> new TableCell<Order, String>() {
            @Override
            protected void updateItem(String status, boolean empty) {
                super.updateItem(status, empty);

                if (empty || status == null) {
                    setText(null);
                    setTextFill(null); // Set default text color if status is null or empty
                } else {
                    setText(status);

                    // Set text color based on the status value
                    if ("Approve".equals(status)) {
                        setTextFill(javafx.scene.paint.Color.GREEN);
                    } else if ("Refuse".equals(status)) {
                        setTextFill(javafx.scene.paint.Color.RED);
                    } else {
                        setTextFill(Color.ORANGE); // Default text color
                    }
                }
            }
        });

        actionColumn.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        actionColumn.setCellFactory(param -> new TableCell<Order, Order>() {
            private final Button approveButton = new Button("Approve");
            private final Button refuseButton = new Button("Refuse");
            private final Button viewButton = new Button ("View Detail");

            {
                approveButton.setStyle("-fx-cursor: hand;");
                refuseButton.setStyle("-fx-cursor: hand;");
                viewButton.setStyle("-fx-cursor: hand;");
            }

            @Override
            protected void updateItem(Order order, boolean empty) {
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(10, approveButton, refuseButton, viewButton);

                    boolean disabled = "Approve".equals(order.getStatus()) || "Refuse".equals(order.getStatus());
                    approveButton.setDisable(disabled);
                    refuseButton.setDisable(disabled);

                    approveButton.setOnAction(e -> {
                        try {
//                            LOGGER.info(String.valueOf(checkMediaQuantities(order.getId())));
                            if(checkMediaQuantities(order.getId())) {
                                updateOrderStatus(order.getId(), "Approve");
                                openOrderManage();
                            } else {
                                PopupScreen.error("The quantity of media is not enough");
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    });
                    refuseButton.setOnAction(e -> {
                        updateOrderStatus(order.getId(), "Refuse");
                        openOrderManage();
                    });
                    viewButton.setOnAction(e -> {
                        try {
                            LOGGER.info(String.valueOf(order.getId()));
                            openDetailOrder(order.getId());
                        } catch (IOException | SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    setGraphic(box);
                }
            }
        });

        orderTableView.getItems().addAll(listOrder);
    }

    private void updateOrderStatus(int id, String status) {
        if ("Approve".equalsIgnoreCase(status)) {
            // Update the order status
            getBController().updateOrderStatus(id, status);

            Order order = getBController().getOrderById(id);
            List<OrderMedia> listOrderMedia = order.getlstOrderMedia();
            // Update the media quantities
            for (OrderMedia orderMedia : listOrderMedia) {
                Media media = orderMedia.getMedia();
                int requestedQuantity = orderMedia.getQuantity();

                // Reduce the media quantity in the database
                int newQuantity = media.getQuantity() - requestedQuantity;
                getBController().updateMediaQuantity(media.getId(), newQuantity);
            }

        } else {
            getBController().updateOrderStatus(id, status);
        }
    }

    private void openDetailOrder(int id) throws IOException, SQLException {
//        LOGGER.info(String.valueOf(id));
        DetailOrderScreenHandler detailOrderScreen = new DetailOrderScreenHandler(this.stage, Configs.DETAIL_ORDER_SCREEN_PATH, getBController(), id);
        detailOrderScreen.showDetailOrder();
        detailOrderScreen.show();
//
    }

    private boolean checkMediaQuantities(int orderId) throws SQLException {
        Order order = getBController().getOrderById(orderId);
        List<OrderMedia> listOrderMedia = order.getlstOrderMedia();

        for (OrderMedia orderMedia : listOrderMedia) {
            Media media = orderMedia.getMedia();
            int requestedQuantity = orderMedia.getQuantity();
            LOGGER.info("Number Requested" + String.valueOf(requestedQuantity));
            LOGGER.info("Number Media" + String.valueOf(media.getQuantity()));

            // Check if the requested quantity exceeds the available quantity
            if (requestedQuantity > media.getQuantity()) {
                return false;
            }
        }

        return true;
    }
}
