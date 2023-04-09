<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<%@ include file="/include/head.jsp"%>
<!-- 헤더 ------------------------------------------------------------------------>
<%@ include file="/include/header.jsp"%>
<!-- 헤더 종료 --------------------------------------------------------------------->
<!-- main 지도화면 종료 ---------------------------------------------------------------->
<div id="map" style="width: 100vw; height: 100vh">
	<div
		style="position: relative; margin-top: 80px; margin-left: 30%; z-index: 2; height: 8%; background-color: rgb(255, 255, 255, 0.8); width: 40%; border-radius: 30px; text-align: center;">
		<div style="padding-top: 20px; ">
			<div>
				<!-- 아파트 매매 정보 검색 start -->
				<div>
					<form action="${root }/map" method="POST">
						<input type="hidden" name="action" value="search">
						<div style="display: inline-block;">
							<select class="form-select bg-success text-light bg-opacity-50"
								id="sido" name="sido">
								<option value="">시도선택</option>
							</select>
						</div>
						<div style="display: inline-block;">
							<select class="form-select bg-success text-light bg-opacity-50"
								id="gugun" name="gugun">
								<option value="">구군선택</option>
							</select>
						</div>
						<div style="display: inline-block;">
							<select class="form-select bg-success text-light bg-opacity-50"
								id="dong" name="dong">
								<option value="">동선택</option>
							</select>
						</div>
						<div style="display: inline-block;">
							<button type="submit" id="list-btn"
								class="btn btn-outline-primary">조회</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<div
		style="position: relative; margin-left: 2%; z-index: 2; height: 78%; background-color: rgb(255, 255, 255, 0.8);
		 width: 20%; border-radius: 30px; text-align: center; overflow: auto;">
		<div style="padding-top: 10%">
			<div id="list" >
			
			</div>
		</div>

	</div>
</div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2c45a57d65518ab4eebc76e4b1a15772&libraries=services,clusterer,drawing"></script>
<script src="js/marker.js?ver"></script>
<script>
	//createMarker('<c:out value="${jsonArray}"/>');
	if('${sessionScope.jsonArray}' == []){
		createMarker('<c:out value="${jsonArray}"/>');
	}else{
		createMarker('<c:out value="${sessionScope.jsonArray}"/>');
	}
	console.log('zzzzzzzzzzzz')
</script>
<!-- 로그인 모달창 -->
<%@ include file="/pages/login.jsp"%>
<!-- 회원가입 모달창 -->

<%@ include file="/pages/register.jsp"%>
<script src="js/map.js"></script>

<%@ include file="/include/footer.jsp"%>