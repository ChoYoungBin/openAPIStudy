package com.multi.contactssvc.service;

import com.multi.contactssvc.dao.ContactRestDAO;
import com.multi.contactssvc.domain.Contact;
import com.multi.contactssvc.domain.ContactList;
import com.multi.contactssvc.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRestService {
    @Autowired
    private ContactRestDAO contactRestDAO;

    public ContactList getContactList() {
        List<Contact> contactList = contactRestDAO.getContactList();

        return new ContactList(0, 0, contactList.size(), contactList);
    }

    public ContactList getContactList(int pageNo, int pageSize) {
        List<Contact> contactList = contactRestDAO.getContactList(pageNo, pageSize);
        int totalCount = contactRestDAO.getContactCount();
        return new ContactList(pageNo, pageSize, totalCount, contactList);
    }

    public Contact getContactOne(Contact c) {
        return contactRestDAO.getContactOne(c);
    }

    public Result insertContact(Contact c) {
        Result result = new Result();
        try {
            long no = contactRestDAO.insertContact(c);
            result.setStatus("ok");
            result.setMessage("연락처 추가 성공. id = " + no);
            result.setKey("" + no);
        } catch (Exception e) {
            result.setStatus("fail");
            result.setMessage(e.getMessage());
            result.setKey("");
        }
        return result;
    }

    public Result updateContact(Contact c) {
        Result result = new Result();
        try {
            int count = contactRestDAO.updateContact(c);
            result.setStatus("ok");
            result.setMessage(count + "건의 연락처 변경 성공");
            result.setKey(c.getNo() + "");
        } catch (Exception e) {
            result.setStatus("fail");
            result.setMessage(e.getMessage());
            result.setKey("");
        }
        return result;
    }

    public Result deleteContact(Contact c) {
        Result result = new Result();
        try {
            int count = contactRestDAO.deleteContact(c);
            result.setStatus("ok");
            result.setMessage(count + "건의 연락처 삭제 성공");
            result.setKey(c.getNo() + "");
        } catch (Exception e) {
            result.setStatus("fail");
            result.setMessage(e.getMessage());
            result.setKey("");
        }
        return result;
    }

}
