<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="container">
	<form class="joinform" action="/user/join" method="post" id="joinform"
		onsubmit="return chk()">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
		</div>

		<div class="form-label-group magin-top ">
		 <c:if test="${id!=null||id>0}">
			<div class="form-label-group magin-top ">
				<label for="email">이메일</label>
				 <input type="email" id="email"
					name="user_email" class="form-control" placeholder="EMAIL" required autofocus 
					value="<c:out value="${email}"></c:out>">
			
			
			</div>

			<div class="form-label-group  magin-top">
				<label for="name">이름</label> <input type="text" id="name"
					name="user_nm" class="form-control" placeholder="Name" required
					autofocus value="<c:out value="${name}"></c:out>">
				
			</div>
			</c:if>
			
			
			<c:if test="${id}<0||${id}==null">
				<div class="form-label-group magin-top">
					<label for="birth">생년월일</label> <input type="text" id="birth"
						name="birth" class="form-control" placeholder="EX)19900101"
						required>
				</div>
				
	
	
				<div class="form-label-group magin-top ">
					<label for="inputPassword">비밀번호</label> <input type="password"
						id="inputPassword" name="user_pw" class="form-control"
						placeholder="Password" required>
				</div>
	
				<div class="form-label-group magin-top">
					<label for="rq_inputPassword">비밀번호 확인</label> <input type="password"
						id="rq_inputPassword" name="rq_pw" class="form-control"
						placeholder="Password Confirm" required>
				</div>

			</c:if>
			
			<div class="col-auto my-1 magin-top">
				<label class="mr-sm-2" for="inlineFormCustomSelect">관심있는 시험</label>
				<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="target">
					<option selected>시험을 선택하세요.</option>
					<option value="1">정보처리기사</option>
					<option value="2">정보처리산업기사</option>
					<option value="3">컴퓨터활용능력1급</option>
				</select>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">가입</button>
	</form>



</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
console.log("${id}");
console.log("${email}");
console.log("${name}");
</script>
