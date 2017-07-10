package com.liwy.server.service.iservice;

import com.liwy.server.entity.AppData;

import java.util.List;

/**
 * Created by liwy on 2017/7/10.
 */
public interface AppDataService {
    public List<AppData> getAppDatas(String userId);

    public boolean insert(AppData appData);

    public void delete(AppData appData);

    public void update(AppData appData);
}
