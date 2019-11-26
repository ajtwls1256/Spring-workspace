package org.kh.exam;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{

	@Override
	public void powerOn() {
		System.out.println("소니스피커 파워 온 !");
		
	}

	@Override
	public void powerOff() {
		System.out.println("소니스피커 파워 다운 !");
		
	}

}
