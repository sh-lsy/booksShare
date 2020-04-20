package com.entity;

public class books_order {
	public int order_id;
	public String order_time;
	public String order_no;
	public String order_b_filename;
	public String order_b_name;
	public String order_b_user;
	public int order_quantity;
	public int order_b_id ;
	public String order_way;
	public String order_u_id;
	public int order_valid;
	public books_order(int order_id, String order_time, String order_no, String order_b_filename, String order_b_name,
			String order_b_user, int order_quantity, int order_b_id, String order_way, String order_u_id,
			int order_valid) {
		super();
		this.order_id = order_id;
		this.order_time = order_time;
		this.order_no = order_no;
		this.order_b_filename = order_b_filename;
		this.order_b_name = order_b_name;
		this.order_b_user = order_b_user;
		this.order_quantity = order_quantity;
		this.order_b_id = order_b_id;
		this.order_way = order_way;
		this.order_u_id = order_u_id;
		this.order_valid = order_valid;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	public String getOrder_b_filename() {
		return order_b_filename;
	}
	public void setOrder_b_filename(String order_b_filename) {
		this.order_b_filename = order_b_filename;
	}
	public String getOrder_b_name() {
		return order_b_name;
	}
	public void setOrder_b_name(String order_b_name) {
		this.order_b_name = order_b_name;
	}
	public String getOrder_b_user() {
		return order_b_user;
	}
	public void setOrder_b_user(String order_b_user) {
		this.order_b_user = order_b_user;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	public int getOrder_b_id() {
		return order_b_id;
	}
	public void setOrder_b_id(int order_b_id) {
		this.order_b_id = order_b_id;
	}
	public String getOrder_way() {
		return order_way;
	}
	public void setOrder_way(String order_way) {
		this.order_way = order_way;
	}
	public String getOrder_u_id() {
		return order_u_id;
	}
	public void setOrder_u_id(String order_u_id) {
		this.order_u_id = order_u_id;
	}
	public int getOrder_valid() {
		return order_valid;
	}
	public void setOrder_valid(int order_valid) {
		this.order_valid = order_valid;
	}
	
	
		
	
}
