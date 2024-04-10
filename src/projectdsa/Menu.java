package projectdsa;

import java.math.BigDecimal;
import java.util.Scanner;

import projectdsa.linkedlist.DanhSachSinhVien;



public class Menu {
	
	public static float nhapSoDung(Scanner sc, String string) {
		float n;

		do {
			System.out.println(string);
			while (!sc.hasNextFloat()) {
				System.out.println("Vui lòng nhập số đúng : ");
				sc.nextLine();
			}
			n = sc.nextFloat();
			break;
		} while (true);
		return n;
	}
	
	public static DanhSachSinhVien danhSachSinhVien;
	
	
	
	public Menu() {
		danhSachSinhVien = new DanhSachSinhVien();
	}

	public void nhapSv(Scanner sc) {
		
		int count = 1;
		
		do {
			SinhVien sinhVien = new SinhVien();
			
			System.out.println("Nhập sinh viên thứ " + count + " (nhập số âm hoặc 0 nếu muốn thoát) ");
			System.out.println("Nhập mã sinh viên : ");
			long maSv = sc.nextLong();
			
			if(maSv <= 0) {
				break;
			}
			
			if(danhSachSinhVien.checkValidMaSv(maSv) == false) {
				System.out.println("Nhập lại :");
				continue;
			}
			
			System.out.println("Nhập họ đệm : ");
			sc.nextLine();
			String hoDem = sc.nextLine();
			
			
			System.out.println("Nhập tên sinh viên : ");
			String tenSv = sc.nextLine();
			System.out.print("");
			
			float diemTb = nhapSoDung(sc, "Nhập điểm trung bình :");
			
			sinhVien.setMaSv(maSv);
			sinhVien.setHoDem(hoDem);
			sinhVien.setTen(tenSv);
			sinhVien.setDiemTb(diemTb);
			
			danhSachSinhVien.addAtFirst(sinhVien);
			count++;
		
		}while(true);
	
	
	}
	
	public void xuat() {
		danhSachSinhVien.lietKe();
	}
	
	public void them1SinhVienVaoViTri( Scanner sc) {
		SinhVien sinhVien = new SinhVien();
		
		System.out.println("Nhập mã sinh viên : ");
		long maSv = sc.nextLong();
		do {
			
			if(danhSachSinhVien.checkValidMaSv(maSv) == false) {
				System.out.println("Nhập lại mã sinh viên : ");
				maSv = sc.nextLong();
			}
			else {
				break;
			}
			
		}while(true);
		
		
		System.out.println("Nhập họ đệm :");
		sc.nextLine();
		String hoDem = sc.nextLine();

		
		System.out.println("Nhập tên sinh viên : ");
		String tenSv = sc.nextLine();
		System.out.print("");
		
		float diemTb = nhapSoDung(sc, "Nhập điểm trung bình: ");
		
		sinhVien.setMaSv(maSv);
		sinhVien.setHoDem(hoDem);
		sinhVien.setTen(tenSv);
		sinhVien.setDiemTb(diemTb);
		
		System.out.println("Nhập vị trí cần thêm sinh viên : ");
		int index = sc.nextInt();
		
		danhSachSinhVien.addAtIndex(index, sinhVien);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		
		do {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("                              QUẢN LÝ SINH VIÊN                        ");
			System.out.println("1. Nhập sinh viên vào danh sách (nhập mã sinh viên <= 0 để thoát).");
     		System.out.println("2. Thêm 1 sinh viên vào danh sách, vị trí sinh viên thêm vào do ta chọn.");
     		System.out.println("3. Liệt kê danh sách sinh viên trên màn hình theo thứ tự tăng dần của tên.");
     		System.out.println("4. Căn cứ vào ĐTB của sinh viên, điền KQHT (ĐỖ , TRƯỢT) cho các SV theo quy chế.");
     		System.out.println("5. Đếm xem có bao nhiêu sinh viên có ĐTB >=7.0. In ra màn hình những SV này.");
     		System.out.println("6. Nhập vào mã số sinh viên, sau đó in ra vị trí của sinh viên trong danh sách.");
     		System.out.println("7. Tìm kiếm DSSV theo KQHT (kết quả học tập).");
     		System.out.println("8. Sắp xếp danh sách sinh viên theo ĐTB giảm dần.");
     		System.out.println("9. Xóa toàn bộ danh sách những sinh viên có ĐTB < 5.0.");
     		System.out.println("0. Thoát");
     		System.out.println("--------------------------------------------------------------------------");
     		
     		int choice = sc.nextInt();
     		do {
     		  
     		  if(choice > 9 && choice < 0) {
      			  System.out.println("Lựa chọn của bạn không khớp !");
      			  System.out.println("Nhập lại");
      			  choice = sc.nextInt();
      		  }
     		  else {
     			  break;
     		  }
     		}while(true);
     		
     		
     		
     		switch (choice) {
			case 1:{
				 menu.nhapSv(sc);
				 break;
			}
				
			case 2: {
				menu.them1SinhVienVaoViTri(sc);
				break;
			}
			
			case 3: {
				
				danhSachSinhVien.sapXepTheoTen();
				System.out.println("Danh sách sinh viên sau khi đã sắp xếp theo tên : ");
				menu.xuat();
				break;
			}
			
			case 4: {
				System.out.println("Nhập mốc điểm đỗ ( >= là đạt và < là không đạt ) : " );
				double diemTb = sc.nextDouble();
				danhSachSinhVien.setKetQuaHocTapTheoDiem(diemTb);
				System.out.println("Danh sách sinh viên sau khi sét kết quả học tập : ");
				menu.xuat();
				break;
			}
			
			case 5:	{
				danhSachSinhVien.sinhVienCoDiemTBLonBang7();
				break;
			}
			
			case 6: {
				System.out.println("Nhập mã số sinh viên bạn cần tìm : ");
				long maSv = sc.nextLong();
				danhSachSinhVien.timViTriSinhVienTrongDanhSachBangMa(maSv);
				break;
			}
			
			case 7: {
				System.out.println("Nhập kết quả học tập (đạt hoặc không đạt ) để tìm (không phân biệt hoa thường) :");
				sc.nextLine();
				String kq = sc.nextLine();
				danhSachSinhVien.timKiemSvTheoKetQuaHocTap(kq);
				break;
			}
			
			case 8:{
				danhSachSinhVien.sapXepSinhVienTheoDTBGiamDan();
				System.out.println("Danh sách sinh viên sau khi đã sắp xếp giảm dần theo điểm trung bình : ");
				menu.xuat();
				break;
			}
			
			case 9:{
				danhSachSinhVien.xoaSinhVienCoDiemTbBeHon5();
				System.out.println("Danh sách sinh viên sau khi đã xóa sinh viên có điểm trung bình < 5 : ");
				menu.xuat();
				break;
			}
			
			case 0: {
				sc.close();
				return;
			}
     		}
			
		}while(true);
	}
}