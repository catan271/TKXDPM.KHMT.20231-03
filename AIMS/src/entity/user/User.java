package entity.user;

public class User {

    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public User(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

<<<<<<< HEAD

    /**
     * @return String
     */
=======
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    // override toString method
    @Override
    public String toString() {
        return "{" +
                "  username='" + name + "'" +
                ", email='" + email + "'" +
                ", address='" + address + "'" +
                ", phone='" + phone + "'" +
                "}";
    }
<<<<<<< HEAD


    /**
     * @return String
     */
=======
    
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
    // getter and setter
    public String getName() {
        return this.name;
    }
<<<<<<< HEAD


    /**
     * @param name
     */
    public void setusername(String name) {
        this.name = name;
    }


    /**
     * @return String
     */
    public String getEmail() {
        return this.email;
    }


    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return String
     */
    public String getAddress() {
        return this.address;
    }


    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }


    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

=======
    
    public void setusername(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
>>>>>>> 86d63191ae6fcef68f6a0e374ae89b2ce88e2669
}
