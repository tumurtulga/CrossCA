/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossca;

/**
 *
 * @author deece
 */
public class User {
    
    int ID;
    String username;
    String password;
    String firstname;
    String lastname;
    Level regular;

    public User(int ID, String username, String password, String firstname, String lastname, Level regular) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.regular = regular;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Level getRegular() {
        return regular;
    }

    public void setRegular(Level regular) {
        this.regular = regular;
    }
    
    
    
    
    
}
