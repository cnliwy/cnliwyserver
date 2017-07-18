package com.liwy.server.service.iservice;

import com.liwy.server.entity.PushData;

import java.util.List;

/**
 * Created by liwy on 2017/7/18.
 */
public interface PushService {
    public List<PushData> list(String senderId);
    public void insert(PushData pushData);
    public void delete(String id);
}
