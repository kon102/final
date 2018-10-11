package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  requestmappingHandlerMapping �� ���ؼ� �۵��ǰ� �� ��Ʈ�ѷ���
 *  Ư�� Ŭ������ ����� �޾Ƽ� �������� �ʿ�� ���� POJO������ ������ �����ϴ�
 * 	Plaing Old java Object: ����� �⺻ �ڹ� ��ü)
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
