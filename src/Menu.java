import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** Menu class uses static methods to prompt to standard output from user information about a Contact like name,etc
 * It can also load information form a file into an entry instead
 * Also contains methods to find and remove specified entries by the user
 **/
class Menu
{
    static Scanner scanner = new Scanner(System.in);
    public static int menuSelection()
    {
        System.out.println("Please selection an option:\n1.Loading From File\n2.Addition\n3.Removal\n4.Find\n5.Listing\n6.Stop");
        return scanner.nextInt();
    }

    /**
     * creates instance of AddressBook after reading in the file
     * @param ab is the AddressBook that we will initialize
     */
    public static void loadFromFile(AddressBook ab) throws FileNotFoundException
    {
        System.out.println("Please enter file name: ");
        File addresses = new File(scanner.next());    //gets file
        Scanner scanner = new Scanner(addresses);
        String information[] = new String[8];   //This array of 8 elements is used to store information about one single AddressEntry
        int position = 0;   //Position of our line in terms of the individual's information. For example 0 = first name, 7 = phone number.
        int numOfAddresses = 0; //Total number of addresses read from the file.
        while (true)
        {
            if(position == 8)
            {
                //The parseInt method turns a string into an integer
                AddressEntry newEntry = new AddressEntry(information[0],information[1],information[2],information[3],information[4],Integer.parseInt(information[5]),information[6],information[7]);    //creates new element of AddressEntry from the last 8 lines read
                ab.add(newEntry);
                position = 0;   //resets counter to 0;
                numOfAddresses++;
            }
            if(!scanner.hasNextLine())
            {
                break;
            }
            String line = scanner.nextLine();
            information[position] = line;   //stores info on the line into corresponding location in array
            position++;
        }
        System.out.println(ab.addressEntryList.size() + " addresses read.");
    }

    /**
     *prompts the user for information about the entry
     * @param ab the address book
     */
    public static void addEntry(AddressBook ab)
    {
        AddressEntry entry = new AddressEntry();
        entry.setFirstName(prompt_FirstName());
        entry.setLastName(prompt_LastName());
        scanner.nextLine();
        entry.setStreet(prompt_Street());
        entry.setCity(prompt_City());
        scanner.nextLine();
        entry.setState(prompt_State());
        entry.setZip(prompt_Zip());
        entry.setPhone(prompt_Telephone());
        entry.setEmail(prompt_Email());
        System.out.println("The following entry has been added: ");
        System.out.println(entry.toString());
        ab.add(entry);
    }

    /**
     * Removes an entry from the address book by calling the find method first and then removes element according to user input
     * @param ab
     */
    public static void removeEntry(AddressBook ab)
    {
        System.out.println("Please enter the last name of the address entry that you want removed:");
        String find = scanner.next();
        ArrayList<Integer> selectedEntries = new ArrayList<Integer>();
        find(ab, find, selectedEntries);
        if(selectedEntries.size() == 0)    //this means nothing to delete
        {
            return;
        }
        else if(selectedEntries.size() == 1)    //size = 1 means we will delete the only element matching user input
        {
            System.out.println("Entry " + selectedEntries.get(0) + " has been removed.");
            ab.addressEntryList.remove(selectedEntries.get(0) - 1);
        }
        else    //prompts user to specify which entry out of the specified ones to delete
        {
            System.out.println("Please select the entry number that you want to remove: ");
            int remove = scanner.nextInt();
            for(int x = 0; x < selectedEntries.size(); x++)
            {
                System.out.println(selectedEntries.get(x));
            }
            ab.addressEntryList.remove(remove - 1);
        }

    }

    /**
     * calls the find method shared by removeEntry, the only difference is the prompt before the find method is called
     * @param ab the address book
     */
    public static void findEntry(AddressBook ab)
    {
        System.out.println("Please enter the last name of the address entry that you want to find:");
        String find = scanner.next();
        ArrayList<Integer> selectedEntries = new ArrayList<Integer>();
        find(ab, find, selectedEntries);
    }

    /**
     * Will search the address book matching last names entered by the user
     * @param ab the address book
     * @param find the specified last name input from the user
     * @param selectedEntries  the resulting arraylist containing indexes for entries specified
     */
    public static void find(AddressBook ab, String find, ArrayList<Integer> selectedEntries)
    {
        for(int x = 0; x < ab.addressEntryList.size(); x++) //looping through the address book
        {
            if(ab.addressEntryList.get(x).getLastName().equals(find))  //If the entry last name matches the user input we will mark the entry's index for further user selections
            {
                selectedEntries.add(x + 1);
            }
        }
        if(selectedEntries.size() == 0) //The addressEntryList array list would be empty if we didnt find any matching last names
        {
            System.out.println("The last name that you entered was not found in the address book.");
        }
        else if(selectedEntries.size() == 1)    //If we only found 1 match
        {
            System.out.println("The following matching entry was found:");
            System.out.println("Entry " + selectedEntries.get(0));
            System.out.println(ab.addressEntryList.get(selectedEntries.get(0) - 1).toString());

        }
        else    //If we found more than 1 match
        {
            System.out.println("The following matching entries were found:");
            for(int x = 0; x < selectedEntries.size(); x++)
            {
                System.out.println("Entry " + selectedEntries.get(x));
                System.out.println(ab.addressEntryList.get(selectedEntries.get(x) - 1).toString());

            }
        }
    }

    /**
     * Sorts the address bok in alphabetical order as well as printing it
     * @param ab the address book
     */
    public static void entriesList(AddressBook ab)
    {
        for (int i = 0; i < ab.addressEntryList.size(); i++)
        {
            for (int j = i + 1; j < ab.addressEntryList.size(); j++)
            {
                if (((ab.addressEntryList.get(i).getLastName()).compareTo(ab.addressEntryList.get(j).getLastName())) > 0)
                {
                    Collections.swap(ab.addressEntryList, i, j);
                }
            }
        }
        ab.list();
    }
    /**
     * prompt methods that generates a standard output prompt for the First Name to be entered
     */
    public static String prompt_FirstName()
    {
        System.out.println("First Name: ");
        return scanner.next();
    }
    public static String prompt_LastName()
    {
        System.out.println("Last Name: ");
        return scanner.next();

    }
    public static String prompt_Street()
    {
        System.out.println("Street: ");
        return scanner.nextLine();
    }
    public static String prompt_City()
    {
        System.out.println("City: ");
        return scanner.next();
    }
    public static String prompt_State()
    {
        System.out.println("State: ");
        return scanner.next();
    }
    public static int prompt_Zip()
    {
        System.out.println("Zip: ");
        return scanner.nextInt();
    }
    public static String prompt_Telephone()
    {
        System.out.println("Telephone: ");
        return scanner.next();
    }
    public static String prompt_Email()
    {
        System.out.println("Email: ");
        return scanner.next();
    }
} 