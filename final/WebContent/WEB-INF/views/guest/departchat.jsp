<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">GROUPWARE</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.NAME }</button>
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.DNAME }
				${sessionScope.user.PNAME }</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar"></span> ${sessionScope.userId }
		</button>
	</div>
</div>

<h4>Chat Room <small>(Departments)</small></h4>
<div style="height: 520px; overflow-y: scroll; " id="chatView">
	
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">CHAT</span>
  </div>
  <input type="text" class="form-control" aria-describedby="basic-addon1" id="input">
</div>
<script>
	var departchatws = new WebSocket("ws://"+location.host+"${pageContext.servletContext.contextPath}/departchat.do");
	
	departchatws.onmessage = function(evt){
		console.log(evt.data);
		var obj = JSON.parse(evt.data);
		switch(obj.mode){
		case "depart":
			departHandle(obj);
			break;
		}
	}
	
	
	var departHandle = function(obj){
		var txt = obj.text;
		var html = "<div class=\"alert alert-secondary\" role=\"alert\">"+obj.talker+": ";
		html += obj.text;
		html +="</div>";
		document.getElementById("chatView").innerHTML += html;
		document.getElementById("chatView").scrollTop = 
			document.getElementById("chatView").scrollHeight;
	}
	
	
	
	document.getElementById("input").onchange = function(){
		console.log(this.value);
		var msg = {
				"mode":"depart",
				"text":this.value,
				"talkdate":new Date()//몇분전 처리
				//"talker":"${userId}"
		}
		departchatws.send(JSON.stringify(msg));
		this.value = "";
		
	};
	
	
</script>
