package co.com.sofka.challenge.models;

public class CustomerInfo {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String telephone;
    private final String password;
    private final String address;
    private final String city;
    private final String postCode;
    private final String country;
    private final String zone;

    public CustomerInfo(String firstName, String lastName, String email, String telephone,
                        String password, String address, String city, String postCode,
                        String country, String zone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.address = address;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.zone = zone;
    }

    public static CustomerInfo uniqueCustomer() {
        long timestamp = System.currentTimeMillis();
        return new CustomerInfo(
                "Jhon",
                "Jurado",
                "jhon_tester_" + timestamp + "@sofkatest.com",
                "3001234567",
                "Prueba1234*",
                "Main Street 123",
                "Los Angeles",
                "90210",
                "United States",
                "California"
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getZone() {
        return zone;
    }
}
