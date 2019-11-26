package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("white")
public class WhiteChocolate implements ChocolateInterface{

	@Override
	public void baeByungChook() {
		System.out.println("백조 배병축");
		
	}

	@Override
	public void byungChookBae() {
		System.out.println("아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ");
		
	}

}
