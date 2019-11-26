package org.kh.member.common;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTest {
	
	
	@Scheduled(fixedDelay=5000)
	public void scheduledTest() {
		System.out.println("스케쥴링에 의한 자동실행 메소드!! (5초단위)");
	}
	
	@Scheduled(cron="10 * * * * *")
	public void scheduledTest2() {
		System.out.println("스케쥴링에 의한 자동실행 메소드2!! (매 분 10초마다)");
	}
	
}
