package io.khasang.demo.dao;

import io.khasang.demo.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat> {
    /**
     *
     * */
    List<Cat> getCatsByName(String name);
}
