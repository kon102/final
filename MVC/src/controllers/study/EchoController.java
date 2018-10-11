package controllers.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/study")
@SessionAttributes("user")
public class EchoController {

	@RequestMapping("/11.do")
	public void study11handle(Map user) {
		System.out.println(user);
		user.put("data", "spring");
	}
	
	@RequestMapping("/12.do")
	public String study12handle(Map user) {
		System.out.println(user);
		user.put("data", "spring");
		return "/WEB-INF/views/temp.jsp";
	}
	
	
}

