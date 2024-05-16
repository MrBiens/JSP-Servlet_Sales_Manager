package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHangString;
	private KhachHang khachHang;
	private String diaChiNguoiMuaString;
	private String diaChiNhanHangString;
	private String trangThaiString;
	private String hinhThucThanhToanString;
	private double soTienDaThanhToanDouble;
	private double soTienConThieuDouble;
	private Date ngayDatHangDate;
	private Date ngayGiaoHangDate;
	
	public DonHang() {
	}

	public DonHang(String maDonHangString, KhachHang khachHang, String diaChiNguoiMuaString,
			String diaChiNhanHangString, String trangThaiString, String hinhThucThanhToanString,
			 double soTienDaThanhToanDouble,double soTienConThieuDouble, Date ngayDatHangDate, Date ngayGiaoHangDate) {
		this.maDonHangString = maDonHangString;
		this.khachHang = khachHang;
		this.diaChiNguoiMuaString = diaChiNguoiMuaString;
		this.diaChiNhanHangString = diaChiNhanHangString;
		this.trangThaiString = trangThaiString;
		this.hinhThucThanhToanString = hinhThucThanhToanString;
		this.soTienDaThanhToanDouble=soTienDaThanhToanDouble;
		this.soTienConThieuDouble = soTienConThieuDouble;
		this.ngayDatHangDate = ngayDatHangDate;
		this.ngayGiaoHangDate = ngayGiaoHangDate;
	}

	public String getMaDonHangString() {
		return maDonHangString;
	}

	public void setMaDonHangString(String maDonHangString) {
		this.maDonHangString = maDonHangString;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiNguoiMuaString() {
		return diaChiNguoiMuaString;
	}

	public void setDiaChiNguoiMuaString(String diaChiNguoiMuaString) {
		this.diaChiNguoiMuaString = diaChiNguoiMuaString;
	}

	public String getDiaChiNhanHangString() {
		return diaChiNhanHangString;
	}

	public void setDiaChiNhanHangString(String diaChiNhanHangString) {
		this.diaChiNhanHangString = diaChiNhanHangString;
	}

	public String getTrangThaiString() {
		return trangThaiString;
	}

	public void setTrangThaiString(String trangThaiString) {
		this.trangThaiString = trangThaiString;
	}

	public String getHinhThucThanhToanString() {
		return hinhThucThanhToanString;
	}

	public void setHinhThucThanhToanString(String hinhThucThanhToanString) {
		this.hinhThucThanhToanString = hinhThucThanhToanString;
	}



	public Double getSoTienConThieuDouble() {
		return soTienConThieuDouble;
	}

	public void setSoTienConThieuDouble(double soTienConThieuDouble) {
		this.soTienConThieuDouble = soTienConThieuDouble;
	}

	public Date getNgayDatHangDate() {
		return ngayDatHangDate;
	}

	public void setNgayDatHangDate(Date ngayDatHangDate) {
		this.ngayDatHangDate = ngayDatHangDate;
	}

	public Date getNgayGiaoHangDate() {
		return ngayGiaoHangDate;
	}

	public void setNgayGiaoHangDate(Date ngayGiaoHangDate) {
		this.ngayGiaoHangDate = ngayGiaoHangDate;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!= obj.getClass()) {
			return false;
		}
		DonHang other=(DonHang) obj;
		return Objects.equals(maDonHangString, other.maDonHangString);
	}

	public double getSoTienDaThanhToanDouble() {
		return soTienDaThanhToanDouble;
	}

	public void setSoTienDaThanhToanDouble(double soTienDaThanhToanDouble) {
		this.soTienDaThanhToanDouble = soTienDaThanhToanDouble;
	}
}
