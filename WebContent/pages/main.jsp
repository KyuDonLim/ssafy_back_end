<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</div>