package app.controller.guest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import app.model.EmployeeRepository;
import app.service.SocketService;


@Controller
public class WelcomeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SocketService socketService;
	
	@RequestMapping("/index.do")
	public String indexHandle(@SessionAttribute(required=false) String auth, Map attr) {
		if(auth == null) {
			return "index";
		}else {
			return "guest.home";
		}
	}
	
	@RequestMapping("/login.do")
	public String loginHandle(WebRequest webRequest, @RequestParam Map p) {
		int cnt = employeeRepository.checkEmployee(p);
		if(cnt > 0) {
			String id =(String)p.get("id");
			Map one = employeeRepository.getEmployee(id);
			webRequest.setAttribute("user", one, WebRequest.SCOPE_SESSION);
			webRequest.setAttribute("auth", "on", WebRequest.SCOPE_SESSION);
			
			
			Map msg = new HashMap<>();
				msg.put("mode", "login");
				msg.put("actor", one);
			socketService.sendAll(msg);
			
		}
		return "redirect:/";		// redirect:/index.do	
	}
}
	