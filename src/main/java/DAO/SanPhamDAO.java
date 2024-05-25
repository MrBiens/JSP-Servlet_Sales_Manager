package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import model.TacGia;
import model.TheLoai;

public class SanPhamDAO implements DAOInterface<SanPham>{
	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> sanPham = new ArrayList<SanPham>();

		try {
			Connection connection=JDBCUtil.getConnection();
			String sqlString="select * from sanpham";
			PreparedStatement statement = connection.prepareStatement(sqlString);
			System.out.println(sqlString);

			ResultSet resultSet=statement.executeQuery();
			while (resultSet.next()) {
				String maSanphamString=resultSet.getString("masanpham");
				String tenSanPhamString=resultSet.getString("tensanpham");
				String maTacGiaString=resultSet.getString("matacgia");
				int namxuatban=resultSet.getInt("namxuatban");
				double giaNhap=resultSet.getDouble("gianhap");
				double giaGoc=resultSet.getDouble("giagoc");
				double giaBan=resultSet.getDouble("giaban");
				double soLuong=resultSet.getDouble("soluong");
				String maTheLoaiString=resultSet.getString("matheloai");
				String ngonnguString=resultSet.getString("ngonngu");
				String motaString=resultSet.getString("mota");
				
				TacGia tacGia=new TacGiaDAO().selectById(new TacGia(maTacGiaString,null,null,null));
				TheLoai theLoai=new TheLoaiDAO().selectById(new TheLoai(maTheLoaiString,null));
				
				SanPham sp=new SanPham(maSanphamString,tenSanPhamString,tacGia,namxuatban,giaNhap,giaGoc,giaBan,soLuong,theLoai,ngonnguString,motaString);
				sanPham.add(sp);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sanPham;
		
	}
	//select theo ma the loai
	public ArrayList<SanPham> getSanPhamByTheLoai(String matheloaiString) {
		ArrayList<SanPham> sanPham = new ArrayList<SanPham>();

		try {
			Connection connection=JDBCUtil.getConnection();
			String sqlString="SELECT * FROM sanpham WHERE matheloai=? ";
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, matheloaiString);

			ResultSet resultSet=statement.executeQuery();
			while (resultSet.next()) {
				String maSanphamString=resultSet.getString("masanpham");
				String tenSanPhamString=resultSet.getString("tensanpham");
				String maTacGiaString=resultSet.getString("matacgia");
				int namxuatban=resultSet.getInt("namxuatban");
				double giaNhap=resultSet.getDouble("gianhap");
				double giaGoc=resultSet.getDouble("giagoc");
				double giaBan=resultSet.getDouble("giaban");
				double soLuong=resultSet.getDouble("soluong");
				String maTheLoaiString=resultSet.getString("matheloai");
				String ngonnguString=resultSet.getString("ngonngu");
				String motaString=resultSet.getString("mota");
				
				TacGia tacGia=new TacGiaDAO().selectById(new TacGia(maTacGiaString,null,null,null));
				TheLoai theLoai=new TheLoaiDAO().selectById(new TheLoai(maTheLoaiString,null));
				
				SanPham sp=new SanPham(maSanphamString,tenSanPhamString,tacGia,namxuatban,giaNhap,giaGoc,giaBan,soLuong,theLoai,ngonnguString,motaString);
				sanPham.add(sp);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sanPham;
		
	}
	public ArrayList<SanPham> searchByName(String tenSanPham) {
		ArrayList<SanPham> sanPham = new ArrayList<SanPham>();

		try {
			Connection connection=JDBCUtil.getConnection();
			String sqlString="SELECT * FROM sanpham WHERE tensanpham like ? ";
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, "%"+tenSanPham+"%");//like %ten%

			ResultSet resultSet=statement.executeQuery();
			while (resultSet.next()) {
				String maSanphamString=resultSet.getString("masanpham");
				String tenSanPhamString=resultSet.getString("tensanpham");
				String maTacGiaString=resultSet.getString("matacgia");
				int namxuatban=resultSet.getInt("namxuatban");
				double giaNhap=resultSet.getDouble("gianhap");
				double giaGoc=resultSet.getDouble("giagoc");
				double giaBan=resultSet.getDouble("giaban");
				double soLuong=resultSet.getDouble("soluong");
				String maTheLoaiString=resultSet.getString("matheloai");
				String ngonnguString=resultSet.getString("ngonngu");
				String motaString=resultSet.getString("mota");
				
				TacGia tacGia=new TacGiaDAO().selectById(new TacGia(maTacGiaString,null,null,null));
				TheLoai theLoai=new TheLoaiDAO().selectById(new TheLoai(maTheLoaiString,null));
				
				SanPham sp=new SanPham(maSanphamString,tenSanPhamString,tacGia,namxuatban,giaNhap,giaGoc,giaBan,soLuong,theLoai,ngonnguString,motaString);
				sanPham.add(sp);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sanPham;
		
	}


	@Override
	public SanPham selectById(SanPham t) {
		SanPham sanPham=null;
	
		try {
			Connection connection=JDBCUtil.getConnection();
			String sqlString="select * from sanpham where masanpham=?";
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, t.getMaSanPhamString());
			System.out.println(sqlString);

			ResultSet resultSet=statement.executeQuery();
			while (resultSet.next()) {
				String maSanphamString=resultSet.getString("masanpham");
				String tenSanPhamString=resultSet.getString("tensanpham");
				String maTacGiaString=resultSet.getString("matacgia");
				int namxuatban=resultSet.getInt("namxuatban");
				double giaNhap=resultSet.getDouble("gianhap");
				double giaGoc=resultSet.getDouble("giagoc");
				double giaBan=resultSet.getDouble("giaban");
				double soLuong=resultSet.getDouble("soluong");
				String maTheLoaiString=resultSet.getString("matheloai");
				String ngonnguString=resultSet.getString("ngonngu");
				String motaString=resultSet.getString("mota");
				
				TacGia tacGia=new TacGiaDAO().selectById(new TacGia(maTacGiaString,null,null,null));
				TheLoai theLoai=new TheLoaiDAO().selectById(new TheLoai(maTheLoaiString,null));
				
				 sanPham=new SanPham(maSanphamString,tenSanPhamString,tacGia,namxuatban,giaNhap,giaGoc,giaBan,soLuong,theLoai,ngonnguString,motaString);
				
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sanPham;
	}	

	@Override
	public int insert(SanPham t) {
		int themSanPham=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sqlString = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban,"
					+ " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";			
			PreparedStatement statement = connection.prepareStatement(sqlString);
			statement.setString(1, t.getMaSanPhamString());
			statement.setString(2, t.getTenSanPhamString());
			statement.setString(3, t.getTacGia().getMaTacGiaString());
			statement.setInt(4, t.getNamXuatBan());
			statement.setDouble(5, t.getGiaNhapDouble());
			statement.setDouble(6, t.getGiaGocDouble());
			statement.setDouble(7, t.getGiaBanDouble());
			statement.setDouble(8, t.getSoLuong());
			statement.setString(9, t.getTheLoai().getMaTheLoaiString());
			statement.setString(10, t.getNgonNguString());
			statement.setString(11, t.getMotaString());

			System.out.println(sqlString);
			themSanPham=statement.executeUpdate();
			
			if (themSanPham>0) {
				System.out.println("You insert success" + themSanPham+ "line code");
			} else {
				System.out.println("You insert false");
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return themSanPham;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arrayList) {
		int count=0;
		for (SanPham SanPham : arrayList) {				
			count+=this.insert(SanPham);
		}
		return count;
	}

	@Override
	public int delete(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from sanpham " + " WHERE masanpham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaSanPhamString());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arrayList) {
		int count=0;
		for (SanPham SanPham : arrayList) {
			count+=this.delete(SanPham);
		}
		return count;
	}

	@Override
	public int update(SanPham t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
					+ "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masanpham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSanPhamString());
			st.setString(2, t.getTacGia().getMaTacGiaString());
			st.setInt(3, t.getNamXuatBan());
			st.setDouble(4, t.getGiaNhapDouble());
			st.setDouble(5, t.getGiaGocDouble());
			st.setDouble(6, t.getGiaBanDouble());
			st.setDouble(7, t.getSoLuong());
			st.setString(8, t.getTheLoai().getMaTheLoaiString());
			st.setString(9, t.getNgonNguString());
			st.setString(10, t.getMotaString());
			st.setString(11, t.getMaSanPhamString());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public static void main(String[] args) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();

		List<SanPham> arrayList;
		arrayList=	sanPhamDAO.selectAll();;
	
		for (SanPham sanPham : arrayList) {
			System.out.println(sanPham.toString());
		}
		
//		SanPham sanPham1= new SanPham("SP01", null, null, 0, null, null, null, null, null, null, null);
//		sanPham1=sanPhamDAO.selectById(sanPham1);
//		System.out.println(sanPham1);
		
		//them sp
//		TacGia tacGia = new TacGia();
//		tacGia.setMaTacGiaString("TG02");//tacgia trung voi database
//		TheLoai theLoai = new TheLoai();
//		theLoai.setMaTheLoaiString("tl2");//theloai trung voi database
//		SanPham themSanPham=new SanPham("SP02", "San pham nuoc hoa pro vip", tacGia, 0, 0.0, 0.0, 0.0, 0.0, theLoai, "", "");
//		sanPhamDAO.insert(themSanPham);

//SanPham sp = new SanPhamDAO().selectById(new SanPham(sanpham, "", null, 0, 0.0, 0.0, 0.0, 0.0, null, "", ""));

//				("SP02", "Nuoc hoa vip pro ban moi nhat cua nam 2024", "TG03", "2021", "25.00", "30.0","28.0", 
//				"10.0,"tl1"," vietnamese", null);
		
	}
	
}
