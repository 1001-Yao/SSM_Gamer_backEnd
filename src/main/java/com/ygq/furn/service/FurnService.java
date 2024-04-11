package com.ygq.furn.service;

import com.ygq.furn.bean.Furn;

import java.util.List;

public interface FurnService {
    public void save(Furn furn);

    List<Furn>findAll();

   void deleteById(int id);


   void upDate(Furn furn);

   public List<Furn> findByCondition(String name);


}
