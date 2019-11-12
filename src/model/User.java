package model;

/**
 *
 * @author Kesego
 */
public class User extends Person {
    private String username;
    private String email;
    private  String physicalAddress;

    public User(String username, String firstname, String lastname, String email, String physicalAddress) {
        super(firstname, lastname);
        this.username = username;
        this.email = email;
        this.physicalAddress = physicalAddress;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
