package com.yedam.io;

import java.io.IOException;
import java.io.PrintStream;

public class SystemOutExample {
	public static void main(String[] args) throws IOException {

		System.out.println("출력:");
		PrintStream ps = System.out;
		String text = "한글은 달리 처리해야 합니다.";
		byte[] cduf = text.getBytes();
		ps.write(cduf);
		ps.flush();
	}
}
