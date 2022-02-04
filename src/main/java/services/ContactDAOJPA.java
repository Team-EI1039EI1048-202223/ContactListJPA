package services;

import data.Contact;
import data.PostalAddress;
import org.hibernate.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class ContactDAOJPA implements ContactDAO {
    @Inject
    EntityManager em;

    @Override
    @Transactional
    public boolean create(Contact contact) {
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
        em.persist(contact);
//        tx.commit();
        return true;
    }

    @Override
    public Contact retrieve(String nif) {
        return em.find(Contact.class, nif);
    }

    @Override
    public Contact update(Contact contact) {
        Contact found = em.find(Contact.class, contact.getNIF());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        found.update(contact);
        tx.commit();
        return found;
    }

    @Override
    public Contact delete(String nif) {
        Contact found = em.find(Contact.class, nif);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(found);
        tx.commit();
        return found;
    }
}
