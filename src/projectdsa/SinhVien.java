package projectdsa;

import java.math.BigDecimal;


public class SinhVien {
	
	private long maSv;
	
	private String hoDem;
	
	private String ten;
	
	private BigDecimal diemTb;
	
	private String ketQuaHocTap;
	


	@Override
	public String toString() {
		return "SinhVien [maSv=" + maSv + ", hoDem=" + hoDem + ", ten=" + ten + ", diemTb=" + diemTb + ", ketQuaHocTap="
				+ ketQuaHocTap + "]";
	}

	public long getMaSv() {
		return maSv;
	}

	public void setMaSv(long maSv) {
		this.maSv = maSv;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public BigDecimal getDiemTb() {
		return diemTb;
	}

	public void setDiemTb(BigDecimal diemTb) {
		this.diemTb = diemTb;
	}

	public String getKetQuaHocTap() {
		return ketQuaHocTap;
	}

	public void setKetQuaHocTap(String ketQuaHocTap) {
		this.ketQuaHocTap = ketQuaHocTap;
	}
}
