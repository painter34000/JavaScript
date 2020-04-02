package com.yedam.test0402;

public class Method01 {
	public static void main(String[] args) {
	
	 int $do =sum(5,6);
	 System.out.println($do);
	 
	}
	static int sum(int a, int b) {
		
		return a+b;
	}
	 private int a, b;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	 
	 
}