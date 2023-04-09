<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- 헤더 종료 --------------------------------------------------------------------->
<!-- main 지도화면 종료 ---------------------------------------------------------------->
<%@ include file="/pages/main.jsp"%>
<!-- 로그인 모달창 -->
<%@ include file="/pages/login.jsp"%>
<!-- 회원가입 모달창 -->


<%@ include file="/pages/register.jsp"%>

<%@ include file="/include/footer.jsp"%>

<script src="js/createMap.js"></script>