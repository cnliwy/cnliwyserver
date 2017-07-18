package com.liwy.server.dao;

import com.liwy.server.dao.base.BaseDaoImpl;
import com.liwy.server.dao.idao.PushDataDao;
import com.liwy.server.entity.PushData;
import org.springframework.stereotype.Repository;

/**
 * Created by liwy on 2017/7/18.
 */
@Repository("pushDataDao")
public class PushDataImpl extends BaseDaoImpl<PushData> implements PushDataDao {
}
