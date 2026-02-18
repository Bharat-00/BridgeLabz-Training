package addressbook.presentation;

import addressbook.model.*;
import addressbook.service.*;
import addressbook.io.*;

public class AddressBookMain {

    public static void main(String[] args) throws Exception {

        AddressBookService service = new AddressBookService();
        service.createBook("MyBook");

        Contact c1 = new Contact("Bharat","Trivedi","9999999999","Mathura","UP");
        Contact c2 = new Contact("Tulsi","Trivedi","8888888888","Delhi","Delhi");

        service.addContact("MyBook", c1);
        service.addContact("MyBook", c2);

        service.editContact("MyBook", "Bharat",
                new Contact("Bharat","Trivedi","7777777777","Noida","UP"));

        service.deleteContact("MyBook", "Tulsi");

        CSVIOService csv = new CSVIOService();
        JsonIOService json = new JsonIOService();

        csv.write(service.getBook("MyBook"));
        json.write(service.getBook("MyBook"));

        System.out.println("Address Book Project Executed Successfully");
    }
}
