package controllers.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

/*
 *  ��ûó���޼��忡 ����Ҽ� �ִ� ���ڵ��� ���� ���캸��.
 *  
 */

@Controller
@RequestMapping("/study")
public class DeltaController {

	@RequestMapping("/09.do")
	public void study09handle(WebRequest wr) {
		wr.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
		Map one = new HashMap();
			one.put("ID", "saan");
			one.put("NAME", "����ȣ");
			one.put("grade", 3);
		wr.setAttribute("user", one, WebRequest.SCOPE_SESSION);
	}
	//================================================================
	/*
	 * @SessionAttribute
	 * ����ڼ��ǿ� �̹� �����ϴ� Ư����ü�� Ȯ���ؼ� ��ûó���� �ϰ����Ҷ� ���.
	 * (���ǿ� �������� �������� ��ü�� ���Խ�Ű�� ���ϱ� ������ ������ �߰� �ȴ�
	 *  ���� ��Ȳ�϶� �۵��Ҽ��� �ִٸ�, required=false �� �������ָ� �⺻������ �����ȴ�.)
	 * 
	 * cf#
	 * @RequestAttribute �� �̿� ����ϰ� �۵��ϰ� �Ǵµ�,
	 * Request��ü�� setAttribute �� ��ü�� �ٷ� Ȯ���ؼ�ó���ϰ��� �Ҵ� ���.
	 * 
	 */
	@RequestMapping("/10.do")
	public void study10handle(@SessionAttribute(required=false) Boolean auth, 
					@SessionAttribute(required=false) Map user) {
		System.out.println(auth);
		System.out.println(user);
	}
	
	
	
	
	
	
}





