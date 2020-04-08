package com.yedam.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LoopingExample {
	public static void main(String[] args) {
		
		int[] intArr = {1,2,3,4,5,6};
		IntStream intStream = Arrays.stream(intArr);
		int sum = intStream.filter(n -> n%2==0) //test()
		                   .peek(s ->System.out.println(s))
		                   .sum();
		System.out.println("결과값:"+sum);
		
//		intStream = Arrays.stream(intArr);
//		int sum1 = intStream.filter(n -> n%2==1)
//		                    .forEach(s -> System.out.println(s))
//		                    .sum();
//		System.out.println("결과값:"+sum1);                         //최종처리메소드인 forEach와 sum은 동시에 들어갈수 없다
		
	}
}
