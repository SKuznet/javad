package io.khasang.demo.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     *
     * */
    Session getSessionFactory();

    /**
     * method for receiving all entity
     *
     * @return all entity
     * */
    List<T> getList();

    /**
     * method for receiving specify entity
     *
     * @param id = entity id
     * @return entity by id
     * */
    T getById(long id);

    /**
     * method for add entity
     *
     * @param entity = new entity for creation
     * @return created entity
     * */
    T create(T entity);

    /**
     * method for delete entity by id
     *
     * @param entity = id entity for delete
     * @return deleted entity
     * */
    T delete(T entity);
}
