package com.ygq.furn.service.impl;

import com.ygq.furn.bean.Furn;
import com.ygq.furn.bean.FurnExample;
import com.ygq.furn.dao.FurnMapper;
import com.ygq.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnServiceImpl implements FurnService {

    @Autowired
    FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
       return furnMapper.selectByExample(null);
    }


    @Override
    public void deleteById(int id) {
        furnMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void upDate(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample=new FurnExample();

        FurnExample.Criteria criteria=furnExample.createCriteria();

        if(!(null==name||"".equals(name))){
            criteria.andNameLike("%"+name+"%");
        }
        return furnMapper.selectByExample(furnExample);
    }

}
