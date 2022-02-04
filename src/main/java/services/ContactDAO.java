package services;

import data.Contact;

public interface ContactDAO {
    Contact create(Contact contact);
    Contact retrieve(String nif);
    Contact update(Contact contact);
    Contact delete(String nif);
}
