package com.multi.contactssvc.controller;


import com.multi.contactssvc.domain.Contact;
import com.multi.contactssvc.domain.ContactList;
import com.multi.contactssvc.service.ContactRestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ContactRestControllerTest {

    @MockBean
    ContactRestService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    void test_getAllContacts_ReturnsOkWithListOfContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "홍길동", "010-2222-1111", "서울"));
        contacts.add(new Contact(2, "이몽룡", "010-2222-1112", "제주"));
        contacts.add(new Contact(3, "성춘향", "010-2222-1113", "경기"));
        contacts.add(new Contact(4, "박문수", "010-2222-1114", "강원"));


        ContactList contactList = new ContactList(1, 4, 100, contacts);


        when(service.getContactList()).thenReturn(contactList);
    }

    @Test
    void test_getContactList_ReturnsOkWithList() throws Exception {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "홍길동", "010-2222-1111", "서울"));
        contacts.add(new Contact(2, "이몽룡", "010-2222-1112", "제주"));
        contacts.add(new Contact(3, "성춘향", "010-2222-1113", "경기"));
        contacts.add(new Contact(4, "박문수", "010-2222-1114", "강원"));
        ContactList contactList = new ContactList(1, 4, 100, contacts);


        when(service.getContactList()).thenReturn(contactList);


        mockMvc.perform(get("/contacts").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageNo", is(1)))
                .andExpect(jsonPath("$.contacts", hasSize(4)))
                .andExpect(jsonPath("$.contacts[0].no", is(1)))
                .andExpect(jsonPath("$.contacts[3].address", is("강원")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void test_invalidRequest_ReturnsBadRequest() throws Exception {
        mockMvc.perform(request(GET, "/test/error1").accept(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

}