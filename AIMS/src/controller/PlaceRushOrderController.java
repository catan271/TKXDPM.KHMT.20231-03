package controller;

import entity.shipping.Shipment;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * This class controls the flow of place rush order usecase in our AIMS project
<<<<<<< HEAD
 *
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
 */
public class PlaceRushOrderController extends BaseController {
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceRushOrderController.class.getName());

<<<<<<< HEAD

    /**
     * @param deliveryData
     * @param typeDelivery
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public static void validatePlaceRushOrderData(Shipment deliveryData) {
        if (deliveryData.getShipType() == utils.Configs.PLACE_RUSH_ORDER) {
           // validate
        }
    }
}
