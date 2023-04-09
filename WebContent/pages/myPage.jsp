<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- 헤더 종료 --------------------------------------------------------------------->
<div class="section section-properties">
	<div class="container" style="padding-top: 150px">
		<div class="two_third first row" style="height: auto">
			<div class="col-lg-6">
				<h2 class="font-weight-bold heading">회원 정보</h2>
			</div>
			<hr />
		</div>
		<div id="row two_third first">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col" class="col-md-2">이름</th>
						<td scope="col" colspan="2" class="col-md-4">${sessionScope.loginInfo.name}</td>
						<th scope="col" class="col-md-2">아이디</th>
						<td scope="col" class="col-md-2">${sessionScope.loginInfo.id}</td>
					</tr>
				</thead>
				<tbody>
					<tr style="height: 50px;">
						<td colspan="5" style="background-color: white;">- <b>${sessionScope.loginInfo.name}(${sessionScope.loginInfo.id})</b>님의
							회원 정보입니다.
						</td>
					</tr>
				<tbody>
					<tr>
						<th scope="row">이메일</th>
						<td colspan="4">${sessionScope.loginInfo.email}</td>
					</tr>
					<tr>
						<th scope="row">주소</th>
						<td colspan="4">${sessionScope.loginInfo.addr}</td>
					</tr>
					<tr>
						<th scope="row">전화번호</th>
						<td colspan="4">${sessionScope.loginInfo.phone}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 text-center"></div>

		<div class="col-lg-4 text-center">
			<form action="${root}/interest" method="post">
				<input class="btn btn-outline-success" type="submit"
					value="내가 찜한 매물"> <input type="hidden" name="action"
					value="interest">
			</form>
			<button class="btn btn-outline-primary" data-bs-toggle="modal"
				data-bs-target="#updateModal" aria-current="page" type="button">회원정보
				수정</button>
			<a class="btn btn-outline-primary" href="${root}"> 메인 페이지</a>
		</div>
	</div>

</div>
<!-- 로그인 모달창 -->
<%@ include file="/pages/login.jsp"%>
<!-- 회원가입 모달창 -->
<%@ include file="/pages/register.jsp"%>
<%@ include file="/pages/modifyMember.jsp"%>
<!-- 회원정보 수정-->

<script src="./js/member.js"></script>
<%@ include file="/include/footer.jsp"%>
