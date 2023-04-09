<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- main 공지사항 -->
<div class="section section-properties">
	<div class="container" style="padding-top: 150px">
		<div class="two_third first row" style="height: auto">
			<div class="col-lg-8">
				<h2 class="font-weight-bold heading">공지사항</h2>
			</div>
			<div class="col-lg-3  col-auto" style="float: right">
				<form action="${root}/board" method="post">
					<input type="hidden" name="action" value="search" /> <input
						type="text" name="search" /> <input type="submit"
						class="btn btn-light" value="검색">
				</form>
			</div>
			<div class="col-lg-1" style="float: right">
				<c:if test="${not empty sessionScope.loginInfo }">
					<a href="${root}/board?action=mvwrite" class="btn btn-light">글쓰기</a>
				</c:if>
			</div>
			<hr />
			<br />
		</div>
		<table class="table table-hover">
			<tbody>
				<!-- 게시판 들어가는 목록 -->
				<c:forEach items="${requestScope.list.list1}" var="board">
					<tr class="table-success">
						<th scope="row">${board.type}</th>
						<td colspan="2"><a
							href="${root}/board?action=detail&bno=${board.bno}">${board.title}</a></td>
						<td>${board.write_date}</td>
					</tr>
				</c:forEach>

				<c:forEach items="${requestScope.list.list2}" var="board">
					<tr>
						<th scope="row">${board.type}</th>
						<td colspan="2"><a
							href="${root}/board?action=detail&bno=${board.bno}">${board.title}</a></td>
						<td>${board.write_date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link"
				href="${root}/board?action=${requestScope.list.type}&curpage=1&search=${requestScope.list.search}">&lt;</a></li>
			<c:if test="${requestScope.list.curpage > 1}">
				<li class="page-item"><a class="page-link"
					href="${root}/board?action=${requestScope.list.type}&curpage=${requestScope.list.startPage-1}&search=${requestScope.list.search}">이전</a></li>
			</c:if>
			<c:forEach begin="${requestScope.list.startPage}"
				end="${requestScope.list.endPage}" var="i">

				<c:if test="${requestScope.list.curpage == i}">
					<li class="page-item"><a class="page-link bg-primary text-light"
						href="${root}/board?action=${requestScope.list.type}&curpage=${i}&search=${requestScope.list.search}">${i}</a></li>
				</c:if>
				<c:if test="${requestScope.list.curpage != i}">
					<li class="page-item"><a class="page-link"
						href="${root}/board?action=${requestScope.list.type}&curpage=${i}&search=${requestScope.list.search}">${i}</a></li>
				</c:if>

			</c:forEach>
			<c:if
				test="${requestScope.list.curpage < requestScope.list.totalPage}">
				<li class="page-item"><a class="page-link"
					href="${root}/board?action=${requestScope.list.type}&curpage=${requestScope.list.endPage+1}&search=${requestScope.list.search}">다음</a></li>
			</c:if>
			<li class="page-item"><a class="page-link"
				href="${root}/board?action=${requestScope.list.type}&curpage=${requestScope.list.totalPage}&search=${requestScope.list.search}">&gt;</a></li>
		</ul>
	</nav>
</div>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>
</body>
</html>
