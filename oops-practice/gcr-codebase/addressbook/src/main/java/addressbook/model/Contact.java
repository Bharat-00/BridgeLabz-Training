package addressbook.model;

import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String state;

    public Contact(String firstName, String lastName, String phone, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.state = state;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getState() { return state; }

    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return firstName.equalsIgnoreCase(contact.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " + phone + " | " + city + " | " + state;
    }
}
