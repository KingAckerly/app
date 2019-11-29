package com.lsm.app.base.impl;

import annotation.Column;
import annotation.Id;
import annotation.Table;
import com.lsm.app.base.BaseClient;
import com.lsm.app.dao.BaseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "BaseClient")
public class BaseClientImpl implements BaseClient {

    private static Logger logger = LoggerFactory.getLogger(BaseClientImpl.class);

    @Resource
    private BaseDao baseDao;

    private Map<String, Object> transformObj(Object t) {
        //获取表名
        if (null == t.getClass().getAnnotation(Table.class)) {
            throw new RuntimeException("Error Input Object! Error @Table Annotation.");
        }
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("TABLE_NAME", t.getClass().getAnnotation(Table.class).value());
        Method[] m = t.getClass().getMethods();
        if (null == m || m.length <= 0) {
            throw new RuntimeException("Error Input Object! No Method.");
        }
        List k = new ArrayList();//存放列名
        List v = new ArrayList();//存放列值
        for (Method i : m) {
            //获取列名和值
            try {
                if (null != i.getAnnotation(Column.class)) {
                    k.add(i.getAnnotation(Column.class).value());
                    v.add(i.invoke(t, null));
                    continue;
                }
                //获取主键
                if (null != i.getAnnotation(Id.class)) {
                    re.put("KEY_ID", i.getAnnotation(Id.class).value());
                    re.put("KEY_VALUE", i.invoke(t, null));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            }
        }
        re.put("COLUMNS", k);
        re.put("VALUES", v);
        if (k.size() != v.size()) {
            throw new RuntimeException("Error Input Object! Internal Error.");
        }
        return re;
    }

    @Override
    public Integer save(Object object) {
        Map<String, Object> params = transformObj(object);
        logger.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseDao.save(params);
    }

    @Override
    public Integer remove(Object object) {
        return null;
    }

    @Override
    public Integer update(Object object) {
        return null;
    }

    @Override
    public HashMap query(Integer id, Class c) {
        return null;
    }
}
