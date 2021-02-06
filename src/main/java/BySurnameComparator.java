import java.util.Comparator;

public class BySurnameComparator implements Comparator<Contact> {

    public int compare (Contact contact1, Contact contact2) {
        String contactSurname1 = contact1.getSurname();
        String contactSurname2 = contact2.getSurname();
        return contactSurname1.compareTo(contactSurname2);
    }
}
