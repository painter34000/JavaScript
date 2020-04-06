package com.yedam.lambda;

public class Student {

	private String name;
	private int mathScore;
	private int englishScore;
	String sex;

	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public Student(String name, String sex, int mathScore, int englishScore) {
		super();
		this.name = name;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

}