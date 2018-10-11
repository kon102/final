package controllers.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

/*
 *  요청처리메서드에 사용할수 있는 인자들을 좀더 살펴보자.
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
			one.put("NAME", "윤형호");
			one.put("grade", 3);
		wr.setAttribute("user", one, WebRequest.SCOPE_SESSION);
	}
	//================================================================
	/*
	 * @SessionAttribute
	 * 사용자세션에 이미 존재하는 특정객체를 확보해서 요청처리를 하고자할때 사용.
	 * (세션에 존재하지 않을때는 객체를 주입시키지 못하기 때문에 에러가 뜨게 된다
	 *  없는 상황일때 작동할수도 있다면, required=false 를 설정해주면 기본값으로 설정된다.)
	 * 
	 * cf#
	 * @RequestAttribute 도 이와 비슷하게 작동하게 되는데,
	 * Request객체에 setAttribute 된 객체를 바로 확보해서처리하고자 할대 사용.
	 * 
	 */
	@RequestMapping("/10.do")
	public void study10handle(@SessionAttribute(required=false) Boolean auth, 
					@SessionAttribute(required=false) Map user) {
		System.out.println(auth);
		System.out.println(user);
	}
	
	
	
	
	
	
}





