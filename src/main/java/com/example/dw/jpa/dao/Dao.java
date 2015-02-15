package com.example.dw.jpa.dao;

import java.util.List;
import java.util.Map;

public interface Dao {

    public <T> void persist(final T object);

    public <T, ID> T findById(final Class<T> clazz, final ID id);

    public <T> T merge(final T object);

    public <T> void remove(final T object);

    public <T, ID> void removeById(final Class<T> clazz, final ID id);

    public <T> List<T> findAll(final Class clazz);

    public <T> List<T> find(final Class<T> clazz, final String namedQuery, final Map<String, Object> paramsMap);

}
