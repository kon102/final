package app.controller.guest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import app.model.EmployeeRepository;
import app.model.MessageRepository;
import app.service.SocketService;

@Controller
public class WelcomeController {
	Map<String, HttpSession> sessions;

	public WelcomeController() {
		sessions = new HashMap<>();
	}

	@Autowired
	Gson gson;
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	@Autowired
	SocketService socketService;
	
	@Autowired
	MessageRepository messageRepository;

	@RequestMapping("/index.do")
	public String indexHandle(@SessionAttribute(required = false) String auth, Map attr) {
		if (auth == null) {
			return "index";
		} else {

			return "guest.home";
		}
	}

	@RequestMapping("/login.do")
	public String loginHandle(WebRequest webRequest, @RequestParam Map p, HttpSession session) {
		int cnt = employeeRepository.checkEmployee(p);
		if (cnt > 0) {
			// 중복로그인 막기 ==========================================
			String id = (String) p.get("id");
			Map one = employeeRepository.getEmployee(id);

			if (sessions.containsKey(id)) {
				Map alert = new HashMap<>();
				alert.put("mode", "overlap");
				alert.put("actor", id);
				alert.put("alert", "다른곳에서 로그인하였습니다. 로그아웃합니다. 새로고침해주세요.");
				socketService.sendOne(alert, id);
				//sessions.get(id).invalidate();
				sessions.get(id).removeAttribute("auth");
				sessions.get(id).removeAttribute("user");
				sessions.get(id).removeAttribute("userId");
				sessions.remove(sessions.get(id));
			}
				//====================================================================
				// 새로 로그인 사용자 세션 등록
		
				sessions.put(id, session);
				
				webRequest.setAttribute("userId", id, WebRequest.SCOPE_SESSION);
				webRequest.setAttribute("user", one, WebRequest.SCOPE_SESSION);
				webRequest.setAttribute("auth", "on", WebRequest.SCOPE_SESSION);

				Map msg = new HashMap<>();
					msg.put("mode", "login");
					msg.put("actor", one);
				socketService.sendAll(msg);
		
		}
		return "redirect:/index.do"; // redirect:/index.do
	}

	@RequestMapping("/logout.do")
	public String logoutHandle(HttpSession session) {
		sessions.remove(session.getAttribute("userId"));
		session.invalidate();
		return "redirect:/index.do";
	}
	
	@GetMapping("/changepw.do")
	public String changepwGetHandle() {
		return "guest.changepw";
	}
	
	@PostMapping("/changepw.do")
	public String changepwPostHandle(@RequestParam Map param, HttpSession session, ModelMap modelMap) {
		String id = (String)session.getAttribute("userId");
		param.put("id", id);
		int r = employeeRepository.changePw(param);
		if(r==1) {
			modelMap.put("changepw", true);
			return "guest.changepw";
		}else {
			modelMap.put("changepw", false);
			modelMap.put("msg","비밀번호가 변경되지 않았습니다. 다시 시도해주세요");
			return "guest.changepw";
		}
	}
	
	//=====================================================================
	// 메세지 보내기용에서 ID 조회 하는 AJAX
	@PostMapping("/searchid.do")
	@ResponseBody
	public String searchidHandle(@RequestBody String body) {
		String rst = employeeRepository.searhid(body);
		return gson.toJson(rst);
	}
	
	@GetMapping("/sendmessage.do")
	public String sendmessageGetHandle() {
		return "guest.sendmessage";
	}
	
	@PostMapping("/sendmessage.do")
	public String sendmessagePostHandle(@RequestParam Map param, HttpSession session, ModelMap modelMap) {
		String sender = (String)session.getAttribute("userId");
		param.put("sender", sender);
		int r =  messageRepository.sendMessage(param);
		if(r==1) {
			Map message = messageRepository.realmessageinfo(sender);
			param.put("mode", "message");
			param.put("messageinfo", message);
			socketService.sendOne(param, (String)param.get("receiver"));
			
			modelMap.put("send", true);
		}else {
			modelMap.put("send", false);
		}
		return "guest.sendmessage";
	}
	
	@RequestMapping("/messagelist.do")
	public String messagelistHandle(HttpSession session, Map map) {
		List<Map> msglist = messageRepository.getMessageList((String)session.getAttribute("userId"));
		map.put("list", msglist);
		return "guest.messagelist";
	}
	
	@RequestMapping("/readmessage.do")
	public String readmessageHandle(@RequestParam Map param,Map map) {
		int no = Integer.parseInt((String)param.get("no"));
		int r = messageRepository.readmessage(no);
		map.put("message", messageRepository.getMessage(no));
		return "guest.readmessage";
	}
	
	@RequestMapping("/unreadmessagelist.do")
	public String unreadmessagelistHandle(HttpSession session,Map map) {
		List<Map> msglist = messageRepository.getMessageList((String)session.getAttribute("userId"));
		map.put("list", msglist);
		return "guest.unreadmessagelist";
	}
	
	//=================chat======================
	@RequestMapping("/chat/room.do")
	public String chatroomHandle() {
		return "guest.room";
	}
	
	@RequestMapping("/chat/departchat.do")
	public String departchatHandle() {
		return "guest.departchat";
	}
	
	
	
	
}
