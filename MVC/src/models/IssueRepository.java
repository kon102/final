package models;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 디비 억세스해서 데이터 연동작업하는 객체를
 * 			DAO 라고도 부르고,  Repository 라고 부른다.
 * 
 */
@Repository
public class IssueRepository {
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSessionTemplate template;
	
	public List<Map> getAllIssue() {
		SqlSession session = factory.openSession();
		try {
			return session.selectList("issue.getAllIssue");
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}
	
	
	public List<Map> getAllWithOpinionCount() {
		return template.selectList("issue.getAllWithOpinionCount");
	}
	
}
