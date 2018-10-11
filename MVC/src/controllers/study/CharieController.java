package controllers.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Controller 클래스 만들면서 요청 핸들 메서드에 설정할수 있는  인자들 지금까지 살펴본거 쓰는 방법 익히고 살펴보자
 * 
 * view 처리하는 방법 2가지
 */
@Controller
@RequestMapping("/study")
public class CharieController {
	
	@RequestMapping("/99.do")
	public String study99Handle() {
		/*
		 * viewResolver로 Inter
		 */
		return "/WEB-IN/views/default.jsp";
	}
}
