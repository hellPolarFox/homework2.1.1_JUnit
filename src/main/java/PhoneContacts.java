import java.util.*;

public class PhoneContacts {

    protected final String group;
    protected Map<String, List<Contact>> phoneBook = new HashMap<>();

    public PhoneContacts(String group) {
        this.group = group;
    }

    public String getGroupName() {
        return group;
    }

    public void addGroupToMap(String groupName) {
        phoneBook.put(groupName, new ArrayList<>());
    }

    public void addContactToPhoneBook(Contact contact, String inputGroup) {
        if (phoneBook.containsKey(inputGroup)) {
            List<Contact> listFromMap = phoneBook.get(inputGroup);
            listFromMap.add(contact);
            listFromMap.sort(new BySurnameComparator());
            phoneBook.put(inputGroup, listFromMap);
        }
    }

    public void displayPhoneBook() {
        System.out.println("Группы в справочнике:");
        for (Map.Entry<String, List<Contact>> phoneBookEntry : phoneBook.entrySet()) {
            System.out.println("  - " + phoneBookEntry.getKey());
            for (Contact c : phoneBookEntry.getValue()) {
                System.out.println("      " + c.getName() + " " + c.getSurname()
                        + ", телефон: " + c.getNumber());
            }
            System.out.println("  ---------");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PhoneContacts that = (PhoneContacts) obj;
        return Objects.equals(group, that.group);
    }

    @Override
    public int hashCode() {
        int result = 31 * (group != null ? group.hashCode() : 0);
        return result;
    }
}

