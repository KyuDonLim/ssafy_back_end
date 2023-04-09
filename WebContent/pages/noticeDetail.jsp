<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- main 공지사항 -->
<div class="section section-properties">
	<div class="container" style="padding-top: 150px">
		<div class="two_third first row" style="height: auto">
			<div class="col-lg-12">
				<h2 class="font-weight-bold heading">${requestScope.board.type}</h2>
			</div>
			<hr />
			<div class="col-lg-6">
				<label for="register-input-id">작성자 : </label>
				<span>${requestScope.board.writer}</span>
				
			</div>
			<div class="col-lg-3">
				<label for="register-input-id" style ="float:right">작성 시간 : </label>
			</div>
			<div class="col-lg-3">
				<span  style ="float:right">${requestScope.board.write_date}</span>
			</div>
			<div class="col-lg-12 border border-opacity-50" style="height:300px; margin-top :15px;">
				<div>${requestScope.board.content}</div>
			</div>
			<div class="col-lg-12 col-auto" style="margin-top:10px">
				<a href = "${root}/board" class="btn btn-light btn-sm"
					style ="margin-left:10px; float:right">목록</a>
			</div>
			
		</div>
		
	</div>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</body>
</html>
