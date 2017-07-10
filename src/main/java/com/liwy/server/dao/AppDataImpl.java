package com.liwy.server.dao;

import com.liwy.server.dao.base.BaseDaoImpl;
import com.liwy.server.dao.idao.AppDataDao;
import com.liwy.server.entity.AppData;
import org.springframework.stereotype.Repository;

/**
 * Created by liwy on 2017/7/10.
 */
@Repository("appDataDao")
public class AppDataImpl extends BaseDaoImpl<AppData> implements AppDataDao {
}
