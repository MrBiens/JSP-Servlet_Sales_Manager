package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia>{

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> data = new ArrayList<TacGia>();
		try {
			//B1: tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();
			//B2: tao ra doi tuong prepared statement
			
			String sql="select * from tacgia";
			PreparedStatement statement=connection.prepareStatement(sql);
			//B3: thuc thi cau lenh sql
			ResultSet resultSet=statement.executeQuery();
			//B4:
			while (resultSet.next()) {
				String maTacGiaString=resultSet.getString("matacgia");
				String hovatenString=resultSet.getString("hovaten");
				Date ngaySinhDate=resultSet.getDate("ngaysinh");
				String tieuSuString=resultSet.getString("tieusu");
				
				TacGia tacGia=new TacGia(maTacGiaString,hovatenString,ngaySinhDate,tieuSuString);
				data.add(tacGia);
			}
			//B5: ngat csdl
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia tacGia=null;
		try {
			//B1: tao ket noi den CSDL
			Connection connection = JDBCUtil.getConnection();
			//B2: tao ra doi tuong prepared statement-de luu tru
			String sql="select * from tacgia where matacgia=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, t.getMaTacGiaString());
			
			//B3: thuc thi cau lenh sql
			ResultSet resultSet=statement.executeQuery();
			//B4:
			while (resultSet.next()) {
				String maTacGiaString=resultSet.getString("matacgia");
				String hovatenString=resultSet.getString("hovaten");
				Date ngaySinhDate=resultSet.getDate("ngaysinh");
				String tieuSuString=resultSet.getString("tieusu");
				
				tacGia=new TacGia(maTacGiaString,hovatenString,ngaySinhDate,tieuSuString);
//				tacGia.setMaTacGiaString(maTacGiaString);
//				tacGia.setHoVaTenString(hovatenString);
//				tacGia.setNgaySinhDate(ngaySinhDate);
//				tacGia.setTieuSuString(tieuSuString);
			}
			//B5: ngat csdl
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tacGia;
		
	}

	@Override
	public int insert(TacGia t) {
		int  themTacGia=0;
		try {
			Connection connection =JDBCUtil.getConnection();
			
			String sql="insert into tacgia value (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getMaTacGiaString());
			statement.setString(2, t.getHoVaTenString());
			statement.setDate(3, t.getNgaySinhDate());
			statement.setString(4, t.getTieuSuString());
			
			 themTacGia = statement.executeUpdate();
			
			 if (themTacGia>0) {
				 System.out.println(sql);
				System.out.println("Ban them thanh cong "+themTacGia+" tac gia ");
			} else {
				System.out.println("Them that bai");
			}
			
			JDBCUtil.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

			return themTacGia;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arrayList) {
		int count=0;
		for (TacGia tacGia : arrayList) {				
			count+=this.insert(tacGia);
		}
		return count;
	}

	@Override
	public int delete(TacGia t) {
		int  xoaTacGia=0;
		try {
			Connection connection =JDBCUtil.getConnection();
			
			String sql="delete from tacgia where matacgia=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getMaTacGiaString());
			
			
			xoaTacGia = statement.executeUpdate();
			
			 if (xoaTacGia>0) {
				 System.out.println(sql);
				System.out.println("Ban xoa thanh cong "+xoaTacGia+" tac gia ");
			} else {
				System.out.println("Them that bai");
			}
			
			JDBCUtil.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

			return xoaTacGia;
	}
	

	@Override
	public int deleteAll(ArrayList<TacGia> arrayList) {
		int count=0;
		for (TacGia tacGia : arrayList) {
			count+=this.delete(tacGia);
		}
		return count;
	}

	@Override
	public int update(TacGia t) {
		int  suaTacGia=0;
		try {
			Connection connection =JDBCUtil.getConnection();
			
			String sql="update tacgia set hovaten=?,ngaysinh=?,tieusu=? where matacgia=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, t.getHoVaTenString());
			statement.setDate(2, t.getNgaySinhDate());
			statement.setString(3, t.getTieuSuString());
			statement.setString(4, t.getMaTacGiaString());
			
			suaTacGia = statement.executeUpdate();
			
			 if (suaTacGia>0) {
				 System.out.println(sql);
				System.out.println("Ban sua thanh cong "+suaTacGia+" tac gia ");
			} else {
				System.out.println("Them that bai");
			}
			
			JDBCUtil.closeConnection(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}

			return suaTacGia;
	}
	
	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
//		ArrayList<TacGia> kq = tgd.selectAll();
//		for (TacGia tacGia : kq) {
//			System.out.println(tacGia.toString());
//		}
//		
//		TacGia tacGia = tgd.selectById(new TacGia("TG01", null, null, null));
		
//		TacGia tacGia = new TacGia("TG01",null,null,null);
//		tacGia=tgd.selectById(tacGia);
		
		//them tac gia
		TacGia themTacGia = new TacGia("TG10","Pham Van Cuong",new Date(2003-1900, 7-1, 24),"Bio tac gia");//year-1900;month-1
		
//		tgd.insert(themTacGia);
		
//		tgd.delete(themTacGia);
		
//		themTacGia.setTieuSuString("Hihihi By Bien");
//		tgd.update(themTacGia);
	}
}

