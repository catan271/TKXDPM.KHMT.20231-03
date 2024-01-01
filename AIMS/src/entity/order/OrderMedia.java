package entity.order;

import entity.media.Media;

public class OrderMedia {

    private Media media;
    private int price;
    private int quantity;

    public OrderMedia(Media media, int quantity, int price) {
        this.media = media;
        this.quantity = quantity;
        this.price = price;
    }


    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                "  media='" + media + "'" +
                ", quantity='" + quantity + "'" +
                ", price='" + price + "'" +
                "}";
    }


    /**
     * @return Media
     */
    public Media getMedia() {
        return this.media;
    }
<<<<<<< HEAD


    /**
     * @param media
     */
    public void setMedia(Media media) {
        this.media = media;
    }


    /**
     * @return int
     */
    public int getQuantity() {
        return this.quantity;
    }


    /**
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * @return int
     */
    public int getPrice() {
        return this.price;
    }


    /**
     * @param price
     */
=======
    
    public void setMedia(Media media) {
        this.media = media;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getPrice() {
        return this.price;
    }
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    public void setPrice(int price) {
        this.price = price;
    }

}
