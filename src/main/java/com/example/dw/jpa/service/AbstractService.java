package com.example.dw.jpa.service;

import com.example.dw.jpa.dao.Dao;
import com.google.common.reflect.TypeToken;
import java.util.List;
import javax.inject.Inject;

public abstract class AbstractService<T> {

    @Inject
    protected Dao dao;

    protected final Class<T> entityClass;

    public AbstractService() {
        entityClass = (Class<T>) TypeToken.of(getClass()).resolveType(AbstractService.class.getTypeParameters()[0]).getRawType();
    }

    public void save(final T object) {
        dao.persist(object);
    }

    public <ID> T findById(final ID id) {
        return dao.findById(entityClass, id);
    }

    public List<T> findAll() {
        return dao.findAll(entityClass);
    }

    public void delete(final T object) {
        dao.remove(object);
    }

    public <ID> void deleteById(final ID id) {
        dao.removeById(entityClass, id);
    }
}
