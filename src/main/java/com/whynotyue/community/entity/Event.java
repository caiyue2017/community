package com.whynotyue.community.entity;

import java.util.HashMap;
import java.util.Map;

public class Event {

    // 主题（事件类型）
    private String topic;
    // 事件触发者（进行评论/点赞/关注的人）
    private int userId;
    // 事件发生的实体（评论/点赞/关注）
    private int entityType;
    private int entityId;
    // 实体对应的用户（被评论/点赞/关注的人）
    private int entityUserId;
    // 存放额外的数据，让 Event 更具有扩展性
    private Map<String, Object> data = new HashMap<>();

    public String getTopic() {
        return topic;
    }

    public Event setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    // set() 返回类型不是 void，而是 Event
    // 为了便于开发，可以 new Event().setUserId().setEntityId()...
    // PS：
    // 虽然老师这样讲，但不要这么做，违背了「封装」的意义
    // 本来把属性设置 private，对外只提供 get 获取，好家伙你 set 直接返回对象了。
    // 再者，很多框架都是默认 set 返回 void 的，改了可能有不可预知的错误。
    public Event setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getEntityType() {
        return entityType;
    }

    public Event setEntityType(int entityType) {
        this.entityType = entityType;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public Event setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    public int getEntityUserId() {
        return entityUserId;
    }

    public Event setEntityUserId(int entityUserId) {
        this.entityUserId = entityUserId;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Event setData(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

}
