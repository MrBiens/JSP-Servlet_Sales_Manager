package model;

import java.sql.Date;
import java.util.Objects;

public class KhachHang {
	
	
	private String maKhachHangString;
	private String tenDangNhapString;
	private String matKhauString;
	private String hoVaTenString;
	private String gioiTinhString;
	private String diaChiString;
	private String diaChiNhanHangString;
	private String diaChiMuaHangString;
	private Date ngaySinhDate;
	private String soDienThoaiString;
	private String emailString;
	private Boolean dangKyNhanEmailBoolean;
	private String maXacThucString;
	private Date thoiGianHieuLucCuaMaXacThucDate;
	private boolean trangThaiXacThuc;
	private String duongDanAnh;
	public KhachHang() {
	}

	public KhachHang(String maKhachHangString, String tenDangNhapString, String matKhauString, String hoVaTenString,
			String gioiTinhString, String diaChiString, String diaChiNhanHangString, String diaChiMuaHangString,
			Date ngaySinhDate, String soDienThoaiString, String emailString, Boolean dangKyNhanEmailBoolean) {
		this.maKhachHangString = maKhachHangString;
		this.tenDangNhapString = tenDangNhapString;
		this.matKhauString = matKhauString;
		this.hoVaTenString = hoVaTenString;
		this.gioiTinhString = gioiTinhString;
		this.diaChiString = diaChiString;
		this.diaChiNhanHangString = diaChiNhanHangString;
		this.diaChiMuaHangString = diaChiMuaHangString;
		this.ngaySinhDate = ngaySinhDate;
		this.soDienThoaiString = soDienThoaiString;
		this.emailString = emailString;
		this.dangKyNhanEmailBoolean = dangKyNhanEmailBoolean;
	}

	
	public KhachHang(String maKhachHangString, String tenDangNhapString, String matKhauString, String hoVaTenString,
			String gioiTinhString, String diaChiString, String diaChiNhanHangString, String diaChiMuaHangString,
			Date ngaySinhDate, String soDienThoaiString, String emailString, Boolean dangKyNhanEmailBoolean,
			String maXacThucString, Date thoiGianHieuLucCuaMaXacThucDate, boolean trangThaiXacThuc) {
		super();
		this.maKhachHangString = maKhachHangString;
		this.tenDangNhapString = tenDangNhapString;
		this.matKhauString = matKhauString;
		this.hoVaTenString = hoVaTenString;
		this.gioiTinhString = gioiTinhString;
		this.diaChiString = diaChiString;
		this.diaChiNhanHangString = diaChiNhanHangString;
		this.diaChiMuaHangString = diaChiMuaHangString;
		this.ngaySinhDate = ngaySinhDate;
		this.soDienThoaiString = soDienThoaiString;
		this.emailString = emailString;
		this.dangKyNhanEmailBoolean = dangKyNhanEmailBoolean;
		this.maXacThucString = maXacThucString;
		this.thoiGianHieuLucCuaMaXacThucDate = thoiGianHieuLucCuaMaXacThucDate;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	

	public KhachHang(String maKhachHangString, String tenDangNhapString, String matKhauString, String hoVaTenString,
			String gioiTinhString, String diaChiString, String diaChiNhanHangString, String diaChiMuaHangString,
			Date ngaySinhDate, String soDienThoaiString, String emailString, Boolean dangKyNhanEmailBoolean,
			String maXacThucString, Date thoiGianHieuLucCuaMaXacThucDate, boolean trangThaiXacThuc,
			String duongDanAnh) {
		super();
		this.maKhachHangString = maKhachHangString;
		this.tenDangNhapString = tenDangNhapString;
		this.matKhauString = matKhauString;
		this.hoVaTenString = hoVaTenString;
		this.gioiTinhString = gioiTinhString;
		this.diaChiString = diaChiString;
		this.diaChiNhanHangString = diaChiNhanHangString;
		this.diaChiMuaHangString = diaChiMuaHangString;
		this.ngaySinhDate = ngaySinhDate;
		this.soDienThoaiString = soDienThoaiString;
		this.emailString = emailString;
		this.dangKyNhanEmailBoolean = dangKyNhanEmailBoolean;
		this.maXacThucString = maXacThucString;
		this.thoiGianHieuLucCuaMaXacThucDate = thoiGianHieuLucCuaMaXacThucDate;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.duongDanAnh = duongDanAnh;
	}

	public String getMaKhachHangString() {
		return maKhachHangString;
	}

	public void setMaKhachHangString(String maKhachHangString) {
		this.maKhachHangString = maKhachHangString;
	}

	public String getTenDangNhapString() {
		return tenDangNhapString;
	}

	public void setTenDangNhapString(String tenDangNhapString) {
		this.tenDangNhapString = tenDangNhapString;
	}

	public String getMatKhauString() {
		return matKhauString;
	}

	public void setMatKhauString(String matKhauString) {
		this.matKhauString = matKhauString;
	}

	public String getHoVaTenString() {
		return hoVaTenString;
	}

	public void setHoVaTenString(String hoVaTenString) {
		this.hoVaTenString = hoVaTenString;
	}

	public String getgioiTinhString() {
		return gioiTinhString;
	}

	public void setGioiTinhBoolean(String gioiTinhBoolean) {
		this.gioiTinhString = gioiTinhBoolean;
	}

	public String getDiaChiString() {
		return diaChiString;
	}

	public void setDiaChiString(String diaChiString) {
		this.diaChiString = diaChiString;
	}

	public String getDiaChiNhanHangString() {
		return diaChiNhanHangString;
	}

	public void setDiaChiNhanHangString(String diaChiNhanHangString) {
		this.diaChiNhanHangString = diaChiNhanHangString;
	}

	public String getDiaChiMuaHangString() {
		return diaChiMuaHangString;
	}

	public void setDiaChiMuaHangString(String diaChiMuaHangString) {
		this.diaChiMuaHangString = diaChiMuaHangString;
	}

	public Date getNgaySinhDate() {
		return ngaySinhDate;
	}

	public void setNgaySinhDate(Date ngaySinhDate) {
		this.ngaySinhDate = ngaySinhDate;
	}

	public String getSoDienThoaiString() {
		return soDienThoaiString;
	}

	public void setSoDienThoaiString(String soDienThoaiString) {
		this.soDienThoaiString = soDienThoaiString;
	}

	public String getEmailString() {
		return emailString;
	}

	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}

