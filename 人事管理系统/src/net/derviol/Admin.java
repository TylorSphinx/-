package net.derviol;

public class Admin {
    private String id;
    private String name;
    private String password;
    void setID(String id) {
        this.id=id;
    }
    void setName(String name) {
        this.name=name;
    }
    void setPassword(String password) {
        this.password=password;
    }

    String getID() {
        return this.id;
    }
    String getName() {
        return this.name;
    }
    String getPassword() {
        return this.password;
    }
}
