package com.microservice.lost.iservices;

import com.microservice.lost.entities.Lost;

import java.util.List;

public interface ILostService {

    public Lost saveLost(Lost lost);
    public List<Lost> getAllLost();
    public Lost getLostByID(Integer id);
    public List<Lost> getLostByUserId(Integer id);
    public List<Lost> getLostByBookId(Integer id);

}
