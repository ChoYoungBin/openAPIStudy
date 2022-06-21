package com.multi.contactsapp.controller;

import com.multi.contactsapp.domain.Contact;
import com.multi.contactsapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/app/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public void getContactList(Model model) {
        List<Contact> contacts = contactService.getContactList();
        model.addAttribute("contacts", contacts);

    }

    @PostMapping("/add")
    public String insertContact(Contact contact) {
        contactService.insertContact(contact);

        return "redirect:/contacts";
    }

    @PostMapping("/update")
    public String updateContact(Contact contact) {
        contactService.updateContact(contact);

        return "redirect:/contacts";
    }

}
