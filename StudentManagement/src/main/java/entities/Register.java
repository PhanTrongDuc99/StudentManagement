/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import common.RegisterStatus;
import common.RegisterType;

/**
 *
 * @author USER
 */
public class Register {

    private String id;
    private RegisterStatus status;
    private RegisterType type;

    public Register() {
    }

    public Register(String id, RegisterStatus status, RegisterType type) {
        this.id = id;
        this.status = status;
        this.type = type;
    }

    public Register(RegisterStatus status, RegisterType type) {
        this.status = status;
        this.type = type;
    }

    public RegisterStatus getStatus() {
        return status;
    }

    public void setStatus(RegisterStatus status) {
        this.status = status;
    }

    public RegisterType getType() {
        return type;
    }

    public void setType(RegisterType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Status: " + status + " - Type: " + type; //To change body of generated methods, choose Tools | Templates.
    }

}
