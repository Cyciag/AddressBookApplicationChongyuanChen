/**This class is an object of AddressEntry that contains several pieces of information about the individual entry.
 * It also contains methods to alter and return these data.
 */

public class AddressEntry
{
    String firstName, lastName, street, city, state, phone, email;
    int zip;

    /**
     * default constructor
     */
    AddressEntry()
    {

    }

    /**
     * constructor that takes in all the information needed to initialize 1 address entry
     */
    AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone)  //constructor that takes all the data as parameter
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Takes all of the AddressEntry's data and composes them into a single string then returns it
     * @return single string with all information
     */
    public String toString()
    {
        return "First Name: " + firstName + ", " +
                "Last Name: " + lastName + ", " +
                "street: " + street + ", " +
                "city: " + city + ", " +
                "state: " + state + ", " +
                "zip: " + zip + ", " +
                "email: " + email + ", " +
                "phone: " + phone;
    }

    /**
     * Sets first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets first name
     * @return firstName - entry first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets Last name
     * @return lastName - entry lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets street name
     */
    public void setStreet(String street)
    {
        this.street = street;
    }

    /**
     * Gets street name
     * @return street - entry street name
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * Sets city
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * Gets city
     * @return city - entry city name
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sets state
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Gets state name
     * @return state - entry state name
     */
    public String getState()
    {
        return state;
    }

    /**
     * Sets zip code
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }

    /**
     * Gets zip code
     * @return zip - entry zip code
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * Sets phone number
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Gets phone number
     * @return phone - entry phone number
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets user email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Gets user email
     * @return email - entry email
     */
    public String getEmail()
    {
        return email;
    }
}
