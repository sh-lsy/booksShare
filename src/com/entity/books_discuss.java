package com.entity;

public class books_discuss {
	private int discuss_id;
	private String discuss_content;
	private int discuss_p_id;
	private String discuss_u_id;
	private String discuss_u_name;
	private String discuss_time;
	public books_discuss(int discuss_id, String discuss_content, int discuss_p_id, String discuss_u_id,
			String discuss_u_name, String discuss_time) {
		super();
		this.discuss_id = discuss_id;
		this.discuss_content = discuss_content;
		this.discuss_p_id = discuss_p_id;
		this.discuss_u_id = discuss_u_id;
		this.discuss_u_name = discuss_u_name;
		this.discuss_time = discuss_time;
	}
	public int getDiscuss_id() {
		return discuss_id;
	}
	public void setDiscuss_id(int discuss_id) {
		this.discuss_id = discuss_id;
	}
	public String getDiscuss_content() {
		return discuss_content;
	}
	public void setDiscuss_content(String discuss_content) {
		this.discuss_content = discuss_content;
	}
	public int getDiscuss_p_id() {
		return discuss_p_id;
	}
	public void setDiscuss_p_id(int discuss_p_id) {
		this.discuss_p_id = discuss_p_id;
	}
	public String getDiscuss_u_id() {
		return discuss_u_id;
	}
	public void setDiscuss_u_id(String discuss_u_id) {
		this.discuss_u_id = discuss_u_id;
	}
	public String getDiscuss_u_name() {
		return discuss_u_name;
	}
	public void setDiscuss_u_name(String discuss_u_name) {
		this.discuss_u_name = discuss_u_name;
	}
	public String getDiscuss_time() {
		return discuss_time;
	}
	public void setDiscuss_time(String discuss_time) {
		this.discuss_time = discuss_time;
	}
	
	
}
