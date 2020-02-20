import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * The menu class prompts choices from the user.
 * It can also load information form a file into an entry as well as use methods to find and remove specified entries by the user.
 **/
class Menu
{
    static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to select a choice either reading in inputs or modifying the address book.
     * @return scanner.nextInt() - the choice that the user entered from the prompt
     */
    public static int menuSelection()
    {
        System.out.println("Please selection an option:\n1.Loading From File\n2.Addition\n3.Removal\n4.Find\n5.Listing(also sorts the list)\n6.Stop");
        return scanner.nextInt();
    }

    /**
     * Adds entries into the main address book from a file provided by the user.
     * We will read entries one by one with the use of an array of size 8(there are 8 pieces of information)
     * A new entry is initialized and put into the address book every time we finish reading an entry
     * @param ab - the AddressBook that will be modifying
     */
    public static void loadFromFile(AddressBook ab) throws FileNotFoundException
    {
        System.out.println("Please enter file name: ");
        File addresses = new File(scanner.next());    //gets file from user input
        Scanner scanner = new Scanner(addresses);     //sets the scanner to read from the file provided
        String information[] = new String[8];   //This array of 8 elements is used to store information about a single address entry
        int position = 0;   //the position integer provides the current location of our scanner within the address entry. For example 0 = first name, 7 = phone number.
        int numOfAddresses = 0; //total number of address entries read from the file.
        while (true)
        {
            if(position == 8)   //once we reach the end of an entry we will reset position back to 0 and read the next entry
            {
                //the parseInt method turns a string into an integer
                //we uses it here to change the zip code into an integer when we initialize our entry
                AddressEntry newEntry = new AddressEntry(information[0],information[1],information[2],information[3],information[4],Integer.parseInt(information[5]),information[6],information[7]);    //initializing new entry
                ab.add(newEntry);   //adds entry to the main address book
                position = 0;
                numOfAddresses++;
            }
            if(!scanner.hasNextLine())  //continue reading until end of file
            {
                break;
            }
            String line = scanner.nextLine();
            information[position] = line;   //stores info of the line into corresponding location in array
            position++; //increments to next piece of information
        }
        System.out.println(numOfAddresses + " addresses read.");
        System.out.println("There is now a total of " + ab.addressEntryList.size() + " in the address book.");
    }

    /**
     * Prompts the user for information about an individual entry that we will add.
     * @param ab - the AddressBook that will be modifying
     */
    public static void addEntry(AddressBook ab)
    {
        AddressEntry entry = new AddressEntry();
        //numerous prompts for required information about the entry
        //we use scanner.nextLine() at the beginning and after setZip to clear the line for the next read
        scanner.nextLine();
        entry.setFirstName(prompt_FirstName());
        entry.setLastName(prompt_LastName());
        entry.setStreet(prompt_Street());
        entry.setCity(prompt_City());
        entry.setState(prompt_State());
        entry.setZip(prompt_Zip());
        scanner.nextLine();
        entry.setPhone(prompt_Telephone());
        entry.setEmail(prompt_Email());
        System.out.println("The following entry has been added to the address book: ");
        System.out.println(entry.toString());
        ab.add(entry);  //adds entry to main address book
        System.out.println("There are now a total of " + ab.addressEntryList.size() + " in the address book.");
    }

    /**
     * Removes an entry from the address book by calling the find method first and then removes element according to user input
     * @param ab - the AddressBook that will be modifying
     */
    public static void removeEntry(AddressBook ab)
    {
        System.out.println("Please enter the last name of the address entry that you want removed:");
        String find = scanner.next();
        ArrayList<Integer> selectedEntries = new ArrayList<Integer>();  //this array list will be used to store the indexes of the entries that matches the user's input
        find(ab, find, selectedEntries);
        if(selectedEntries.size() == 0)    //size = 0 means nothing to delete
        {
            return;
        }
        else if(selectedEntries.size() == 1)    //size = 1 means we will delete the only element matching user input
        {
            System.out.println("Entry " + (selectedEntries.get(0) + 1) + " has been removed.");
            ab.addressEntryList.remove(selectedEntries.get(0).intValue());
        }
        else    //prompts user to specify which entry out of the specified ones to delete
        {
            System.out.println("Please select the entry number that you want to remove: ");
            int remove = scanner.nextInt();
            ab.addressEntryList.remove(remove - 1);
        }

    }

