package com.multi.contactsapp.springdatarest.repository;

import com.multi.contactsapp.springdatarest.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
