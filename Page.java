package com.atguigu.util;

import java.util.List;

public class Page<T> {
	private Integer pageno; //当前页
	private Integer pagesize; //一页多少条
	private List<T> datas;  //数据
	private Integer totalsize;  //总条数
	private Integer totalno;  //总页数
	public Page(Integer pageno, Integer pagesize) {
		if(pageno <=0) {
			this.pageno=1;
		}else {
			this.pageno = pageno;
		}
		if(pagesize <=0) {
			this.pagesize=1;
		}else {
			this.pagesize = pagesize;
		}
	}
	public Integer getPageno() {
		return pageno;
	}
	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public Integer getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(Integer totalsize) {
		this.totalsize = totalsize;
		this.totalno=(totalsize%pagesize)==0?(totalsize/pagesize):(totalsize/pagesize+1);
	}
	public Integer getTotalno() {
		return totalno;
	}
	private void setTotalno(Integer totalno) {
		this.totalno = totalno;
	}
	//获取开始索引
	public Integer getStartIndex() {
		return (this.pageno-1)*pagesize;
	}
	
}
