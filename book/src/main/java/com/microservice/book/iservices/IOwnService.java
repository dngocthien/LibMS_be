package com.microservice.book.iservices;

import com.microservice.book.entities.Own;

import java.util.List;

public interface IOwnService {

    public Own saveOwn(Own user);
    public List<Own> getAllOwn();
    List<Own> getOwnByBookId(Integer id);
    public void deleteOwn(Integer id);

    public void deleteOwnByBookId(Integer id);
}
