<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- main 공지사항 -->
<div class="section section-properties">
	<div class="container" style="padding-top: 150px">
		<div class="two_third first row" style="height: auto">
			<div class="col-lg-9">
				<h2 class="font-weight-bold heading">주변상권</h2>
			</div>
			<hr />
			<br />
		</div>
		<table class="table table-hover">
			<thead>
				<tr class="table-">
					<th scope="row" onclick="loadItems(126.573301,33.449826,'Q')">상가
						분류</th>
					<th scope="row">상가 이름</th>
					<th scope="row">주소</th>
				</tr>
			</thead>
			<tbody id="areaList">

			</tbody>
		</table>
	</div>
</div>

<!-- 로그인 모달창 -->
<%@ include file="/pages/login.jsp"%>
<!-- 회원가입 모달창 -->
<%@ include file="/pages/register.jsp"%>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<script src="${root}/js/area.js"></script>
<script>
var lat = getParameterByName("lat");
var lng = getParameterByName("lng");

loadItems(lng,lat,'Q');
</script>
</body>
</html>
