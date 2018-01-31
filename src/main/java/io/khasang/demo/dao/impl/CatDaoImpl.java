package io.khasang.demo.dao.impl;

import io.khasang.demo.dao.CatDao;
import io.khasang.demo.entity.Cat;

import java.util.List;

public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {

    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Cat> getCatsByName(String name) {
        return null;
    }
}
