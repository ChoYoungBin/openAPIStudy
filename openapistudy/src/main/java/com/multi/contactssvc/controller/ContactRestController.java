package com.multi.contactssvc.controller;

import com.multi.contactsapp.util.ApiException;
import com.multi.contactssvc.domain.Contact;
import com.multi.contactssvc.domain.ContactList;
import com.multi.contactssvc.domain.Result;
import com.multi.contactssvc.service.ContactRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contacts")
public class ContactRestController {
    @Autowired
    private ContactRestService contactRestService;

    @GetMapping
    public ContactList getContactList(@RequestParam(value = "pageno", required = false, defaultValue = "0") int pageNo,
                                      @RequestParam(value = "pagesize", required = false, defaultValue = "3") int pageSize) {
        ContactList contactList = null;
        if (pageNo < 1) {
            contactList = contactRestService.getContactList();
        } else {
            if (pageSize < 2) pageSize = 3;
            contactList = contactRestService.getContactList(pageNo, pageSize);
        }
        return contactList;
    }

    @GetMapping("{no}")
    public Contact getContact(@PathVariable("no") long no) {
        Contact contact = new Contact();
        contact.setNo(no);
        return contactRestService.getContactOne(contact);
    }

    @PostMapping()
    public Result insertContact(@RequestBody Contact contact) {
        String name = contact.getName();
        String tel = contact.getTel();
        if (name == null || name.equals("") ||tel == null || tel.equals("")) {
            throw new ApiException("이름과 전화번호는 필수 입력 항목입니다.", "102");
        }

        return contactRestService.insertContact(contact);
    }
    @PutMapping("{no}")
    public Result updateContact(@PathVariable("no") int no, @RequestBody Contact contact) {
        String name = contact.getName();
        String tel = contact.getTel();
        if (name == null || name.equals("") ||tel == null || tel.equals("")) {
            throw new ApiException("이름과 전화번호는 필수 입력 항목입니다.", "102");
        }
        contact.setNo(no);

        return contactRestService.updateContact(contact);
    }

    @DeleteMapping("{no}")
    public Result updateContact(@PathVariable("no") int no) {
        Contact c = new Contact();
        c.setNo(no);
        return contactRestService.deleteContact(c);
    }

}
