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
				<h2 class="font-weight-bold heading">찜한 매물 정보</h2>
			</div>
			<hr />
		</div>
		<div id="row two_third first">
			<table class="table table-hover">
				<thead>
					<tr>
						<th colspan="5" style="background-color: white;"> 아파트 이름 </th>
						<th colspan="5" style="background-color: white;"> 동 </th>
						<th colspan="5" style="background-color: white;"> 지번 </th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${requestScope.interestList}" var="list">
					<tr style="height: 50px;">
						<td colspan="5" style="background-color: white;">${list.apartmentName }</td>
						<td colspan="5" style="background-color: white;"> ${list.dong } </td>
						<td colspan="5" style="background-color: white;"> ${list.jibun } </td>
						<td colspan="5" style="background-color: white;">
						<form action="${root}/interest" method="post">
						<input type="hidden" name="action" value="delete">
						<input type="hidden" name=dong value="${list.dong }">
						<input type="hidden" name="jibun" value="${list.jibun }">
							<button>삭제</button> 
						</form>
						</td>
					</tr>
					</c:forEach>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 text-center">
		</div>
	
		<div class="col-lg-4 text-center">
			<a class="btn btn-outline-primary" href = "${root}">
				메인 페이지</a>
				<a class="btn btn-outline-primary" href = "${root}/member?action=resister">
				회원정보</a>
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