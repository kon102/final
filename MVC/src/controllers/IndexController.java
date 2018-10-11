package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  requestmappingHandlerMapping 에 의해서 작동되게 될 컨트롤러는
 *  특정 클래스를 상속을 받아서 만들어야할 필요는 없고 POJO형태의 설꼐가 가능하다
 * 	Plaing Old java Object: 평범한 기본 자바 객체)
 * 
 * 
 */
@Controller
public class IndexController {

	@RequestMapping("/index.do")
	public void indexHandle() {
		System.out.println("indexController.indexHandle()");
	}
	
}
