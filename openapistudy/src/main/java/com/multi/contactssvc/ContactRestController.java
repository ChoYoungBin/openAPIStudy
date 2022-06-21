package com.multi.contactssvc;

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

    @PutMapping
    public Result updateContact(@RequestBody Contact contact) {
        return contactRestService.updateContact(contact);
    }

    @PostMapping
    public Result insertContact(@RequestBody Contact c) {
        return contactRestService.insertContact(c);
    }

    @DeleteMapping("{no}")
    public Result updateContact(@PathVariable("no") int no) {
        Contact c = new Contact();
        c.setNo(no);
        return contactRestService.deleteContact(c);
    }

}
