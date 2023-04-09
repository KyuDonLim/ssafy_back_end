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
				<h2 class="font-weight-bold heading">게시판 작성</h2>
			</div>
			<hr />
			<br />
		</div>
		<div class="two_third first row" style="height: auto">
			<form action="${root}/board" method="post">

				<div class="modal-body">
					<input type="hidden" name="action" value="write">
					<input type="hidden" name="userId" value="${sessionScope.loginInfo.name}">
					<div class="mb-3">
						<label for="register-input-pwd" class="register-input-pwd-label">분류 : </label>
						<select name="type" id="lang">
							<c:if test="${sessionScope.loginInfo.id eq 'admin'}" >
								<option value="공지사항">공지사항</option>
							</c:if>
							<option value="문의사항">문의사항</option>
						</select>
					</div>
					<div class="row mb-3 mt-3">
						<div class="col-md-12">
							<label for="register-input-id" class="register-input-id-label">제목</label>
							<input type="text" class="form-control" placeholder="제목을 입력하세요."
								id="register-input-id" name="title" />
						</div>
					</div>
					<div class="mb-3">
						<label for="register-input-pwd" class="register-input-pwd-label">내용</label><br />
						<textarea rows="20" cols="170" name = "content"></textarea>
					</div>
				</div>

				<div class="modal-footer">
					<input type="submit" class="btn btn-primary btn-sm" value="글 작성">
					<a href = "${root}/board" class="btn btn-outline-danger btn-sm"
					style ="margin-left:10px">취소</a>
				</div>
			</form>

		</div>
	</div>
</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</body>
</html>
