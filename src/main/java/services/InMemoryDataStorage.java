package services;

import data.Contact;
import data.PostalAddress;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class InMemoryDataStorage implements DataStorage {
    Map<String, Contact> contacts = new HashMap<>();

    public InMemoryDataStorage() {
        super();

        PostalAddress postalAddress = new PostalAddress("Av. Vicente Sos Baynat", 1, 1, "TI1203");
        contacts.put("1", new Contact("Óscar", "Belmonte", "1", postalAddress));
        contacts.put("2", new Contact("MC", "Erdozain", "2", postalAddress));
        contacts.put("3", new Contact("Martín", "Belmonte", "3", postalAddress));
        contacts.put("4", new Contact("Gonzalo", "Belmonte", "4", postalAddress));
    }

    @Override
    public Contact createContact(Contact contact) {
        if (contacts.containsKey(contact.getNIF())) return Contact.NOT_FOUND;

        return contacts.put(contact.getNIF(), contact);
    }

    @Override
    public Contact retrieveContact(String nif) {
        if (contacts.containsKey(nif) == false) return Contact.NOT_FOUND;

        return contacts.get(nif);
    }

    @Override
    public Contact updateContact(Contact contact) {
        if (contacts.containsKey(contact.getNIF()) == false) return Contact.NOT_FOUND;

        return contacts.put(contact.getNIF(), contact);
    }

    @Override
    public Contact deleteContact(String nif) {
        if (contacts.containsKey(nif) == false) return Contact.NOT_FOUND;

        return contacts.remove(nif);
    }

    @Override
    public Collection<Contact> getContacts() {
        return contacts.values();
    }
}
