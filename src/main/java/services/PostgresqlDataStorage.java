package services;

import data.Contact;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class PostgresqlDataStorage implements DataStorage {
    @Inject
    EntityManager em;

    @Inject
    ContactDAOJPA contactDAOJPA;

    @Override
    public Contact createContact(Contact contact) {
        contactDAOJPA.create(contact);
        return contact;
    }

    @Override
    public Contact retrieveContact(String nif) {
        return contactDAOJPA.retrieve(nif);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }

    @Override
    public Contact deleteContact(String nif) {
        return contactDAOJPA.delete(nif);
    }

    @Override
    public Collection<Contact> getContacts() {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAll", Contact.class);
//        List<Contact> people = query.getResultList();
//        return new Contact(people);
        return query.getResultList();
    }
}
