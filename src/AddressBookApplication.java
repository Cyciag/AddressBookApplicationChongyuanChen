/**
 *
 * @author Chongyuan Chen
 * @since January 2020
 *
 * main AddressBookApplication: purpose is to invoke some methods of the Menu class
 **/

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The main class that prompts for the user's choice
 */
class AddressBookApplication
{
    public static void main(String args[]) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        AddressBook ab = new AddressBook();
        while(true)
        {
            int choice = Menu.menuSelection();
            if(choice == 1)
            {
                Menu.loadFromFile(ab);
            }
            else if(choice == 2)
            {
                Menu.addEntry(ab);
            }
            else if(choice == 3)
            {
                Menu.removeEntry(ab);
            }
            else if(choice == 4)
            {
                Menu.findEntry(ab);
            }
            else if(choice == 5)
            {
                Menu.entriesList(ab);
            }
            else if(choice == 6)
            {
                break;
            }
            else
            {
                System.out.println("Please enter a number from 1 to 7.");
            }
        }
    }
}