	public Boolean getDangKyNhanEmailString() {
		return dangKyNhanEmailBoolean;
	}

	public void setDangKyNhanEmailString(Boolean dangKyNhanEmailBoolean) {
		this.dangKyNhanEmailBoolean = dangKyNhanEmailBoolean;
	}
	public String getGioiTinhString() {
		return gioiTinhString;
	}

	public void setGioiTinhString(String gioiTinhString) {
		this.gioiTinhString = gioiTinhString;
	}

	public Boolean getDangKyNhanEmailBoolean() {
		return dangKyNhanEmailBoolean;
	}

	public void setDangKyNhanEmailBoolean(Boolean dangKyNhanEmailBoolean) {
		this.dangKyNhanEmailBoolean = dangKyNhanEmailBoolean;
	}

	public String getMaXacThucString() {
		return maXacThucString;
	}

	public void setMaXacThucString(String maXacThucString) {
		this.maXacThucString = maXacThucString;
	}

	public Date getThoiGianHieuLucCuaMaXacThucDate() {
		return thoiGianHieuLucCuaMaXacThucDate;
	}

	public void setThoiGianHieuLucCuaMaXacThucDate(Date thoiGianHieuLucCuaMaXacThucDate) {
		this.thoiGianHieuLucCuaMaXacThucDate = thoiGianHieuLucCuaMaXacThucDate;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	
	public String getDuongDanAnh() {
		return duongDanAnh;
	}

	public void setDuongDanAnh(String duongDanAnh) {
		this.duongDanAnh = duongDanAnh;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(maKhachHangString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHangString, other.maKhachHangString);
	}
	
	
}
