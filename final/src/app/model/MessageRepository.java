package app.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {

	@Autowired
	SqlSessionTemplate template;
	
	public int sendMessage(Map data) {
		return  template.insert("emmessage.sendMessage", data);
	}
	
	public List<Map> getMessageList(String receiver){
		return template.selectList("emmessage.getMessageList", receiver);
	}
	
	public int readmessage(int no) {
		return template.update("emmessage.readmessage", no);
	}
	
	public Map getMessage(int no) {
		return template.selectOne("emmessage.getMessage", no);
	}
	public Map realmessageinfo(String sender) {
		return template.selectOne("emmessage.realmessageinfo", sender);
	}
	
}
