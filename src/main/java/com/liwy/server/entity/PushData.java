package com.liwy.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liwy on 2017/7/18.
 */
@Entity
@Table(name = "tb_push_record")
public class PushData {
    @Id
    @Column(name = "id",unique=true, nullable=false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "push_type")
    private String pushType;

    @Column(name = "notify_title")
    private String notifyTitle;

    @Column(name = "notify_content")
    private String notifyContent;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name="push_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pushTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}
