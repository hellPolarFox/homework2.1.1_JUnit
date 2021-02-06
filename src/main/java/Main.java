import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneContacts groupOfContacts = new PhoneContacts("");

        System.out.println("Программа \"Телефонный справочник\"");

        boolean groupAdded = false;

        while (true) {

            if (!groupAdded) {
                System.out.println("Введите название группы контактов:");
            } else {
                System.out.println("Создать еще одну группу (введите название или введите нет)?");
            }

            String input = scanner.nextLine();
            if (input.equals("нет")) {
                break;
            }

            groupOfContacts.addGroupToMap(input);
            groupAdded = true;

        }

        while (true) {

            System.out.println("Создать контакт (введите в формате 'Имя Фамилия Номер' или введите нет)?");
            String inputContact = scanner.nextLine();

            if (inputContact.equals("нет")) {
                groupOfContacts.displayPhoneBook();
                break;
            }

            String[] parts = inputContact.split(" ");
            Contact contact = new Contact(parts[0], parts[1], parts[2]);

            System.out.println("Укажите группы контакта через пробел");
            String inputGroup = scanner.nextLine();

            try {
                String[] groupsString = inputGroup.split(" ");

                for (String s : groupsString) {
                    groupOfContacts.addContactToPhoneBook(contact, s);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                groupOfContacts.addContactToPhoneBook(contact, inputGroup);
            }
        }

    }

}

