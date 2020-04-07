package com.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapAndReduceExample {
	public static void main(String[] args) {

		List<Student> list = Arrays.asList(new Student("Hong", 91)
				, new Student("Hwang", 92)
				, new Student("Park", 91));
		double avg = list.stream().mapToInt(s -> s.getScore())
				.average()
				.getAsDouble();
		System.out.println(avg);                         //람다 스트림 약식표션
		
		System.out.println("===========================");
		
		Stream<Student> stream = list.stream();
		IntStream intStream = stream.mapToInt((Student s)->{
			return s.getScore();
		});
		OptionalDouble odbl = intStream.average();
		avg = odbl.getAsDouble();
		System.out.println(avg);              //서술표현
		
	}
}
