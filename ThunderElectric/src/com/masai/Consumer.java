package com.masai;

public class Consumer {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;

    public Consumer(String username, String password, String firstName, String lastName,
                    String address, String mobileNumber, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return firstName + " " + lastName;
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
}
