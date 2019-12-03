package com.lsm.app.base;


import java.util.HashMap;

public interface BaseClient<T> {

    /**
     * 单条插入
     *
     * @param t
     * @return
     */
    Integer save(T t);

    /**
     * 批量插入
     *
     * @return
     */
    Integer saveBatch();

    /**
     * 单个删除
     *
     * @param t
     * @return
     */
    Integer remove(T t);

    /**
     * 批量删除
     *
     * @param t
     * @return
     */
    Integer removeBatch(T t);

    /**
     * 单个修改
     *
     * @param t
     * @return
     */
    Integer update(T t);

    /**
     * 批量修改
     *
     * @param t
     * @return
     */
    Integer updateBatch(T t);

    /**
     * 查询
     *
     * @param id
     * @param c
     * @return
     */
    HashMap query(Integer id, Class c);
}
