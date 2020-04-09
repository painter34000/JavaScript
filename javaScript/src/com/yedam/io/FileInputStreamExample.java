package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamExample {
	public static void main(String[] args) throws IOException {
		String path = "src/com/yedam/io/input.txt"; // String 에 주소를 담기
		FileInputStream fis = new FileInputStream(path); // FileInputStream 이 읽어오게 하기
		String outPath = "src/com/yedam/io/output.txt";
		FileOutputStream fos = new FileOutputStream(outPath);

		int readByte;
		while ((readByte = fis.read()) != -1) {
			fos.write(readByte);
			System.out.print((char) readByte);
		}
//		while(true) {s
//			readByte = fis.read();
//			if (readByte == -1) {
//				break;
//			}
//			System.out.print((char) readByte);
//		}
		fos.flush();
		fos.close();

		fis.close();
	}
}
