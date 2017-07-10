package com.liwy.server.service;

import com.liwy.server.dao.idao.AppDataDao;
import com.liwy.server.entity.AppData;
import com.liwy.server.service.iservice.AppDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liwy on 2017/7/10.
 */
@Repository("appDataService")
public class AppDataImpl implements AppDataService{
    @Autowired
    private AppDataDao appDataDao;


    public List<AppData> getAppDatas(String userId) {
        return appDataDao.find("from AppData where userId = '" + userId + "'");
    }

    public boolean insert(AppData appData) {
        Serializable serializable =  appDataDao.save(appData);
        if (serializable != null){
            System.out.println("AppData Id = " + serializable.toString());
            return true;
        }
        return false;
    }

    public void delete(AppData appData) {
        appDataDao.delete(appData);
    }

    public void update(AppData appData) {
        appDataDao.update(appData);
    }
}
