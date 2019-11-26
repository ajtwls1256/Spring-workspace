package org.kh.exam;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("computer")
public class Computer {
	
	@Resource(name="apple")
	private Speaker speaker;

	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Computer(Speaker speaker) {
		super();
		this.speaker = speaker;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	
}