    /**
     * Calls the find method just as removeEntry did, the only difference is the prompt, there is also no follow up after the find method
     * @param ab - the AddressBook that will be modifying
     */
    public static void findEntry(AddressBook ab)
    {
        System.out.println("Please enter the last name of the address entry that you want to find:");
        String find = scanner.next();
        ArrayList<Integer> selectedEntries = new ArrayList<Integer>();
        find(ab, find, selectedEntries);
    }

    /**
     * Will search the address book for elements with matching last names entered by the user and puts corresponding elements' indexes into selectedEntries array list
     * @param ab - the AddressBook that will be modifying
     * @param find - the specified last name input from the user
     * @param selectedEntries - the resulting array list containing indexes for entries specified
     */
    public static void find(AddressBook ab, String find, ArrayList<Integer> selectedEntries)
    {
        for(int x = 0; x < ab.addressEntryList.size(); x++) //looping through the address book
        {
            if(ab.addressEntryList.get(x).getLastName().equals(find))  //If the entry last name matches the user input we will mark the entry's index for further user selections
            {
                selectedEntries.add(x);
            }
        }
        if(selectedEntries.size() == 0) //The addressEntryList array list would be empty if we didnt find any matching last names
        {
            System.out.println("The last name that you entered was not found in the address book.");
        }
        else if(selectedEntries.size() == 1)    //If we only find 1 match
        {
            System.out.println("The following matching entry was found:");
            System.out.println("Entry " + (selectedEntries.get(0) + 1) + ":");  //we add 1 for correct reading index
            System.out.println(ab.addressEntryList.get(selectedEntries.get(0)).toString());

        }
        else    //If we find more than 1 match
        {
            System.out.println("The following matching entries were found:");
            for(int x = 0; x < selectedEntries.size(); x++)
            {
                System.out.println("Entry " + (selectedEntries.get(x) + 1) + ":");
                System.out.println(ab.addressEntryList.get(selectedEntries.get(x)).toString());

            }
        }
    }

    /**
     * Sorts the address book in alphabetical order with bubble sort as well as printing it
     * @param ab - the AddressBook that will be modifying
     */
    public static void entriesList(AddressBook ab)
    {
        if(ab.addressEntryList.size() == 0) //if size = 0 list is empty
        {
            System.out.println("The address book is currently empty.");
            return;
        }
        for (int i = 0; i < ab.addressEntryList.size(); i++)   //sort
        {
            for (int j = i + 1; j < ab.addressEntryList.size(); j++)
            {
                if (((ab.addressEntryList.get(i).getLastName()).compareTo(ab.addressEntryList.get(j).getLastName())) > 0)
                {
                    Collections.swap(ab.addressEntryList, i, j);    //method used to sway two elements of objects
                }
            }
        }
        ab.list();
    }

    /**
     * prompt for first name
     * @return user input for first name
     */
    public static String prompt_FirstName()
    {
        System.out.println("First Name: ");
        return scanner.nextLine();
    }

    /**
     * prompt for last name
     * @return user input for last name
     */
    public static String prompt_LastName()
    {
        System.out.println("Last Name: ");
        return scanner.nextLine();

    }

    /**
     * prompt for street
     * @return user input for street name
     */
    public static String prompt_Street()
    {
        System.out.println("Street: ");
        return scanner.nextLine();
    }

    /**
     * prompt for city
     * @return user input for city name
     */
    public static String prompt_City()
    {
        System.out.println("City: ");
        return scanner.nextLine();
    }

    /**
     * prompt for state
     * @return user input for state
     */
    public static String prompt_State()
    {
        System.out.println("State: ");
        return scanner.nextLine();
    }

    /**
     * prompt for zip code
     * @return user input for zip code
     */
    public static int prompt_Zip()
    {
        System.out.println("Zip: ");
        return scanner.nextInt();
    }

    /**
     * prompt for phone number
     * @return user input phone number
     */
    public static String prompt_Telephone()
    {
        System.out.println("Telephone: ");
        return scanner.nextLine();
    }

    /**
     * prompt for email
     * @return user input for email
     */
    public static String prompt_Email()
    {
        System.out.println("Email: ");
        return scanner.nextLine();
    }
} 