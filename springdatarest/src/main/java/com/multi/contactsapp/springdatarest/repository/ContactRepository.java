package com.multi.contactsapp.springdatarest.repository;

import com.multi.contactsapp.springdatarest.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel ="contacts", path = "contacts2")
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
