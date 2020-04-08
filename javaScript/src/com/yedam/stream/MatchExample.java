package com.yedam.stream;

import java.util.Arrays;

public class MatchExample {
	public static void main(String[] args) {

		int[] intArr = { 2, 4, 6 };
		boolean isTrue = Arrays.stream(intArr).allMatch(n -> n % 2 == 0);
		if(isTrue) {
			System.out.println("전체 짝수");
		}else {
			System.out.println("전체 짝수 아님");
		}
		
		int[] intArr1 = { 1, 3, 5, 7 };
		boolean isTrue1 = Arrays.stream(intArr).noneMatch(n -> n % 2 == 0);
		if(isTrue1) {
			System.out.println("전체 홀수");
		}else {
			System.out.println("전체 홀수 아님");
		}

	}
}
