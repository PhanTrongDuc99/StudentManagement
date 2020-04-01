/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author SMILE ^^
 */
public class Admin {

    private Integer idAdmin;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(Integer idAdmin, String username, String password) {
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAdmin());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Admin)) {
            return false;
        }

        Admin staff = (Admin) obj;
        return Objects.equals(staff.getIdAdmin(), getIdAdmin());
    }

    @Override
    public String toString() {
        return "Admin [id=" + idAdmin + ", Username=" + username;
    }

}
