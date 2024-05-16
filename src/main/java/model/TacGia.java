package model;

import java.sql.Date;
import java.util.Objects;

public class TacGia {
	private String maTacGiaString;
	private String hoVaTenString;
	private Date ngaySinhDate;
	private String tieuSuString;
	
	public TacGia() {
	}
	
	public TacGia(String maTacGiaString, String hoVaTenString, Date ngaySinhDate, String tieuSuString) {
		this.maTacGiaString = maTacGiaString;
		this.hoVaTenString = hoVaTenString;
		this.ngaySinhDate = ngaySinhDate;
		this.tieuSuString = tieuSuString;
	}
	public String getMaTacGiaString() {
		return maTacGiaString;
	}
	public void setMaTacGiaString(String maTacGiaString) {
		this.maTacGiaString = maTacGiaString;
	}
	public String getHoVaTenString() {
		return hoVaTenString;
	}
	public void setHoVaTenString(String hoVaTenString) {
		this.hoVaTenString = hoVaTenString;
	}
	public Date getNgaySinhDate() {
		return ngaySinhDate;
	}
	public void setNgaySinhDate(Date ngaySinhDate) {
		this.ngaySinhDate = ngaySinhDate;
	}
	public String getTieuSuString() {
		return tieuSuString;
	}
	public void setTieuSuString(String tieuSuString) {
		this.tieuSuString = tieuSuString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTacGiaString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TacGia other = (TacGia) obj;
		return Objects.equals(maTacGiaString, other.maTacGiaString);
	}

	@Override
	public String toString() {
		return "TacGia [maTacGiaString=" + maTacGiaString + ", hoVaTenString=" + hoVaTenString + ", ngaySinhDate="
				+ ngaySinhDate + ", tieuSuString=" + tieuSuString + "]";
	}
	
	
	
}
