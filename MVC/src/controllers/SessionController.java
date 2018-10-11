package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * Controller ���� Mapping�� ������, 
 * 	@RequestMapping �� ��û�޼��� ������� �� ó��
 * 	
 * 	@GetMapping / @PostMapping / @PutMapping / @DeleteMapping / @PatchMapping 
 * 	���� ��û ��ĺ��� ���� �����Ҽ� �ִ�.
 * 	
 * 	cf# Put���, Delete���, Patch����� ��û�� Ȱ���ϱ� ���ؼ� Spring Filter�� �����ؾ��Ѵ�.
 * 	
 * 	cf# Spring���� �����ؾߵ� ��(��ü)���� ������ ������� �ʾƵ� scan ������ �صθ�
 * 	�˾Ƽ� �ش� ��Ű���� ��(Controller , ��) �� �ڵ� ����Ѵ�.
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
