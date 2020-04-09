package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BuffereInputStream {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Downloads\\bear.mp4");
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream("src/com/yedam/io/test.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		int readByte;
		while ((readByte = bis.read()) != -1) {
			bos.write(readByte);
		}
		bos.flush();bos.close();fos.flush();fos.close();
		bis.close();fis.close();
		System.out.println("end");
	}

}
