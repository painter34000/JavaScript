package com.yedam.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("192.168.0.15", 5001)); // 계속 대기모드 - 명령이 들어오면 반응
			while (true) {
				System.out.println("[연결 기다림 ]");
				Socket socket = serverSocket.accept();
				System.out.println("[연결 수락]");

				
				//InputStream 처리.
				byte[] buf = null;
				String message = null;
				InputStream is = socket.getInputStream();
				buf = new byte[100];
				int readByte = is.read(buf);
				message = new String(buf, 0, readByte, "UTF-8");
				System.out.println("[데이터받기 성공]"+ message);
				
				
				//OutputStream 처리.
				OutputStream os = socket.getOutputStream();
				message = "Hello, client, 홍성우입니다"; 
				buf = message.getBytes();
				os.write(buf);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				
				os.close();
				is.close();
				socket.close();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
