package com.liwy.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liwy on 2017/7/19.
 */
@Entity
@Table(name = "tb_plan")
public class PlanData {
    public PlanData(int planDays, String planTitle, String planContent, String receiverId, String userId, Date createTime, Date startTime) {
        this.planDays = planDays;
        this.planTitle = planTitle;
        this.planContent = planContent;
        this.receiverId = receiverId;
        this.userId = userId;
        this.createTime = createTime;
        this.startTime = startTime;
    }

    @Id
    @Column(name = "id",unique=true, nullable=false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "plan_days")
    private int planDays;

    @Column(name = "plan_title")
    private String planTitle;

    @Column(name = "plan_content")
    private String planContent;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "user_id")
    private String userId;

    @Column(name="create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name="start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Override
    public String toString() {
        return "PlanData{" +
                "id='" + id + '\'' +
                ", planDays=" + planDays +
                ", planTitle='" + planTitle + '\'' +
                ", planContent='" + planContent + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", userId='" + userId + '\'' +
                ", createTime=" + createTime +
                ", startTime=" + startTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlanDays() {
        return planDays;
    }

    public void setPlanDays(int planDays) {
        this.planDays = planDays;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
