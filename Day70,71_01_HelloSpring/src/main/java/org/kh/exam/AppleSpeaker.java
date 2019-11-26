package org.kh.exam;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	@Override
	public void powerOn() {
		System.out.println("애플스피커 파워 온 !");
		
	}

	@Override
	public void powerOff() {
		System.out.println("애플스피커 파워 다운 !");
		
	}

}
