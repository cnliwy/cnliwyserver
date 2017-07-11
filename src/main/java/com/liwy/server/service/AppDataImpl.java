package com.liwy.server.service;

import com.liwy.server.dao.idao.AppDataDao;
import com.liwy.server.entity.AppData;
import com.liwy.server.service.iservice.AppDataService;
import com.liwy.server.utils.StringUtils;
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


    public List<AppData> getAppDatas(String userId,String jsonKey) {
        String hql = "from AppData where userId = '" + userId + "'";
        if (!StringUtils.isNull(jsonKey)){
            hql += " and jsonKey='" + jsonKey + "'";
        }
        return appDataDao.find(hql);
    }

    public boolean insert(AppData appData) {
        Serializable serializable =  appDataDao.save(appData);
        if (serializable != null){
            System.out.println("AppData Id = " + serializable.toString());
            return true;
        }
        return false;
    }

    public void delete(String id) {
        AppData appData = appDataDao.get(AppData.class,(Serializable) id);
        appDataDao.delete(appData);
    }

    public void update(AppData appData) {
        AppData dbData = appDataDao.get(AppData.class,appData.getId());
        dbData.setJsonKey(appData.getJsonKey());
        dbData.setJsonData(appData.getJsonData());
        appDataDao.update(dbData);
    }
}
