package com.mysite.sbb;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloLombok2 {
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		 HelloLombok2 helloLombok = new HelloLombok2("헬로", 5);
//	     helloLombok.setHello("헬로");
//	     helloLombok.setLombok(5);
		 
		 System.out.println(helloLombok.getHello());
	     System.out.println(helloLombok.getLombok());
		 
	}
}
