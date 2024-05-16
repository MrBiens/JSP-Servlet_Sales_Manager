package model;

import java.util.Objects;

public class SanPham {
	private String maSanPhamString;
	private String tenSanPhamString;
	private TacGia tacGia;
	private int namXuatBan;
	private Double giaNhapDouble;
	private Double giaGocDouble;
	private Double giaBanDouble;
	private Double soLuong;
	private TheLoai theLoai;
	private String ngonNguString;
	private String motaString;
	
	public SanPham() {
		
	}
	
	public SanPham(String maSanPhamString, String tenSanPhamString, TacGia tacGia, int namXuatBan, Double giaNhapDouble,
			Double giaGocDouble, Double giaBanDouble, Double soLuong, TheLoai theLoai, String ngonNguString,
			String motaString) {
		this.maSanPhamString = maSanPhamString;
		this.tenSanPhamString = tenSanPhamString;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.giaNhapDouble = giaNhapDouble;
		this.giaGocDouble = giaGocDouble;
		this.giaBanDouble = giaBanDouble;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNguString = ngonNguString;
		this.motaString = motaString;
	}
	
	public String getMaSanPhamString() {
		return maSanPhamString;
	}
	public void setMaSanPhamString(String maSanPhamString) {
		this.maSanPhamString = maSanPhamString;
	}
	public String getTenSanPhamString() {
		return tenSanPhamString;
	}
	public void setTenSanPhamString(String tenSanPhamString) {
		this.tenSanPhamString = tenSanPhamString;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public Double getGiaNhapDouble() {
		return giaNhapDouble;
	}
	public void setGiaNhapDouble(Double giaNhapDouble) {
		this.giaNhapDouble = giaNhapDouble;
	}
	public Double getGiaGocDouble() {
		return giaGocDouble;
	}
	public void setGiaGocDouble(Double giaGocDouble) {
		this.giaGocDouble = giaGocDouble;
	}
	public Double getGiaBanDouble() {
		return giaBanDouble;
	}
	public void setGiaBanDouble(Double giaBanDouble) {
		this.giaBanDouble = giaBanDouble;
	}
	public Double getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(Double soLuong) {
		this.soLuong = soLuong;
	}
	public TheLoai getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}
	public String getNgonNguString() {
		return ngonNguString;
	}
	public void setNgonNguString(String ngonNguString) {
		this.ngonNguString = ngonNguString;
	}
	public String getMotaString() {
		return motaString;
	}
	public void setMotaString(String motaString) {
		this.motaString = motaString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSanPhamString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(maSanPhamString, other.maSanPhamString);
	}

	@Override
	public String toString() {
		return "SanPham [maSanPhamString=" + maSanPhamString + ", tenSanPhamString=" + tenSanPhamString + ", tacGia="
				+ tacGia + ", namXuatBan=" + namXuatBan + ", giaNhapDouble=" + giaNhapDouble + ", giaGocDouble="
				+ giaGocDouble + ", giaBanDouble=" + giaBanDouble + ", soLuong=" + soLuong + ", theLoai=" + theLoai
				+ ", ngonNguString=" + ngonNguString + ", motaString=" + motaString + "]";
	}
	
	
	
	
	
	
}
