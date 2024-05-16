package model;

import java.util.Objects;

public class TheLoai {
	private String maTheLoaiString;
	private String tenTheLoaiString;
	
	public TheLoai() {
	}

	public TheLoai(String maTheLoaiString, String tenTheLoaiString) {
		this.maTheLoaiString = maTheLoaiString;
		this.tenTheLoaiString = tenTheLoaiString;
	}

	public String getMaTheLoaiString() {
		return maTheLoaiString;
	}

	public void setMaTheLoaiString(String maTheLoaiString) {
		this.maTheLoaiString = maTheLoaiString;
	}

	public String getTenTheLoaiString() {
		return tenTheLoaiString;
	}

	public void setTenTheLoaiString(String tenTheLoaiString) {
		this.tenTheLoaiString = tenTheLoaiString;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return Objects.equals(maTheLoaiString, other.maTheLoaiString);
	}

	@Override
	public String toString() {
		return "TheLoai [maTheLoaiString=" + maTheLoaiString + ", tenTheLoaiString=" + tenTheLoaiString + "]";
	}
	
	
	
}
