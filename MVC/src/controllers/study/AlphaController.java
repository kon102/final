package controllers.study;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/*
 * DispatcherServlet�� ������Ѿߵ� Controller�� Mapping ó���ϴ¹��� 
 * ���ؼ� �˾ƺ��Ұ�, �̹��� ��ûHandle �޼��带 ����� ��Ŀ� ���ؼ� �˾ƺ����� �Ѵ�.
 * 
 * handle �޼���� Ư���� ���°� ����, 
 * �Ű������� ����Ÿ�Կ� ������ ����� �����ϴµ� �����Ǵ°͵鿡 �����ؼ� ����ϸ� �ȴ�.
 * 
 * �� handle �޼��忡 ���������� �Ű������� !
 */
@Controller
@RequestMapping("/study")
public class AlphaController {

	// 1. HttpServletRequest , HttpServletResponse, HttpSession �� �����Ҽ� �ִ�.
	// �� handle Method �� �۵��ɶ� Spring�� ���ؼ� ��ü�� �����Ǽ� ȣ��ǰ� �ǰ�,
	// ����Ҽ� �ְԵȴ�. (Dependency Injection ��� ��.)
	@RequestMapping("/01.do")
	public void study01Handle(HttpServletRequest request, HttpSession session) {
		System.out.println("study01Handle()");
		String addr= request.getRemoteAddr();
		boolean is = session.isNew();
		System.out.println("is = " + is + " / addr = " + addr);
		session.setAttribute("auth", "on");
	}
	
	// 2. WebRequest : �Ķ���ͳ� request,session �� attribute �� 
	// HttpServletRequest, HttpSession ���� ���� �����ϰ��� �Ҷ�.
	@RequestMapping("/02.do")
	public void study02Handle(WebRequest webRequest) {
		System.out.println("study02Handle()");
		
		String no = webRequest.getParameter("no");
		String auth = (String)webRequest.getAttribute("auth", WebRequest.SCOPE_SESSION);
		webRequest.setAttribute("limit", 5, WebRequest.SCOPE_SESSION);
	}
	// 3. Map, Model, ModelMap : ��� �Ѿ�� ������ ����� �����͵��� �����Ű�����Ҷ�
	@RequestMapping("/03.do")
	public String study03Handle(ModelMap modelMap) {
		modelMap.put("arr", new String[] {"model","view","controller"});
		modelMap.addAttribute("visit", 45121);
		
		
		
		return "/WEB-INF/views/test.jsp";
	}
	
}





