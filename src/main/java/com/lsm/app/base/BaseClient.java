package com.lsm.app.base;


import java.util.HashMap;

public interface BaseClient {
    Integer save(Object object);

    Integer remove(Object object);

    Integer update(Object object);

    HashMap query(Integer id, Class c);
}
