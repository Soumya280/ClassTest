package com.jsp.Servlets;

import java.util.List;

public interface DAO {

	public boolean saveUser(DBElements DE);
	public DBElements findByIdAndName(int id, String name);
	public List<DBElements> findAllUser();
	public boolean deleteUser(int id);
	public boolean updateUser(int id, String name, int number);
	public DBElements findById(int id);
}
