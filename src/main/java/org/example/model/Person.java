package org.example.model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        if (firstName == null || lastName == null || email == null)
            throw new IllegalArgumentException("First name, last name, and email cannot be null");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("\\S+@\\S+\\.\\S+")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    public String getSummary() {
        return "Person id: " + id + ", firstName: '" + firstName + "', lastName: '" + lastName + "', email: " + email;
    }
}
