<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${!empty send }">
	<c:choose>
		<c:when test="${send==true }">
			<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>Message send SUCCESS</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>Message send FAILED</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			</div>		
		</c:otherwise>
	</c:choose>
</c:if>


<form action="${pageContext.servletContext.contextPath }/sendmessage.do" method="post">
  <div class="form-group">
    <label>받을사람</label>
    <input name="receiver" type="text" class="form-control" id="receiver" aria-describedby="emailHelp"
     placeholder="Recevier ID" onchange="idchk(this.value);" autocomplete="off">
    <small id="receiverchk" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="content">내용</label>
    <textarea name="content" class="form-control" placeholder="내용"></textarea>
  </div>
  <button id="sbt" type="submit" class="btn btn-primary" disabled >보내기</button>
</form>

<script>
	var idchk = function(target){
		var xhr = new XMLHttpRequest();
		xhr.open("post","${pageContext.servletContext.contextPath}/searchid.do",true);
		xhr.onreadystatechange = function(){
			if(this.readyState==4){
				var obj = JSON.parse(this.responseText);
				if(obj==null){
					document.getElementById("receiverchk").innerHTML = "존재하지 않는 아이디입니다.";
					document.getElementById("receiverchk").style.color = "red";
					document.getElementById("sbt").disabled = true;
				}else{
					document.getElementById("receiverchk").innerHTML = "존재하는 아이디입니다.";
					document.getElementById("receiverchk").style.color = "green";
					document.getElementById("sbt").disabled = false;
				}
			}
		};
		xhr.send(target);
	};
	
	
</script>