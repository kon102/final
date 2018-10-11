package controllers.study;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Pet;

@Controller
@RequestMapping("/study")
public class BravoController {
	/*
	 * @RequestParam �Ķ���͸� �ٷ� Ȯ���ؼ� ��ûó���ϰ� ������
	 * 
	 * �������̶� ���� �Ķ���͸��� �����͸� Ȯ���ؼ� Inject ó����.
	 */
	@RequestMapping("/05.do")
	public void study05Handle(@RequestParam String[] word, @RequestParam int p) {
		System.out.println("study05Handle..");
		System.out.println("word = " + word);
		for(int i=0; i<word.length; i++) {
			System.out.println("word= " + word[i] );
		}
		System.out.println("p = " + p);
	}
	
	@RequestMapping("/06.do")
	public void study06Handle(@RequestParam Map param, @RequestParam int a) {
		// RequestParam �� ������ Map�� �����͵��� String,String ���� Ȯ���ȴ�.
		// cf, MultiValue ó�� �ȵǰ�, ��ġ�������͵� �̰� String���� ������.
		System.out.println("study06Handle..");
		String ment = (String)param.get("ment");
		String score = (String)param.get("score");
		System.out.println("score="+score+"/ment="+ment);
	}
	
	@RequestMapping("/07.do")
	public void study07Handle(@RequestParam MultiValueMap param) {
		// RequestParam �� ������ MulitValueMap�� �����͵��� String, List<String> ���� Ȯ���ȴ�.
		// cf, �����̸����� �Ѿ�� �����͵��� List�� �����µ�, �ϳ��� �Ѿ�͵� List��.
		System.out.println("study07Handle..");		
		List<String> ment = (List<String>)param.get("ment");
		List<String> score = (List<String>)param.get("score");
		System.out.println("score="+score+"/ment="+ment);
	}
	
	
	@RequestMapping("/08.do")
	public void study08Handle(@ModelAttribute Pet pet) {
		System.out.println("study08Handle..");
		System.out.println(pet.toString());
	}
	
}





