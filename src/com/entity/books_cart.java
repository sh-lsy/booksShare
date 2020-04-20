package com.entity;

public class books_cart {
	public int cart_id;
	public String cart_b_filename;
	public String cart_b_name;
	public String cart_b_description;
	public String cart_b_user;
	public int cart_quantity;
	public int cart_b_stock;
	public int cart_b_id ;
	public String cart_u_id;
	public int cart_valid;
	public books_cart(int cart_id, String cart_b_filename, String cart_b_name, String cart_b_description,
			String cart_b_user, int cart_quantity, int cart_b_stock, int cart_b_id, String cart_u_id, int cart_valid) {
		super();
		this.cart_id = cart_id;
		this.cart_b_filename = cart_b_filename;
		this.cart_b_name = cart_b_name;
		this.cart_b_description = cart_b_description;
		this.cart_b_user = cart_b_user;
		this.cart_quantity = cart_quantity;
		this.cart_b_stock = cart_b_stock;
		this.cart_b_id = cart_b_id;
		this.cart_u_id = cart_u_id;
		this.cart_valid = cart_valid;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_b_filename() {
		return cart_b_filename;
	}
	public void setCart_b_filename(String cart_b_filename) {
		this.cart_b_filename = cart_b_filename;
	}
	public String getCart_b_name() {
		return cart_b_name;
	}
	public void setCart_b_name(String cart_b_name) {
		this.cart_b_name = cart_b_name;
	}
	public String getCart_b_description() {
		return cart_b_description;
	}
	public void setCart_b_description(String cart_b_description) {
		this.cart_b_description = cart_b_description;
	}
	public String getCart_b_user() {
		return cart_b_user;
	}
	public void setCart_b_user(String cart_b_user) {
		this.cart_b_user = cart_b_user;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getCart_b_stock() {
		return cart_b_stock;
	}
	public void setCart_b_stock(int cart_b_stock) {
		this.cart_b_stock = cart_b_stock;
	}
	public int getCart_b_id() {
		return cart_b_id;
	}
	public void setCart_b_id(int cart_b_id) {
		this.cart_b_id = cart_b_id;
	}
	public String getCart_u_id() {
		return cart_u_id;
	}
	public void setCart_u_id(String cart_u_id) {
		this.cart_u_id = cart_u_id;
	}
	public int getCart_valid() {
		return cart_valid;
	}
	public void setCart_valid(int cart_valid) {
		this.cart_valid = cart_valid;
	}

	
	
}
