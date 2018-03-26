package com.ht.common;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

    public List<T> queryAll();

    public T queryById(Serializable id);

    public void add(T t);

    public void update(T t);

    public void deleteById(Serializable id);

    public int countByCriteria(T t);

}