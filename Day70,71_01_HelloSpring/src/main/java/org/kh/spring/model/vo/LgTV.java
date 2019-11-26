package org.kh.spring.model.vo;

public class LgTV implements TV{
/*	public void turnOn() {
		System.out.println("LgTV ---- 전원 켜짐");
	}
	
	public void turnOff() {
		System.out.println("LgTV ---- 전원 꺼짐");
	}
	
	public void soundUp() {
		System.out.println("LgTV ---- 소리 올림");
	}
	
	public void soundDown() {
		System.out.println("LgTV ---- 소리 내림");
	}*/

	@Override
	public void powerOn() {
		System.out.println("LgTV ---- 전원 켜짐");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV ---- 전원 꺼짐");
		
	}

	@Override
	public void volumUp() {
		System.out.println("LgTV ---- 소리 올림");
		
	}

	@Override
	public void volumDown() {
		System.out.println("LgTV ---- 소리 내림");
		
	}
}
