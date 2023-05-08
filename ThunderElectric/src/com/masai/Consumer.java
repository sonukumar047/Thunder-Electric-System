package com.masai;

import java.io.Serializable;

public class Consumer implements Serializable {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private boolean isActive;

    public Consumer(String username, String password, String firstName, String lastName,
                    String address, String mobileNumber, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.isActive = true;
    }

    public String getFullName(){
    	return firstName+" "+lastName;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Username: " + username +
                "\nPassword: " + password +
                "\nName: " + firstName + " " + lastName +
                "\nAddress: " + address +
                "\nMobile Number: " + mobileNumber +
                "\nEmail: " + email +
                "\nStatus: " + (isActive ? "Active" : "Inactive");
    }
}