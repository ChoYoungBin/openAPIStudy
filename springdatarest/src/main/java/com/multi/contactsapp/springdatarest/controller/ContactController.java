package com.multi.contactsapp.springdatarest.controller;

import com.multi.contactsapp.springdatarest.domain.Contact;
import com.multi.contactsapp.springdatarest.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactRepository repository;

    @GetMapping
    public List<Contact> getContactAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"no"));
    }

    @GetMapping("{no}")
    public Optional<Contact> getContactOne(@PathVariable("no") long no) {
        return repository.findById(no);
    }
    @PostMapping
    public Contact insertContact(@RequestBody Contact c) {
        return repository.save(c);
    }
    @PutMapping("{no}")
    public Contact updateContact(@RequestBody Contact c, @PathVariable("no") long no) {
        c.setNo(no);
        return repository.save(c);
    }
    @DeleteMapping("{no}")
    public void deleteContact(@PathVariable("no") long no) {
        repository.deleteById(no);
    }
}
