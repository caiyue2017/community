package com.whynotyue.community.entity;

// 封装分页的相关信息
public class Page {

    // 当前页码
    private int current = 1;
    // 每页显示的数目
    private int limit = 10;
    // 总数目（用于计算总页数）
    private int rows;
    // 查询路径（用于复用分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100)
            this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // 当前页的起始页码
    public int getOffset() {
        return (current - 1) * limit;
    }

    // 总页数
    public int getTotal() {
        if (rows % limit == 0)
            return rows / limit;
        else
            return rows / limit + 1;
    }

    // 起始页码
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    // 结束页码
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

}
