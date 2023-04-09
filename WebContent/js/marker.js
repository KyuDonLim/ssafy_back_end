var map;
var marker;

console.log('root', root);
function createMarker(jsonArray) {
	var items = jsonArray;
	var aptList = [];

	items = items.replaceAll('&#034;', '"');

	if (items == "[]") {
		alert("해당 지역의 매물이 없습니다!");

		var container = document.getElementById('map'); // 지도를 담을 영역의 DOM 레퍼런스
		var options = { // 지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(37.566869, 126.97867), // 지도의 중심좌표.
			level : 3
		// 지도의 레벨(확대, 축소 정도)
		};

		map = new kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
	} else {

		var obj = JSON.parse(items);

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div
		mapOption = {
			center : new kakao.maps.LatLng(obj[0].lat, obj[0].lng), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		for (var i = 0; i < obj.length; i++) {
			// 마커를 생성합니다
			marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : new kakao.maps.LatLng(obj[i].lat, obj[i].lng)
			// 마커의 위치
			});

			var apart = {
				aptCode : obj[i].aptCode,
				dong : obj[i].dong,
				jibun : obj[i].jibun,
				lat : obj[i].lat,
				lng : obj[i].lng,
				dongCode : obj[i].dongCode,
				apartmentName : obj[i].apartmentName,
				dealAmount: obj[i].dealAmount,
				area: obj[i].area,
				floor: obj[i].floor,
			};
			
				aptList.push(apart);
				showAptList(aptList);
			
			kakao.maps.event.addListener(marker, "click", showOverlay(apart));
		}
	}
}

var overlay;
var check = false;

function tdClick(item){
	console.log('receive', item);
	let tmp = showOverlay(item);
	tmp();
}

function showAptList(aptList){
	var el='';
	aptList.forEach(function (item) {
		console.log("!!!",JSON.stringify(item));
		 
    	el += `
    	<div style="border-radius: 30px 10px; background-color: rgb(121, 218, 53, 0.3);" >
    	<table class="table table-success table-striped">
					<tr>
						<th>
							아파트 이름
						</th>
						<td onclick='tdClick(`+JSON.stringify(item)+`)'>
							`+item.apartmentName+`
						</td>
					</tr>
					<tr>
						<th>
							층
						</th>
						<td>
							`+item.floor+`
						</td>
					</tr>
					<tr>
						<th>
							주소
						</th>
						<td>
							`+item.jibun+`
						</td>
					</tr>
				</table>
				</div>
        	`
      });
      
      document.getElementById("list").innerHTML = el;
}

function showOverlay(apart) {
	console.log("?????",apart);
//	apart = JSON.parse(apart);
	return function() {

		if (check) {
			closeOverlay();
		}

		check = true;
		var random = Math.floor(Math.random() * 10);

		// 커스텀 오버레이에 표시할 컨텐츠 입니다
		// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
		// 별도의 이벤트 메소드를 제공하지 않습니다
		var content = '<div class="card mb-3" style="width: 800px; height: 400px">'
				+ '<div class="row g-0">'
				+ '<div class="col-md-4" style="padding: 0.5em;">'
				+ '		<img src="./img/room'+String(random)+'.png" width="260px" height="350px">'
				+ '</div>'
				+ '<div class="col-md-8">'
				+ '<div class="xbox" style="float: right;" onclick="closeOverlay()">'
				+ '<button type="button" class="btn-close" aria-label="Close" style="margin: 1em;"></button>'
				+ '</div>'
				+ '<div class="card-body" style="height: 400px;">'
				+ '				<a class="btn btn-light" href = "'+root+'/interest?action=zzim&aptcode='+apart.aptCode+'">찜하기</a>'
				+ '		<form action="" method="POST">'
				+ '				<h1 class="card-title" style="text-align: center">'+ apart.apartmentName +'</h1>'
				+ '     		<div class="info-text" style="margin: 30px 0px 0px 0px;">'
				+ '<table class="table">'
				+ '		<tbody>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">동'
				+ '				<td>' + apart.dong + '</td>'
				+ '			</tr>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">지번'
				+ '				<td>' + apart.jibun + '</td>'
				+ '			</tr>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">거래가격'
				+ '				<td>' + apart.dealAmount + ' 만원</td>'
				+ '			</tr>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">평수'
				+ '				<td>' + apart.area + ' ㎡</td>'
				+ '			</tr>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">해당 층'
				+ '				<td>' + apart.floor + ' 층</td>'
				+ '			</tr>'
				+ '			<tr>'
				+ '				<th scope="row" "text-align:center">주변 상권 리스트'
				+ '				<td><a class="btn btn-light" href = "'+root+'/pages/area.jsp?lat='+apart.lat+'&lng='+apart.lng+'">바로가기</a></td>'
				+ '			</tr>'
				+ '		</tbody>'
				+ '</table>'
				+ '		</form>'	
				+ '</div>' 
				+ '</div>' 
				+ '</div>' 
				+ '</div>'

		// 마커 위에 커스텀오버레이를 표시합니다
		// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
		var latlng = new kakao.maps.LatLng(apart.lat, apart.lng);

		overlay = new kakao.maps.CustomOverlay({
			content : content,
			map : map,
			position : latlng,
		});

		// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
		kakao.maps.event.addListener(marker, 'click', function() {
			overlay.setMap(map);
		});

		// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
		
		//이동스
		panTo(apart.lat, apart.lng);

	}
}

function panTo(lat, lng) {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(lat, lng);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
}   

function closeOverlay() {
	overlay.setMap(null);
}