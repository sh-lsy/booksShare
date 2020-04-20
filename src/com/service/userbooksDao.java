package com.service;

import com.dao.Basedao;
import com.entity.books;

public class userbooksDao {
	public static int insert(books b) {
		String sql = "insert into user_books values(null, ?, ?,?,?,?,?,?,?,?)";
		
		
		Object[] params = {
					b.getBooks_name(),
					b.getBooks_description(),
					b.getBooks_stock(),
					b.getBooks_user(),
					b.getBooks_fid(),
					b.getBooks_cid(),
					b.getBooks_filename(),
					b.getBooks_filename1(),
					b.getBooks_filename2()
					};
		
		return Basedao.exectuIUD(sql, params);
	}
}
