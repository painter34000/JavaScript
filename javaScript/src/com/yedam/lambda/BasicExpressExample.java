package com.yedam.lambda;

interface MyInterface {
	void metgod(int a);
}




interface MyInterfaceReturn {
	int getResult(int a, int b);
}

public class BasicExpressExample {
	public static void main(String[] args) {
		MyInterfaceReturn mir = new MyInterfaceReturn() {

			@Override
			public int getResult(int a, int b) {
				return a + b; // 재정의해야함
			}

		};
		int result = mir.getResult(10, 20);
		
		mir=(num1,num2)->{
			return num1*num2;
	};
	result = mir.getResult(10,  20);
	System.out.println("result: " + result);
	}
}
//class RunnableImpl implements Runnable{
//
//	@Override
//	public void run() {
//	System.out.println("runnable call.");	
//	}
//	
//}                  <--이렇게 쓰는 대신  아래 람다식으로 표현

//public class BasicExpressExample {
//	public static void main(String[] args) {
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("runnable call.");
//			}
//		};
//		runnable.run();
//		Runnable runnable1 = () -> {
//				System.out.println("runnable lambda call.");
//		};
//		runnable1.run();
//	};
//}