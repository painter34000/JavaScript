package com.yedam.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
	public static void main(String[] args) throws IOException {
		List<String> list = Arrays.asList("홍길동", "김유신", "하준원", "홍성우");
		//==>name.txt 
		//String outPath = "src/com/yedam/io/name.txt";
		FileOutputStream fos = new FileOutputStream("src/com/yedam/io/name.txt");
		
		for(String b: list) {
			fos.write(b.getBytes());
		}
		
		
		
//		FileWriter fw = new FileWriter(outPath);
//		int readByte;
//		while((readByte = fw) != -1) {
//			fos.write(readByte);
//			System.out.println((char) readByte);
//		}
		fos.flush();
		fos.close();
	}
}
