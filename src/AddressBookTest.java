import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddressBookTest {
    ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();
    @Test
    public void add(AddressEntry entry)
    {
        addressEntryList.add(entry);
    }

    public void list()
    {
        System.out.println(addressEntryList.get(0).toString());
    }

}