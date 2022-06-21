package com.multi.contactssvc.dao;

import com.multi.contactssvc.domain.Contact;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRestDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<Contact> getContactList() {
        return sqlSession.selectList("contact.selectall");
    }

    public List<Contact> getContactList(int pageNo, int pageSize) {
        int offset = (pageNo - 1) * pageSize;
        int limit = pageSize;

        return sqlSession.selectList("contact.selectall", null, new RowBounds(offset, limit));
    }

    public int getContactCount() {
        return sqlSession.selectOne("contact.selectcnt");
    }

    public Contact getContactOne(Contact c) {
        return sqlSession.selectOne("contact.selectone", c);
    }

    public long insertContact(Contact c) {
        sqlSession.insert("contact.insert", c);
        return c.getNo();
    }

    public int updateContact(Contact c) {
        return sqlSession.update("contact.update", c);
    }

    public int deleteContact(Contact c) {
        return sqlSession.delete("contact.delete", c);
    }

}
