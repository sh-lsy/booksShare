package com.entity;

public class order {
	public String order_time;
	public String order_no;
	public String order_way;
	public int order_valid;
	public String order_u_id;
	
	public order(String order_time, String order_no, String order_way, int order_valid, String order_u_id) {
		super();
		this.order_time = order_time;
		this.order_no = order_no;
		this.order_way = order_way;
		this.order_valid = order_valid;
		this.order_u_id = order_u_id;
	}
	
	
	
	
	public String getOrder_time() {
		return order_time;
	}




	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}




	public String getOrder_no() {
		return order_no;
	}




	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}




	public String getOrder_way() {
		return order_way;
	}




	public void setOrder_way(String order_way) {
		this.order_way = order_way;
	}




	public int getOrder_valid() {
		return order_valid;
	}




	public void setOrder_valid(int order_valid) {
		this.order_valid = order_valid;
	}




	public String getOrder_u_id() {
		return order_u_id;
	}




	public void setOrder_u_id(String order_u_id) {
		this.order_u_id = order_u_id;
	}




	public boolean equals(Object obj) {
		    order o = (order) obj;
		    return order_no.equals(o.order_no);
	 }
	 public int hashCode() {
		        String in = order_no;
		        return in.hashCode();
     }
}
