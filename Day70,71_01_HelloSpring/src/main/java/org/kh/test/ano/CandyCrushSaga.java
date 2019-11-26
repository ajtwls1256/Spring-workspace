package org.kh.test.ano;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("saga")
public class CandyCrushSaga {
	
	// 아래의 어노테이션으로 서버에서 알아서 컨테이너를 뒤져 생성된 해당 타입 클래스를 찾아서 할당해줌
//	@Autowired
	// 중복될 시 Qualifier어노테이션을 통해 특정 객체를 지정한다.
//	@Qualifier("dark")
	
	@Resource(name="dark")	// 위의 두개를 합친게 이거
	ChocolateInterface choco;
	
	public CandyCrushSaga() {
		super();
		System.out.println("KING");
	}

	public ChocolateInterface getChoco() {
		return choco;
	}

	public void setChoco(ChocolateInterface choco) {
		this.choco = choco;
	}
	
	
}
