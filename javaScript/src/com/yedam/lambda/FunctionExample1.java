package com.yedam.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.yedam.stream.Student;

public class FunctionExample1 {

	private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 95), new Student("신용권", 95, 93));

	static void printString(Function<Student, String> function) { // 출력
		for (Student student : list) {
			System.out.print(function.apply(student) + " ");
		}
		System.out.println();
	}

	public static void printInt(ToIntFunction<Student> function) {
		for (Student student : list) {
			System.out.print(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}

	public static double avg(ToIntFunction<Student> func) {
		double avg = 0;
		int sum = 0;
		for (Student student : list) {
			sum += func.applyAsInt(student);
		}
		avg = (double) sum / list.size();
		return avg;
	}
	
	public static double savg(ToIntFunction<Student> sfunc) {
		double savg = 0;
		int sum = 0;
		for(Student student : list) {
			sum +=sfunc.applyAsInt(student);
		}
		savg = (double)sum / list.size();
				return savg;
	}


	public static void main(String[] args) {
		
		
      System.out.println("[학생 이름]");
      ;
      printString(t -> t.getName());

      System.out.println("[영어 점수]");
      printInt(t -> t.getEnglishScore());

      System.out.println("[수학 점수]");
      printInt(t -> t.getMathScore());
      
      
      double avg =avg(s ->s.getEnglishScore());
      System.out.println("영어평균 :"+avg);
    		  
      double savg =avg(v ->v.getMathScore());
      System.out.println("수학평균 :"+savg );

}// EndOfMain		
	}
	class MathIntClass<T> implements ToIntFunction<T>{

		@Override
		public int applyAsInt(T value) {
			Student s =(Student) value;
			return s.getEnglishScore();
		}
		
		
	}
// EndOfClass