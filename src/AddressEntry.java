/**This class is an object of AddressEntry that contains several pieces of information about the individual.
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
     * constructor that takes in all the information needed to create one single address entry
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
    public String toString()    //Takes all of the AddressEntry's data and composes them into a single string then returns it
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
     * @return
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Gets first name
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets last name
     * @return
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Gets Last name
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets street name
     * @return
     */
    public void setStreet(String street)
    {
        this.street = street;
    }

    /**
     * Gets street name
     * @return street
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * Sets city
     * @return
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * Gets city
     * @return city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sets state
     * @return
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Gets state name
     * @return state
     */
    public String getState()
    {
        return state;
    }

    /**
     * Sets zip code
     * @return
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }

    /**
     * Gets zip code
     * @return firstName
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * Sets phone number
     * @return
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * Gets phone number
     * @return phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets user email
     * @return
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Gets user email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
}
