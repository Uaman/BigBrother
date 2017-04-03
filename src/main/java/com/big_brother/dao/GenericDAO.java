package com.big_brother.dao;

import java.util.List;

public interface GenericDAO {
    <T> T save(T o);

    void delete(Object object);

    <T> T get(Class<T> type, Long id);

    <T> T get(Class<T> type, Integer id);

    <T> T merge(T o);

    <T> void saveOrUpdate(T o);

    <T> List<T> getAll(Class<T> type);
}