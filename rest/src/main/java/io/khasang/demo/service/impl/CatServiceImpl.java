package io.khasang.demo.service.impl;

import io.khasang.demo.dao.CatDao;
import io.khasang.demo.entity.Cat;
import io.khasang.demo.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catService")
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDao catDao;

    @Override
    public List<Cat> getAllCats() {
        return catDao.getList();
    }

    @Override
    public Cat getCatById(long id) {
        return catDao.getById(id);
    }

    @Override
    public Cat deleteCat(long id) {
        return catDao.delete(catDao.getById(id));
    }

    @Override
    public Cat addCat(Cat cat) {
        return catDao.create(cat);
    }
}
