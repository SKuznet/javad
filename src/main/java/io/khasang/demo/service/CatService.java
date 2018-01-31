package io.khasang.demo.service;

import io.khasang.demo.entity.Cat;

import java.util.List;

public interface CatService {
    /**
     * method for receiving all cats
     *
     * @return all cats
     * */
    List<Cat> getAllCats();

    /**
     * method for receiving specify cat
     *
     * @param id = cat id
     * @return cat by id
     * */
    Cat getCatById(long id);

    /**
     * method for add cat
     *
     * @param cat = new cat for creation
     * @return created cat
     * */
    Cat addCat(Cat cat);

    /**
     * method for delete cat by id
     *
     * @param id = id cat for delete
     * @return deleted cat
     * */
    Cat deleteCat(long id);
}
