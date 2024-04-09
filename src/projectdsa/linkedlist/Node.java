package projectdsa.linkedlist;

import projectdsa.SinhVien;

public class Node {
	
	public SinhVien value;
	public Node next;
	
	public Node() {
	}
	
	public Node(SinhVien data) {
		this.value = data;
		this.next = null;
	}
	
	public SinhVien getData() {
		return value;
	}
	public void setData(SinhVien data) {
		this.value = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
