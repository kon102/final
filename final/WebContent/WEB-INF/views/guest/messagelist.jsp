<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h1>메세지함</h1>
<%-- <div class="list-group">
	<c:forEach var="l" items="${list }">
		<a href="${pageContext.servletContext.contextPath }/readmessage.do?no=${l.NO}&sender=${l.SENDER}&senddate=${l.SENDDATE}&content=${l.CONTENT}">${l.SENDER } | ${l.SENDDATE} | ${l.CONTENT }</a><br/>
	</c:forEach>
</div> --%>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">보낸사람</th>
      <th scope="col">보낸날짜</th>
      <th scope="col">읽은날짜</th>
      <th scope="col">내용</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="l" items="${list }">
	    <tr onclick="${pageContext.servletContext.contextPath }/readmessage.do?no=${l.NO}&sender=${l.SENDER}&senddate=${l.SENDDATE}&content=${l.CONTENT}">
	      <td>${l.SENDER }</td>
	      <td>${l.SENDDATE }</td>
	      <td>${l.CHKDATE }</td>
	      <td>${l.CONTENT }</td>
	    </tr>  	
  	</c:forEach>    
  </tbody>
</table>