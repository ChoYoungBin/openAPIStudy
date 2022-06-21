package com.multi;

import com.multi.contactsapp.util.ApiException;
import com.multi.contactssvc.domain.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping("error1")
    public Contact getTestContactOne(@RequestParam(value = "name", required = false) String name) {
        if (name == null || name.trim().equals("")) {
            throw new ApiException("Parameter [name]  is null");
        }

        return new Contact(0, name, "", "");
    }

}
