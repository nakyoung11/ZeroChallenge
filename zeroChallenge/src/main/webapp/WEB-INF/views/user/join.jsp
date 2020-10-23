<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<form class="joinform">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
		</div>

		<div class="form-label-group">
			<label for="name">이름</label> <input type="text" id="name"
				class="form-control" placeholder="Name" required autofocus>
		</div>
		
		<div class="form-label-group magin-top">
			<label for="birth">생년월일</label> <input type="text" id="birth"
				name="birth" class="form-control" placeholder="EX)19900101" required>
		</div>
		
		<div class="form-label-group magin-top ">

			<label for="ID">아이디</label>
				<div class="checker"><input type="text" id="userid"
					name="id" class="form-control" placeholder="ID" required autofocus>
				<input type="button" class="btn btn-lg btn-primary btn-block" id="idCheck" value="중복확인">	
				</div> 
		</div>
		
		<div class="form-label-group magin-top ">
			<label for="inputPassword">비밀번호</label> <input type="password"
				id="inputPassword" name="pw" class="form-control"
				placeholder="Password" required>
		</div>
		
		<div class="form-label-group magin-top">
			<label for="rq_inputPassword">비밀번호 확인</label> <input type="password"
				id="rq_inputPassword" name="rq_pw" class="form-control"
				placeholder="Password Confirm" required>
		</div>
		
		<div class="form-label-group magin-top ">
			<label for="email">이메일</label> <input type="email" id="email"
				name="email" class="form-control" placeholder="EMAIL" required>
		</div>
		
		<div class="col-auto my-1 magin-top">
			<label class="mr-sm-2" for="inlineFormCustomSelect">관심있는 시험</label>
			<select class="custom-select mr-sm-2" id="inlineFormCustomSelect">
				<option selected>시험을 선택하세요.</option>
				<option value="1">정보처리기사</option>
				<option value="2">정보처리산업기사</option>
				<option value="3">컴퓨터활용능력1급</option>
			</select>
		</div>


		<button class="btn btn-lg btn-primary btn-block" type="submit">가입</button>

	</form>



</div>
