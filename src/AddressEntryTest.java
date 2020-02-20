import org.junit.Test;

public class AddressEntryTest {
    String firstName, lastName, street, city, state, phone, email;
    int zip;
    @Test
    void AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone)
    {
        firstName = firstName;
        lastName = lastName;
        street = street;
        city = city;
        state = state;
        zip = zip;
        email = email;
        phone = phone;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getFirstName()
    {
        return firstName;
    }

}