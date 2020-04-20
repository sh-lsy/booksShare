package com.entity;

public class user_books {
	private int books_id;
	private String books_name;
	private String books_description;
	private int books_stock;
	private String books_user;
	private int books_fid;
	private int books_cid;
	private String books_filename;
	private String books_filename1;
	private String books_filename2;
	public user_books(int books_id, String books_name, String books_description, int books_stock, String books_user,
			int books_fid, int books_cid, String books_filename, String books_filename1, String books_filename2) {
		super();
		this.books_id = books_id;
		this.books_name = books_name;
		this.books_description = books_description;
		this.books_stock = books_stock;
		this.books_user = books_user;
		this.books_fid = books_fid;
		this.books_cid = books_cid;
		this.books_filename = books_filename;
		this.books_filename1 = books_filename1;
		this.books_filename2 = books_filename2;
	}
	public int getBooks_id() {
		return books_id;
	}
	public void setBooks_id(int books_id) {
		this.books_id = books_id;
	}
	public String getBooks_name() {
		return books_name;
	}
	public void setBooks_name(String books_name) {
		this.books_name = books_name;
	}
	public String getBooks_description() {
		return books_description;
	}
	public void setBooks_description(String books_description) {
		this.books_description = books_description;
	}
	public int getBooks_stock() {
		return books_stock;
	}
	public void setBooks_stock(int books_stock) {
		this.books_stock = books_stock;
	}
	public String getBooks_user() {
		return books_user;
	}
	public void setBooks_user(String books_user) {
		this.books_user = books_user;
	}
	public int getBooks_fid() {
		return books_fid;
	}
	public void setBooks_fid(int books_fid) {
		this.books_fid = books_fid;
	}
	public int getBooks_cid() {
		return books_cid;
	}
	public void setBooks_cid(int books_cid) {
		this.books_cid = books_cid;
	}
	public String getBooks_filename() {
		return books_filename;
	}
	public void setBooks_filename(String books_filename) {
		this.books_filename = books_filename;
	}
	public String getBooks_filename1() {
		return books_filename1;
	}
	public void setBooks_filename1(String books_filename1) {
		this.books_filename1 = books_filename1;
	}
	public String getBooks_filename2() {
		return books_filename2;
	}
	public void setBooks_filename2(String books_filename2) {
		this.books_filename2 = books_filename2;
	}
	
	
}
