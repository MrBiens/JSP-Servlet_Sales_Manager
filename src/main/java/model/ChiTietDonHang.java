package model;

import java.util.Objects;

public class ChiTietDonHang {
	private String maChiTietDonHangString;
	private DonHang donHang;
	private SanPham sanPham;
	private double soLuong;
	private double giaBia;
	private double giamGia;
	private double giaBan;
	private double VAT;
	private double tongThanhTien;
	
	public ChiTietDonHang() {
	}

	public ChiTietDonHang(String maChiTietDonHangString, DonHang donHang, SanPham sanPham, double soLuong,
			double giaBia, double giamGia, double giaBan, double vAT, double tongThanhTien) {
		this.maChiTietDonHangString = maChiTietDonHangString;
		this.donHang = donHang;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giamGia = giamGia;
		this.giaBan = giaBan;
		VAT = vAT;
		this.tongThanhTien = tongThanhTien;
	}

	public String getMaChiTietDonHangString() {
		return maChiTietDonHangString;
	}

	public void setMaChiTietDonHangString(String maChiTietDonHangString) {
		this.maChiTietDonHangString = maChiTietDonHangString;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public double getTongThanhTien() {
		return tongThanhTien;
	}

	public void setTongThanhTien(double tongThanhTien) {
		this.tongThanhTien = tongThanhTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maChiTietDonHangString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Objects.equals(maChiTietDonHangString, other.maChiTietDonHangString);
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHangString=" + maChiTietDonHangString + ", donHang=" + donHang
				+ ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", giaBia=" + giaBia + ", giamGia=" + giamGia
				+ ", giaBan=" + giaBan + ", VAT=" + VAT + ", tongThanhTien=" + tongThanhTien + "]";
	}
	
	
	
}
