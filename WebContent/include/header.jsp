<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav
	class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
	<div class="container">
		<a class="navbar-brand text-primary fw-bold" href="${root}"> <img
			src="${root}/img/ssafy_logo.png" alt="" width="60" /> Sweet Home
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-lg-0">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="${root}/board">게시판</a></li>
			</ul>
			<c:if test="${empty sessionScope.loginInfo}">
				<ul id="header-login-menu" class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item"><a id="btn_logout" class="nav-link"
						data-bs-toggle="modal" data-bs-target="#loginModal"
						aria-current="page" href="#">로그인</a></li>
					<li class="nav-item"><a class="nav-link"
						data-bs-toggle="modal" data-bs-target="#registerModal"
						aria-current="page" href="#">회원가입</a></li>
				</ul>
			</c:if>
			<c:if test="${not empty sessionScope.loginInfo}">
				<ul id="header-login-menu" class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item">${sessionScope.loginInfo.id}
						(${sessionScope.loginInfo.name})님 반갑습니다.</li>
					<li class="nav-item"><a class="nav-link"
						href="${root}/member?action=logout">로그아웃</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${root}/member?action=mypage">마이페이지</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>

<%@ include file="/pages/login.jsp"%>
<!-- 회원가입 모달창 -->
<%@ include file="/pages/register.jsp"%>