package com.springmvc.newpackage.result;

public class Result {
	//布尔值
	private boolean flag;
	//int
	private int no;
	private int pageNow;
	private int pageSplit;
	
	
	//long（用于计算商品总数，数据库的count是long类型）
	private long count;
	
	//字符串
	private String res;
	//对象
	private Object obj1;
	
	//多对象传入
	//+2对象
	private Object obj2;
	private Object obj3;
	
	
	//多重构造器的实现
	

	public Result() {
		super();
	}
	
	public Result(boolean flag, int no, String res, Object obj1, Object obj2, Object obj3) {
		super();
		this.flag = flag;
		this.no = no;
		this.res = res;
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
	}

	
	
	
	public Result(long count) {
		super();
		this.count = count;
	}

	public Result(boolean flag) {
		super();
		this.flag = flag;
	}

	public Result(String res) {
		super();
		this.res = res;
	}


	public Result(Object obj1) {
		super();
		this.obj1 = obj1;
	}



	public Result(int no) {
		super();
		this.no = no;
	}
	
	
	
	
	public Result(int pageNow, int pageSplit, long count, Object obj1) {
		super();
		this.pageNow = pageNow;
		this.pageSplit = pageSplit;
		this.count = count;
		this.obj1 = obj1;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public Object getObj1() {
		return obj1;
	}
	public void setObj1(Object obj1) {
		this.obj1 = obj1;
	}
	public Object getObj2() {
		return obj2;
	}
	public void setObj2(Object obj2) {
		this.obj2 = obj2;
	}
	public Object getObj3() {
		return obj3;
	}
	public void setObj3(Object obj3) {
		this.obj3 = obj3;
	}
	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSplit() {
		return pageSplit;
	}

	public void setPageSplit(int pageSplit) {
		this.pageSplit = pageSplit;
	}

	
}
