package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;

public class DonHangDAO implements DAOInterface<DonHang> {

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				double soTienDaThanhToan = rs.getDouble(7);
				double soTienConThieu = rs.getDouble(8);
				Date ngayDatHang = rs.getDate(9);
				Date ngayGiaoHang = rs.getDate(10);

				KhachHang khachHang = new KhachHangDAO()
						.selectById(new KhachHang(maKH, "", "", "", "", "", "", "", null, "", "", false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan,
						 soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);

				ketQua.add(dh);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang ketQua = null;
		Connection con = JDBCUtil.getConnection();
		String sql = "SELECT * FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHangString());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString(1);
				String maKH = rs.getString(2);
				String diaChiNguoiMua = rs.getString(3);
				String diaChiNhanHang = rs.getString(4);
				String trangThai = rs.getString(5);
				String hinhThucThanhToan = rs.getString(6);
				double soTienDaThanhToan = rs.getDouble(7);
				double soTienConThieu = rs.getDouble(8);
				Date ngayDatHang = rs.getDate(9);
				Date ngayGiaoHang = rs.getDate(10);

				KhachHang khachHang = new KhachHangDAO()
						.selectById(new KhachHang(maKH, "", "", "", "", "", "", "", null, "", "", false));
				DonHang dh = new DonHang(maDH, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan,
						 soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);

				ketQua = dh;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "INSERT INTO donhang(madonhang, khachhang, diachinguoimua, diachinguoinhan, trangthai, hinhthucthanhtoan,sotienthanhtoan, sotienconthieu,ngaydathang,ngaygiaohang)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHangString());
			st.setString(2, t.getKhachHang().getMaKhachHangString());
			st.setString(3, t.getDiaChiNguoiMuaString());
			st.setString(4, t.getDiaChiNhanHangString());
			st.setString(5, t.getTrangThaiString());
			st.setString(6, t.getHinhThucThanhToanString());
			st.setDouble(7, t.getSoTienDaThanhToanDouble());
			st.setDouble(8, t.getSoTienConThieuDouble());
			st.setDate(9, t.getNgayDatHangDate());
			st.setDate(10, t.getNgayGiaoHangDate());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang donHang : arr) {
			kq += this.insert(donHang);
		}
		return kq;
	}

	@Override
	public int delete(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();
		String sql = "DELETE FROM donhang WHERE madonhang = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaDonHangString());
			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int kq = 0;
		for (DonHang t : arr) {
			kq += this.delete(t);
		}
		return kq;
	}

	@Override
	public int update(DonHang t) {
		int kq = 0;
		Connection con = JDBCUtil.getConnection();

		String sql = "UPDATE donhang" + " SET " + "khachhang=?" + ", diachinguoimua=?" + ",diachinguoinhan=?"
				+ ",trangthai=?" + ",hinhthucthanhtoan=?"+ ",sotienthanhtoan=?" + ",sotienconthieu=?" + ",ngaydathang=?"
				+ ",ngaygiaohang=?" + " WHERE madonhang=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getKhachHang().getMaKhachHangString());
			st.setString(2, t.getDiaChiNguoiMuaString());
			st.setString(3, t.getDiaChiNhanHangString());
			st.setString(4, t.getTrangThaiString());
			st.setString(5, t.getHinhThucThanhToanString());
			st.setDouble(6, t.getSoTienDaThanhToanDouble());
			st.setDouble(7, t.getSoTienConThieuDouble());
			st.setDate(8, t.getNgayDatHangDate());
			st.setDate(9, t.getNgayGiaoHangDate());
			st.setString(10, t.getMaDonHangString());

			kq = st.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}