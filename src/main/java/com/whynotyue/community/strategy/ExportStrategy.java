package com.whynotyue.community.strategy;

import java.util.List;

public abstract class ExportStrategy {

    // 通用属性
    protected String[] titles;
    protected String[] keys;
    protected List<Object> dataList;

    public abstract String export();

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getKeys() {
        return keys;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }
}
