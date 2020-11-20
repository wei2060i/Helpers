package com.atguigu.util;

import java.util.List;

public class Page<T> {
   /**
     * 当前页
     */
    @Getter
    private Integer pageNo;
    /**
     * 一页多少条
     */
    @Getter
    @Setter
    private Integer pageSize;
    /**
     * 数据
     */
    @Getter
    @Setter
    private List<T> data;

    /**
     * 总条数
     */
    @Getter
    private Integer totalSize;
    /**
     * 总页数
     */
    @Getter
    private Integer totalNo;

    public Page(Integer pageNo, Integer pageSize) {
        if (pageNo <= 0) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
        this.totalNo = (totalSize % pageSize) == 0 ? (totalSize / pageSize) : (totalSize / pageSize + 1);
    }

    /**
     * 获取开始索引
     */
    public Integer getStartIndex() {
        return (this.pageNo - 1) * pageSize;
    }
}
