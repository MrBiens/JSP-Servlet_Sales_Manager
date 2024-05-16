package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;


public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	private ArrayList<ChiTietDonHang> data = new ArrayList<>();
	
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4:

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donhang = rs.getString("madonhang");
				String sanpham = rs.getString("masanpham");
				double soluong = rs.getDouble("soluong");
				double giabia = rs.getDouble("giabia");
				double giamgia = rs.getDouble("giagiam");
				double giaban = rs.getDouble("giaban");
				double thuevat = rs.getDouble("vat");
				double tongtien = rs.getDouble("tongthanhtien");

				DonHang dh = new DonHangDAO().selectById(new DonHang(donhang, null, "", "", "", "", 0, 0, null, null));
				SanPham sp = new SanPhamDAO().selectById(new SanPham(sanpham, "", null, 0, 0.0, 0.0, 0.0, 0.0, null, "", ""));

				ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giabia, giamgia, giaban,thuevat, tongtien);
				ketQua.add(ctdh);
			}

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	

}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();

			String sql = "SELECT * FROM chitietdonhang WHERE machitietdonhang=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHangString());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donhang = rs.getString("madonhang");// o
				String sanpham = rs.getString("masanpham");// o
				double soluong = rs.getDouble("soluong");
				double giagoc = rs.getDouble("giabia");
				double giamgia = rs.getDouble("giagiam");
				double giaban = rs.getDouble("giaban");
				double thuevat = rs.getDouble("thuevat");
				double tongtien = rs.getDouble("tongtien");

				DonHang dh = new DonHangDAO().selectById(new DonHang(donhang, null, "", "", "", "", 0, 0, null, null));
				SanPham sp = new SanPhamDAO().selectById(new SanPham(sanpham, "", null, 0, 0.0, 0.0, 0.0, 0.0, null, "", ""));

				ketQua = new ChiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat,
						tongtien);
			}
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO chitietdonhang (machitietdonhang, madonhang,masanpham, soluong, giabia,giagiam,giaban,vat,tongthanhtien) "
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHangString());
			st.setString(2, t.getDonHang().getMaDonHangString());
			st.setString(3, t.getSanPham().getMaSanPhamString());
			st.setDouble(4, t.getSoLuong());
			st.setDouble(5, t.getGiaBia());
			st.setDouble(7, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(8, t.getVAT());
			st.setDouble(9, t.getTongThanhTien());
			// Bước 3: thực thi câu lệnh SQL
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
	public int insertAll(ArrayList<ChiTietDonHang> arrayList) {
		int count=0;
		for (ChiTietDonHang ChiTietDonHang : arrayList) {				
			count+=this.insert(ChiTietDonHang);
		}
		return count;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from chitietdonhang " + " WHERE machitietdonhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaChiTietDonHangString());

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
	public int deleteAll(ArrayList<ChiTietDonHang> arrayList) {
		int count=0;
		for (ChiTietDonHang ChiTietDonHang : arrayList) {
			count+=this.delete(ChiTietDonHang);
		}
		return count;
	}
	
//	public void deleteAll(DonHang dh) {
//		for (ChiTietDonHang chiTietDonHang : data) {
//			DonHang donHangCheck = dh;
//			if(chiTietDonHang.equals(donHangCheck)) {
//				this.delete(chiTietDonHang);
//			}
//		}
//	}

	@Override
	public int update(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE chitietdonhang SET madonhang=?, masanpham=?, soluong=?, giabia=?, giamgia=?, giaban=?, thuevat=?, tongtien=?"
					+ " WHERE machitietdonhang=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDonHang().getMaDonHangString());
			st.setString(2, t.getSanPham().getMaSanPhamString());
			st.setDouble(3, t.getSoLuong());
			st.setDouble(4, t.getGiaBia());
			st.setDouble(5, t.getGiamGia());
			st.setDouble(6, t.getGiaBan());
			st.setDouble(7, t.getVAT());
			st.setDouble(8, t.getTongThanhTien());
			st.setString(9, t.getMaChiTietDonHangString());

			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}


	public static void main(String[] args) {
		ChiTietDonHangDAO ctdhd=new ChiTietDonHangDAO();
		ArrayList<ChiTietDonHang> arrayList = new ArrayList<>();
		arrayList=ctdhd.selectAll();
//		for (ChiTietDonHang chiTietDonHang : arrayList) {
//			System.out.println(chiTietDonHang.toString());
//		}
		SanPham sanPham = new SanPham();
		sanPham.setMaSanPhamString("SP02");
		DonHang donHang = new DonHang();
		donHang.setMaDonHangString("DH01");
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang("CTDH02",donHang,sanPham,5,0,0,0,0,0);
		ctdhd.insert(chiTietDonHang);
		
	}
}
