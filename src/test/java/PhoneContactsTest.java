import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneContactsTest {

    private PhoneContacts phoneContacts;
    private Contact contact;
    private List<Contact> list = new ArrayList<>();

    @BeforeEach
    void before() {
        phoneContacts = new PhoneContacts("test");
        contact = new Contact("a", "b", "1");
    }

    @Test
    void whenAddingNewGroupToMap() {
        String group = "test";
        phoneContacts.addGroupToMap(group);

        Assertions.assertTrue(phoneContacts.phoneBook.containsKey(group));
    }

    @Test
    void whenAddingNewContactToMap() {
        String group = "test";
        list.add(contact);

        phoneContacts.addGroupToMap(group);
        phoneContacts.addContactToPhoneBook(contact, group);

        Assertions.assertEquals(list, phoneContacts.phoneBook.get(group));
    }

    @Test
    void whenCreatingNewContactFromConsoleWithoutPhoneNumber() {
        String input = "name surname";
        String[] parts = input.split(" ");

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> contact = new Contact(parts[0], parts[1], parts[2]));
    }

}
