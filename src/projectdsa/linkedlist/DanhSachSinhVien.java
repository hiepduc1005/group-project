package projectdsa.linkedlist;

import java.math.BigDecimal;
import java.util.Collection;

import projectdsa.SinhVien;

public class DanhSachSinhVien {
	
	public static final String KQHT_DO = "ĐẠT";
	public static final String KQHT_TRUOT = "KHÔNG ĐẠT"; 

	private Node head;
	public long length = 0;
	
	
	public void addAtLast(SinhVien value) {
		Node newNode = new Node(value);
		
		if(head == null || head.value == null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		
		while(temp.next != null){
			temp = temp.next;
		}
		
		temp.next = newNode;
		length++;
	}
	
	public void addAtFirst(SinhVien value) {
        Node node = new Node(value);
		
		if(head == null || head.value == null) {
			head = node;
			return;
		}
		
		node.next = head;
		head = node;
		length++;
	}
	
	public void addAtIndex(int index , SinhVien value) {
		Node newNode = new Node(value);
		
		if(index < 0) {
			return;
		}
		
		if(head == null || head.value == null) {
			head = newNode;
			return;
		}
		
		if (index == 0) {
	        newNode.next = head;
	        head = newNode;
	        return;
	    }
		
		int count = 0;
		Node temp = head;
		
		while(temp != null && count != (index - 1)) {
			temp = temp.next;
			count++;
		}
		
		if (temp == null) {
	        throw new IndexOutOfBoundsException("IndexOutOfBounds : " + index);
	    }
		
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
	}
	
	public void addAllAtLast(Collection<SinhVien> values) {
		
	}
	
	public void removeAtLast() {
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		Node temp = head;
		
		if(temp.next == null) {
			temp = null;
			head = null;
		}
		
		while(temp.next.next != null) {
			temp = temp.next;
		}
	
		temp.next = null;
		length--;
	}
	
	public void removeAtFirst() {
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		Node temp = head;
		
		head = temp.next;
		temp.next = null;
		temp = null;
		length--;
	}
	
	public void removeAtIndex(int index) {
		if(index < 0) {
			throw new IllegalArgumentException("Input must positive");
		}
		
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		if(index == 0) {
			removeAtFirst();
			return;
		}
		
		int count = 0;
		Node temp = head;
		
		while(count != (index-1)) {
			temp = temp.next;
			count++;
		}
		
		if(temp == null) {
			throw new IndexOutOfBoundsException("IndexOutOfBounds : " + index);
		}
		
		if(temp.next == null) {
			removeAtLast();
			return;
		}
		
			
		if(temp.next.next == null) {
			temp.next = null;
			return;
		}
		
		temp.next = temp.next.next;
		temp.next.next = null;
		length--;
	}
	
	public void removeAll() {
		
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		Node temp = head;
		
		while(temp != null) {
			
			temp = temp.next;
			head.next = null;
			head = temp;
		}
		length = 0;
		
	}
	
	public SinhVien getFirst() {
		return (head != null) ? head.value : null;
	}
	
	public SinhVien getLast() {	
		if(head == null) {
			return null;
		}
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		return temp.value;
	}
	
	public void lietKe() {
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		System.out.println("Danh sách sinh viên: ");
		Node temp = head;
		
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public void sapXepTheoTen() {
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		if(head.next == null) {
			System.out.println(head.value);
			return;
		}
		
		Node i,j;
		
		for(i = head ; i.next != null ; i = i.next ) {
			for( j = i.next ; j != null ; j = j.next) {
				if(i.value.getTen().compareTo(j.value.getTen()) > 0) {
					SinhVien temp = i.value;
					i.value = j.value;
					j.value = temp;
				}
			}
		}
	}
	
	public void sinhVienCoDiemTBLonBang7() {
		if(head == null) {
			System.out.println("Danh sách trống");
			return;
		}
		
		Node temp = head;
		int count = 0;
		
		while(temp != null) {
			if(temp.value.getDiemTb().doubleValue() >= 7) {
				count++;
			}
			temp = temp.next;
		}
		
		System.out.println("Có " + count + " sinh viên có điểm trung bình >= 7");
		
		temp = head;
		
		System.out.println("Danh sách sinh viên có điểm trung bình >= 7 : ");
		
		while(temp != null) {
			if(temp.value.getDiemTb().compareTo(BigDecimal.valueOf(7)) >= 0) {
				System.out.println(temp.value);
			}
			temp = temp.next;
		}
	}
	
	public void timViTriSinhVienTrongDanhSachBangMa(long maSv) {
		if(maSv <= 0 ) {
			System.out.println("Mã sinh viên phải là số dương !");
			return;
		}
		
		Node temp = head;
		int index = -1;
		
		while(temp != null) {
			index++;
			if(temp.value.getMaSv() == maSv) {
				System.out.println("Sinh viên mã số " + maSv + " nằm ở vị trí thứ " + index +" trong danh sách (vị trí đầu tiên là 0)");
				System.out.println(temp.value);
				break;
			}
			
			temp = temp.next;
		}
		
		if(index == -1) {
			System.out.println("Không có sinh viên nào có mã là " + maSv);
		}
		
	}
	
	
	public void timKiemSvTheoKetQuaHocTap(String kq) {
		if(kq == null || (!kq.equalsIgnoreCase(KQHT_DO) && !kq.equalsIgnoreCase(KQHT_TRUOT))) {
			System.out.println("Nhập sai kết quả học tập (ĐẠT , KHÔNG ĐẠT)");
			return;
		}
		
		Node temp = head;
		
		System.out.println("Danh sách sinh viên " + kq.toUpperCase() + " : ");
		while(temp != null) {
			if(temp.value.getKetQuaHocTap().toUpperCase() == kq.toUpperCase()) {
				System.out.println(temp.value);
			}
			
			temp = temp.next;
		}
	}
	
	public void setKetQuaHocTapTheoDiem(double diemTb) {
		if(head == null) {
			System.out.println("Danh sách sinh viên trống");
			return;
		}
		
		if(diemTb < 0) {
			System.out.println("Điểm trung bình phải dương");
		}
		
		Node temp = head;
		
		while(temp != null) {
			if(temp.value.getDiemTb().doubleValue() >= diemTb) {
				temp.value.setKetQuaHocTap(KQHT_DO);
			}
			else {
				temp.value.setKetQuaHocTap(KQHT_TRUOT);
			}
			
			temp = temp.next;
		}
	}
	
	public void sapXepSinhVienTheoDTBGiamDan() {
		if(head == null) {
			System.out.println("Danh sách sinh viên trống");
			return;
		}
		
		if(head.next == null) {
			System.out.println(head.next);
			return;
		}
		
		
		for(Node i = head ; i != null ; i = i.next) {
			for(Node j = i.next ; j != null ; j = j.next) {
				if(i.value.getDiemTb().compareTo(j.value.getDiemTb()) < 0) {
					SinhVien temp = i.value;
					i.value = j.value;
					j.value = temp;
				}
			}
		}
	}
	
	public void xoaSinhVienCoDiemTbBeHon5() {
		if(head == null) {
			System.out.println("Danh sách sinh viên trống");
			return;
		}
		
		int index = 0;
		Node temp = head;
		
		while(temp != null) {
			if(temp.value.getDiemTb().compareTo(BigDecimal.valueOf(5)) < 0) {
				removeAtIndex(index);
			}
			
			temp = temp.next;
			index++;
		}
	}
	
	public boolean checkValidMaSv(long maSv) {
		
		boolean res = true;
		Node temp = head;
		
		while(temp != null) {
			if(temp.value.getMaSv() == maSv) {
				res = false;
				break;
			}
			
			temp = temp.next;
		}
		
		if(res == false) {
			System.out.println("Mã sinh viên đã tồn tại");
		}
		
		return res;
	}
	
	
}
