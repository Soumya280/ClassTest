package com.jsp.Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConnection implements DAO{
	
	

	private static final String USERNAME="root";
	private static final String PASSWORD="tiger";
	private static final String URL="jdbc:mysql://localhost:3306/classtest";
	private static final String	DRIVERNAME="com.mysql.cj.jdbc.Driver";
	private static final DBConnection INSTANCE = new DBConnection();
	
	public static DBConnection getInstance() {
		return INSTANCE;
	}
	
	
	@Override
	public boolean saveUser(DBElements DE) {
		
		String query = "insert into class values(? ,? ,?)";
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, DE.getId());
			ps.setString(2, DE.getName());
			ps.setInt(3, DE.getNumber());
			
			int rowsInserted =ps.executeUpdate();
			
			if (rowsInserted == 1) {
				return true;
			}
			
			connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	

	@Override
	public DBElements findByIdAndName(int id, String name) {
		
		String query = "select * from class where id=? and name=?";
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			
			ResultSet set = ps.executeQuery();

			if (set.next())
				return rowToDBElements(set);
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	private DBElements rowToDBElements(ResultSet set) {
		
		try {
			int id = set.getInt(1);
			String name = set.getString(2);
			int number = set.getInt(3);
		
			return new DBElements(id, name, number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean deleteUser(int id) {
		
		String query = "delete from class where id = ?";
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, id);
			
			int rowsUpdated = ps.executeUpdate();
			
			if(rowsUpdated==1)
				return true;
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(int id, String name, int number) {
		
		String query = "update class set name=?, number=? where id=?";
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setInt(2, number);
			ps.setInt(3, id);
			
			int rowsUpdated = ps.executeUpdate();
			
			if (rowsUpdated == 1) {
				return true;
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<DBElements> findAllUser() {
		
		String query = "select * from class";
		List<DBElements> list = new ArrayList<DBElements>();
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = connection.prepareStatement(query);
			
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				DBElements dbElements = convertRowToSet(resultSet);
				list.add(dbElements);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}


	private DBElements convertRowToSet(ResultSet resultSet) throws SQLException {
		int id =resultSet.getInt(1);
		String name = resultSet.getString(2);
		int number = resultSet.getInt(3);
		return new DBElements(id,name,number);
	}


	@Override
	public DBElements findById(int id) {
		
		String query = "select * from class where id = ?";
		
		try {
			Class.forName(DRIVERNAME);
			Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet set = ps.executeQuery();
			
			if (set.next()) {
				return rowToDBElements(set);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
		
	
}
