package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	private ArrayList<TheLoai> data = new ArrayList<>();
	@Override
	public ArrayList<TheLoai> selectAll() {
		
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql="select * from theloai";
			PreparedStatement statement =connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String matheloai=resultSet.getString("matheloai");
				String tentheloai=resultSet.getString("tentheloai");
				TheLoai theLoai = new TheLoai(matheloai,tentheloai);
				data.add(theLoai);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai theLoai = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sqlString="select * from theloai where matheloai=?";
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, t.getMaTheLoaiString());
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String matheloai=resultSet.getString("matheloai");
				String tentheloai=resultSet.getString("tentheloai");
				 theLoai = new TheLoai(matheloai,tentheloai);
				data.add(theLoai);
			}
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theLoai;
		
	}

	@Override
	public int insert(TheLoai t) {
		int themTheLoai=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sqlString="insert into theloai value(?,?)";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			statement.setString(1, "matheloai");
			statement.setString(2, "tentheloai");
			themTheLoai=statement.executeUpdate();
			if(themTheLoai>0) {
				System.out.println(sqlString);
				System.out.println("You execute success"+themTheLoai+" statement ");
			}else {
				System.out.println("You execute false");
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return themTheLoai;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arrayList) {
		int count=0;
		for (TheLoai TheLoai : arrayList) {				
			count+=this.insert(TheLoai);
		}
		return count;
	}

	@Override
	public int delete(TheLoai t) {
		int xoaTheLoai=0;
		try {
			Connection connection=JDBCUtil.getConnection();
			String sqlString="delete from theloai where matheloai=?";
			PreparedStatement statement=connection.prepareStatement(sqlString);
			statement.setString(1, "matheloai");
			xoaTheLoai=statement.executeUpdate();
			if(xoaTheLoai>0) {
				System.out.println(sqlString);
				System.out.println("You execute success"+xoaTheLoai+" statement ");
			}else {
				System.out.println("You execute false");
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xoaTheLoai;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arrayList) {
		int count=0;
		for (TheLoai TheLoai : arrayList) {
			count+=this.delete(TheLoai);
		}
		return count;
	}

	@Override
	public int update(TheLoai t) {
		int suaTheLoai=0;
		try {
			Connection contConnection = JDBCUtil.getConnection();
			String sqlString="update theloai set tentheloai=? where matheloai=?";
			PreparedStatement statement=contConnection.prepareStatement(sqlString);
			statement.setString(1, "tentheloai");
			statement.setString(2, "matheloai");
			suaTheLoai=statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return suaTheLoai;
	}
	public static void main(String[] args) {
		TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
		ArrayList<TheLoai> arrayList = theLoaiDAO.selectAll();
		for (TheLoai theLoai : arrayList) {
			System.out.println(theLoai);
		}
	}
	
}
