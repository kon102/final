package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * Controller 에서 Mapping을 잡을때, 
 * 	@RequestMapping 은 요청메서드 상관없이 다 처리
 * 	
 * 	@GetMapping / @PostMapping / @PutMapping / @DeleteMapping / @PatchMapping 
 * 	으로 요청 방식별로 따로 지정할수 있다.
 * 	
 * 	cf# Put방식, Delete방식, Patch방식의 요청을 활용하기 위해선 Spring Filter를 설정해야한다.
 * 	
 * 	cf# Spring에서 관리해야될 빈(객체)들을 일일이 등록하지 않아도 scan 설정을 해두면
 * 	알아서 해당 패키지의 빈(Controller , 등) 을 자동 등록한다.
 */
@Controller
public class SessionController {

	@GetMapping("/session.do")
	public void getHandle() {
		System.out.println("SessionController.getHandle()");
	}
	
	@PostMapping("/session.do")
	public void postHandle() {
		System.out.println("SessionController.postHandle()");
	}
}
