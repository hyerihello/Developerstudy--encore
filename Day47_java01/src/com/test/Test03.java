package com.test;

public class Test03 {
	
	public static void Prn_int() {
		// 정수형 연습
		// 전역변수, 멤버면수 : 생성자에서 초기화를 자동으로 대입한다. 
		
		System.out.println(100);
		System.out.println(100+100);
		System.out.println(100-100);
		
		System.out.println();
		
		System.out.printf("%5d %5d %10d \n", 100,100,200);	// 대문자불가 , Conversion = 'D'
		System.out.printf("%5o %5o %10o \n", 100,100,200);	//8진수, 대문자불가
		System.out.printf("%5x %5x %10x \n", 100,100,200); //16진수 헥사, 대문자불가
		
	}
	
	public static void Prn_int2() {
		// 정수형 연습
		// 전역변수, 멤버면수 : 생성자에서 초기화를 자동으로 대입한다. 
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println();
		
		System.out.printf("%5d %5d \t %10d \n", a,a,b);	// 대문자불가 , Conversion = 'D'
		System.out.printf("%5o %5o \t %10o \n", a,a,b);	//8진수, 대문자불가
		System.out.printf("%5x %5x \t %10x \n", a,a,b); //16진수 헥사, 대문자불가
		
		
		//public static String format(String format, Object... args)
				// static 매서드 //  리턴타입  매서드
		String res = String.format(" ", "%5x %5x \t %10x \n", a,a,b );
		System.out.println(res);
		
		
	}
	public static void Prn_float() {
		
		Double d = 98.7;
		Float f = 98.7f;
		
		
		System.out.println(d); //double -- 효율이더좋다 8byte : 소수점 아래 18 자리까지도 표현
		System.out.println(f); //float 4byte : 소수점 아래 9 자리까지만 표현
		
		String str = String.format("%10.2f %-10.2f\n", 98.7, 98.7f); // -는 왼쪽정렬
		System.out.println(str);
		
	}
	
	public static void Prn_char() {
		//한글자 있는 타입 
		System.out.println('A');
		System.out.printf("%5c\n", 'A');
		
		//데이터타입 변수 = 값;
		Character ch = 'A';
		System.out.println("ch = " + ch + "code = " + (int)ch);
		System.out.printf("%5d\n", (int)ch); // (int)형변환
	}
	
	public static void Prn_String() {
		// 'A' - chr
		// "A" - string
		System.out.println("'우리'나라 \'대\'한민국");
		String str = "우리나라 대한민국";
		System.out.println(str);
	}


	public static void main(String[] args) {
		//int a;//변수를 선언할 때 '지역변수'는 반드시 초기값을 지정해야한다.: 변수를 호출하면 값을 리턴한다.
		//a = 100;
		//System.out.println(a); // 호출시 오류발생 

		//Prn_int();
		Prn_int2();
		Prn_float();
		Prn_char();
		//Prn_String();
	}

}
