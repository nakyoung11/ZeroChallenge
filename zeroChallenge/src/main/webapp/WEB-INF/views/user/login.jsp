<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form class="form-signin">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">LOGIN</h1>
		</div>
		<p class="mt-5 mb-3 text-muted">${msg}</p>
		<div class="form-label-group">
		<label for="id">아이디</label>
			<input type="text" id="id" class="form-control" name="id"
				placeholder="ID" required autofocus> 
		</div>
		<div class="form-label-group magin-top">
		 <label for="inputPassword">비밀번호</label>
			<input type="password" id="inputPassword" name="pw" class="form-control"
				placeholder="Password" required>
		</div>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		<a class="text-center join" href="/user/join">회원가입</a>
		
	</form>



</div>