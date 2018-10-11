package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/issue")
public class IssueController {

	@GetMapping("/new.do")
	public void newGetHandle() {
		System.out.println("IssueController.newGetHandle()");
	}
	
	@PostMapping("/new.do")
	public void newPostHandle() {
		System.out.println("IssueController.newPostHandle()");
	}
	
	@RequestMapping("/trend.do")
	public void trendHandle() {
		System.out.println("IssueController.trendHandle()");
	}
	
}
