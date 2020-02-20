/**
 * This class AddressBook is an arrayList of the object AddressEntry with different methods to change the list's contents
 */

import java.util.ArrayList;

/**
 * This class is the object used to represent an address book
 */
public class AddressBook
{
    //An arraylist is used for easier manipulation of list size
    ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

    /**
     * this method adds a new element of AddressEntry object into the AddressBook arraylist
     * @param entry single entry in the list
     */
    public void add(AddressEntry entry)
    {
        addressEntryList.add(entry);
    }

    /**
     * prints the entire AddressBook in order element by element
     */
    public void list()
    {
        System.out.println("Here is a list of all the entries currently in the address book: ");
        for(int x = 0; x < addressEntryList.size(); x++)    //iterates through the addressEntryList
        {
            System.out.println("Entry " + (x + 1) + ":");
            System.out.println(addressEntryList.get(x).toString()); //prints the returned string from the toString method in the AddressEntry class for each element
        }
    }

}
