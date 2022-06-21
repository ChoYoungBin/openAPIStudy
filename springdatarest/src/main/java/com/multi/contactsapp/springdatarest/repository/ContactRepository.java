package com.multi.contactsapp.springdatarest.repository;

import com.multi.contactsapp.springdatarest.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts2")
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @RestResource(path = "findbyname")
    List<Contact> findByNameContainingOrderByNameDesc(@Param("name") String name);
}
