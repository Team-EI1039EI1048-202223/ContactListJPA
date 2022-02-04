package services;

import data.Contact;
import data.PostalAddress;
import org.hibernate.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
public class ContactDAOJPA implements ContactDAO {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public Contact create(Contact contact) {
        em.persist(contact);
        return contact;
    }

    @Override
    public Contact retrieve(String nif) {
        return em.find(Contact.class, nif);
    }

    @Override
    @Transactional
    public Contact update(Contact contact) {
        Contact found = em.find(Contact.class, contact.getNIF());
        found.update(contact);
        return found;
    }

    @Override
    @Transactional
    public Contact delete(String nif) {
        Contact found = em.find(Contact.class, nif);
        em.remove(found);
        return found;
    }

    public Collection<Contact> getContacts() {
        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAll", Contact.class);
        return query.getResultList();
    }

}
