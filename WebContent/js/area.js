  //위도 경도 입력 받아서 주변 상권 조회
  //Lcls:업종(S:의료, R학문/교육, P:스포츠, Q: 음식점)
  function area(cx, cy, Lcls) {
    var url =
      "https://apis.data.go.kr/B553077/api/open/sdsc2/storeListInRadius?" +
      "serviceKey=mk12gEaB6Y%2BWINIRO1Fi3NtA3AAMOVge7PrJiAGVxKNsOU2I5Ir3FpW%2FvB37s91CVqMW6puaZ0DSgjVIBxDM9g%3D%3D" +
      "&cx="+cx+"&cy="+cy+"&radius=500&indsLclsCd="+Lcls;

    return url;
  }


  function loadItems(cx, cy, Lcls) {
  	console.log(area(cx, cy, Lcls));
  	fetch(area(cx, cy, Lcls))//json파일 읽어오기
  	.then(function (resp){
  		return resp.text();
  	})
    .then(function (data) {
    	let parser = new DOMParser();
        let temp = parser.parseFromString(data, "text/xml");
        let items = temp.querySelectorAll("item");
        var el='';
        items.forEach(function (item) {
        	console.log(item);
        	el += `
            <tr>
            	<td>`+item.querySelector("bizesNm").textContent+`</td>
            	<td>`+item.querySelector("indsSclsNm").textContent+`</td>
            	<td>`+ item.querySelector("lnoAdr").textContent+`</td>
                    </tr>
                    `
          });
          
          document.getElementById("areaList").innerHTML = el;
      });
  }

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}
