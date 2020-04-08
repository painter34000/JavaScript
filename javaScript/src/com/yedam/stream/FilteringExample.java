package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilteringExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("홍길동","신용권", "김자바", "신용권", "신민철");
		
		Stream<String> stream = list.stream();
		
		names.stream()
		.distinct()    // 중복제거   distinct(뚜렷한)
		.forEach(n ->System.out.println(n));
		System.out.println();   

		names.stream()
		.filter(n ->n.startsWith("신"))   //중간처리 ("신"으로 시작하는 요소)를 가져옴
		.forEach(n ->System.out.println(n));
		System.out.println();
		
		names.stream()
		.distinct()  //중복제거
		.filter(n->n.startsWith("신"))
		.forEach(n ->System.out.println(n));
	}
}
