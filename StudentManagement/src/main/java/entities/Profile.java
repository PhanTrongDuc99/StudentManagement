/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
        /**
         *
         * @author PC
         */

public class Profile {
    private String fullName;
    private boolean gender;
    private Date dayOfBirth;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String homeTown;
    private String currentAddress;

    public Profile() {
    }

    public Profile(String fullName, boolean gender, Date dayOfBirth, String idNumber, String phoneNumber, String email, String homeTown, String currentAddress) {
        this.fullName = fullName;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.homeTown = homeTown;
        this.currentAddress = currentAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Profile{" + "fullName=" + fullName + ", gender=" + gender + ", dayOfBirth=" + dayOfBirth + ", idNumber=" + idNumber + ", phoneNumber=" + phoneNumber + ", email=" + email + ", homeTown=" + homeTown + ", currentAddress=" + currentAddress + '}';
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

}
