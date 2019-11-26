package org.kh.test.ano;

import org.springframework.stereotype.Component;

//@Component("bae")
public class Chocolate {
	public Chocolate() {
		super();
		System.out.println("초콜렛 객체 생성 완료!");
	}
	
	public void melting() {
		System.out.println("녹아요");
	}
	
	public void baeByungChook() {
		System.out.println("후...............");
	}
}
