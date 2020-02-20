import org.junit.Test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class MenuTest {
    static Scanner scanner = new Scanner(System.in);
    @Test
    public void loadFromFileTest()
    {
        System.out.println("This is a Test");
        String information[] = {"Chongyuan", "Chen", "123 Street", "Hayward", "CA", "94541", "510-888-7777", "123#gmail.com"};
        AddressEntry newEntry = new AddressEntry(information[0],information[1],information[2],information[3],information[4],Integer.parseInt(information[5]),information[6],information[7]);
        System.out.println(newEntry.toString());
        AddressBook ab = new AddressBook();
        ab.add(newEntry);
        System.out.println(ab.addressEntryList.get(0).toString());
    }
    @Test
    public void addEntryTest()
    {

        AddressEntry entry = new AddressEntry();
        System.out.println("City");
        entry.setFirstName(scanner.next());
        System.out.println("State:");
        entry.setLastName(scanner.next());
        System.out.println("City");
        entry.setFirstName(scanner.next());
        scanner.nextLine();
        System.out.println("Street:");
        entry.setLastName(scanner.next());
    }
    @Test
    public void removeEntryTest()
    {
        AddressBook ab = new AddressBook();
        System.out.println("Please enter the last name of the address entry that you want removed:");
        String find = scanner.next();
        ArrayList<Integer> selectedEntries = new ArrayList<Integer>();
        for(int x = 0; x < ab.addressEntryList.size(); x++)
        {
            if(ab.addressEntryList.get(x).getLastName().equals(find))
            {
                selectedEntries.add(x + 1);
            }
        }
        if(selectedEntries.size() == 0)
        {
            System.out.println("The last name that you entered was not found in the address book.");
        }
        else if(selectedEntries.size() == 1)
        {
            System.out.println("The following matching entry was found:");
            System.out.println("Entry " + selectedEntries.get(0));
            System.out.println(ab.addressEntryList.get(selectedEntries.get(0) - 1).toString());

        }
        else
        {
            System.out.println("The following matching entries were found:");
            for(int x = 0; x < selectedEntries.size(); x++)
            {
                System.out.println("Entry " + selectedEntries.get(x));
                System.out.println(ab.addressEntryList.get(selectedEntries.get(x) - 1).toString());

            }
        }
    }
    @Test
    public void entryListTest()
    {
        String str[] = { "Grewe", "Bob", "Chongyuan", "Ben", "Molly"};
        String temp;
        for (int j = 0; j < str.length; j++) {
            for (int i = j + 1; i < str.length; i++) {
                if (str[i].compareTo(str[j]) < 0) {
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
            System.out.println(str[j]);
        }
    }
}