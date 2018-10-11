package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login.do")
public class LoginController {

		@GetMapping
		public void GetHandle() {
			System.out.println("login.getHandle");
		}
		@PostMapping
		public void posthandle() {
			System.out.println("login.postHandle");
		}
}
