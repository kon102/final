package controllers.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Controller Ŭ���� ����鼭 ��û �ڵ� �޼��忡 �����Ҽ� �ִ�  ���ڵ� ���ݱ��� ���캻�� ���� ��� ������ ���캸��
 * 
 * view ó���ϴ� ��� 2����
 */
@Controller
@RequestMapping("/study")
public class CharieController {
	
	@RequestMapping("/99.do")
	public String study99Handle() {
		/*
		 * viewResolver�� Inter
		 */
		return "/WEB-IN/views/default.jsp";
	}
}
