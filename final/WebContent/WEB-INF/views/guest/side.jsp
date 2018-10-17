<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar-sticky">
	<ul class="nav flex-column">
		<li class="nav-item"><a class="nav-link active" href="#"> <span
				data-feather="home"></span> Dashboard <span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link ${ uri=='changepw' ? 'active':'' }" 
			href="${pageContext.servletContext.contextPath }/changepw.do"> <span
				data-feather="file"></span> 비밀번호변경
		</a></li>
		<li class="nav-item"><a class="nav-link ${ uri=='chat' ? 'active':'' }" 
			href="${pageContext.servletContext.contextPath }/chat/room.do"> <span
				data-feather="users"></span> Chat
		</a></li>
		<li class="nav-item"><a class="nav-link ${ uri=='departchat' ? 'active':'' }" 
			href="${pageContext.servletContext.contextPath }/chat/departchat.do"> <span
				data-feather="users"></span> 부서채팅
		</a></li>
	</ul>
	<h5
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>메세지</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h5>
	<ul class="nav flex-column mb-2">
		<li class="nav-item"><a class="nav-link ${ uri=='sendmessage' ? 'active':'' }" 
			href="${pageContext.servletContext.contextPath }/sendmessage.do"> <span
				data-feather="file-text"></span> 메세지 보내기
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/messagelist.do"> <span
				data-feather="file-text"></span> 전체메세지함
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/unreadmessagelist.do"> <span
				data-feather="file-text"></span> 안읽은 메세지함
		</a></li>
	</ul>
	<hr/>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>Saved reports</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<p>
	
		${user.ID } | ${user.NAME } | ${user.DNAME } | ${user.PNAME }
	</p>
	<div id="alert" style="font-size: .75em">
	<a href="" class="alert-ling"></a>
	</div>
	
	<script>
		
		var ws = new WebSocket("ws://"+location.host+"${pageContext.servletContext.contextPath}/alert.do");
		ws.onmessage = function(evt) {
			console.log(evt.data);
			var obj = JSON.parse(evt.data);
			switch(obj.mode) {
			case "login":
				loginAlertHandle(obj);
				break;
			case "overlap":
				overlapAlertHandle(obj);
				break;
			case "message":
				messageAlertHandle(obj);
				break;
			case "public":
				publicAlertHandle(obj);
				break;
			case "depart":
				departAlertHandle(obj);
				break;
			}
		};
		
		
		var loginAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【로그인】</strong><br/>" + obj.actor.NAME+"(" + obj.actor.DNAME+"/"+ obj.actor.PNAME+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</button>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		};
		
		var overlapAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【중복로그인】</strong><br/>" + obj.actor+"(+"+obj.alert+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</button>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
			document.getElementById("alert").innerHTML = "";
		};
		
		var messageAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<a href=\"${pageContext.servletContext.contextPath}/readmessage.do?no="+obj.messageinfo.NO+"\">보러가기</a>";
			html += "<strong>【메세지】</strong><br/> from : " +obj.sender+"("+ obj.content+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</button>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		};
		
		var publicAlertHandle = function(obj){
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【전체채팅】</strong><br/>" + obj.talker+"(전체 채팅을 했습니다.)";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</button>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		};
		
		var departAlertHandle = function(obj){
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【부서채팅】</strong><br/>" + obj.talker+"(부서 채팅을 했습니다.)";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</button>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		}
		
		
	</script>
</div>
