package org.kh.spring.model.vo;

public class SamsungTV implements TV{
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성 완료");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV ---- 전원 켜짐");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV ---- 전원 꺼짐");
	}
	@Override
	public void volumUp() {
		System.out.println("SamsungTV ---- 소리를 올림");
	}
	@Override
	public void volumDown() {
		System.out.println("SamsungTV ---- 소리를 내림");
	}
}

