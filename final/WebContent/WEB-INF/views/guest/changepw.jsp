<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty changepw }">
	<c:choose>
		<c:when test="${changepw==true }">
			<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>PassWord Change SUCCESS</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>PassWord Change FAILED</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			</div>		
		</c:otherwise>
	</c:choose>
</c:if>

<form action="${pageContext.servletContext.contextPath }/changepw.do" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Before Password</label>
    <input name="pass" type="password" class="form-control" id="password" aria-describedby="emailHelp" placeholder="Passowrd" onchange="chkpass(this);">
    <small id="passchk" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">New Password</label>
    <input name="npass" type="password" class="form-control" id="npassword" placeholder="New Password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">New Password Retry</label>
    <input type="password" class="form-control" id="npasswordrty" placeholder="New Password Retry" onkeyup="checkpw(this);">
    <small id="chkpwrty" class="form-text text-muted"></small>
  </div>
  <button id="btn" type="submit" class="btn btn-primary">변경</button>
</form>
<script>

	var chkpass = function(target){
		//Ajax 구현
		
		
	};

	var checkpw = function(retry){
		var npass = document.getElementById("npassword").value;
		var msg = document.getElementById("chkpwrty");
		var submit = document.getElementById("btn");
		if(npass==retry.value){
			msg.innerHTML = "새로운 비밀번호가 일치합니다.";
			retry.style.color = "green";
			
		}else{
			msg.innerHTML = "새로운 비밀번호가 일치하지 않습니다. 다시 확인해주세요.";
			retry.style.color = "red";
			
		}
	};
</script>