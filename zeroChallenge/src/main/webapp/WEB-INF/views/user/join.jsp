<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<form class="joinform" action="/user/join" method="post" id="joinform"
		onsubmit="return chk()">


		<c:choose>
			<c:when test="${naverUser.user_id==null||naverUser.user_id==''}">
				<input type="hidden" value="3" name="subscription_path">
			</c:when>
			<c:when test="${naverUser.user_id!=null||naverUser.user_id!=''}">
				<input type="hidden" value="${naverUser.subscription_path}"
					name="subscription_path">
			</c:when>
		</c:choose>

		<input type="hidden" value="${naverUser.age}" name="age">
		<input type="hidden" value="${naverUser.user_email}" name="user_email">
		<input type="hidden" value="${naverUser.user_nm}" name="user_nm">
		<div class="text-center">
			<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
		</div>




		<c:if test="${naverUser.user_id==null||naverUser.user_id==''}">
			<fieldset class="form-label-group magin-top ">
				<legend class="sr-only">개인정보</legend>
				<c:if test="${naverUser.user_id!=null||naverUser.user_id!=''}">
					<div class="flexbox form-label-group magin-top ">
						<label for="email">이메일</label> <input type="email" id="email"
							name="user_email" class="form-control" placeholder="EMAIL"
							required autofocus
							value="<c:out value="${naverUser.user_email}"></c:out>">
						<button onclick="chkEmail" id="chkEmail" class="btn btn-light">중복확인</button>

					</div>

					<div class="form-label-group  magin-top">
						<label for="name">이름</label> <input type="text" id="name"
							name="user_nm" class="form-control" placeholder="Name" required
							autofocus value="<c:out value="${naverUser.user_nm}"></c:out>">

					</div>
				</c:if>

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
					<label for="rq_inputPassword">비밀번호 확인</label> <input
						type="password" id="rq_inputPassword" name="rq_pw"
						class="form-control" placeholder="Password Confirm" required>
				</div>
		</c:if>
		</fieldset>



		<fieldset class="form-label-group my-1 magin-top">
			<legend class="sr-only">관심분야</legend>
			<label class="mr-sm-2" for="inlineFormCustomSelect">관심있는 시험</label> <select
				class="custom-select mr-sm-2" id="inlineFormCustomSelect"
				name="target">
				<option selected>시험을 선택하세요.</option>
				<option value="1">정보처리기사</option>
				<option value="2">정보처리산업기사</option>
				<option value="3">컴퓨터활용능력1급</option>
			</select>
		</fieldset>
		<button class="btn btn-lg btn-primary btn-block" type="submit">가입</button>
	</form>



</div>

<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>


<script>
	function chkEamil() {

	}
</script>
