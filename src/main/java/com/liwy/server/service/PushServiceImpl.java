package com.liwy.server.service;

import com.liwy.server.dao.idao.PushDataDao;
import com.liwy.server.entity.PushData;
import com.liwy.server.service.iservice.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liwy on 2017/7/18.
 */
@Repository("pushService")
public class PushServiceImpl implements PushService{
    @Autowired
    private PushDataDao pushDataDao;

    public List<PushData> list(String senderId) {
        List<PushData> list = pushDataDao.find("from PushData where senderId='" + senderId + "'");
        return list;
    }

    public void insert(PushData pushData) {
        pushDataDao.save(pushData);
    }

    public void delete(String id) {
        PushData pushData = pushDataDao.get(PushData.class,(Serializable) id);
        if (pushData != null)
            pushDataDao.delete(pushData);
    }
}
