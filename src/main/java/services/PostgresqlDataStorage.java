package services;

import data.Contact;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class PostgresqlDataStorage implements DataStorage {
    @Inject
    ContactDAOJPA contactDAOJPA;

    @Override
    public Contact createContact(Contact contact) {
        contactDAOJPA.create(contact);
        return contact;
    }

    @Override
    public Contact retrieveContact(String nif) {
        return null;
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public Contact deleteContact(String nif) {
        return null;
    }

    @Override
    public Collection<Contact> getContacts() {
        return null;
    }
}
