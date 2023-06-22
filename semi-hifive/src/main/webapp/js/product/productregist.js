
const context = "http://localhost:9090/semi-hifive";

// 사진 불러오기 작업 

let prouductImgCnt = 0;

function getImageFiles(e) {
	const uploadFiles = [];
	const files = e.currentTarget.files;
	const imagePreview = document.querySelector('.image-preview');

	if (prouductImgCnt >= 10) {
		alert('이미지는 최대 10개 까지 업로드가 가능합니다.');
		return;
	}

	// 파일 타입 검사
	[...files].forEach(file => {  // 이미지 파일외 다른 파일 업로드시 (문구 + 이미지 적용 x)
		if (!file.type.match("image/.*")) {
			alert('이미지 파일만 업로드가 가능합니다.');
			return
		}

		// 파일 갯수 검사
		if ([...files].length < 11) { // 한번에 10개까지 이미지 등록가능

			const reader = new FileReader();
			reader.onload = (e) => {
				const preview = createElement(e, file);
				imagePreview.appendChild(preview);
			};

			uploadFiles.push(file); // 이미지 파일이 7개 미만이면 배열에 파일추가
			prouductImgCnt++;  // 이미지 추가시 개수 증가
			$(".imgCount").text("(" + prouductImgCnt + "/10" + ")");
			console.log(prouductImgCnt);
			reader.readAsDataURL(file);  // 업로드 파일 읽어오기 (이문구 없으면 이미지 추가되지않음)
		}



		/*		        // 파일 갯수 검사
				if ((prouductImgCnt+[...files].length) < 11) { // 한번에 10개까지 이미지 등록가능
		
					const reader = new FileReader();
					reader.onload = (e) => {
						const preview = createElement(e, file);
						imagePreview.appendChild(preview);  
					};
		
				    
					// uploadFiles.push(file); // 이미지 파일이 7개 미만이면 배열에 파일추가
					prouductImgCnt++;  // 이미지 추가시 개수 증가
					$(".imgCount").text("("+prouductImgCnt+"/10"+")");
					console.log(prouductImgCnt);
					reader.readAsDataURL(file);  // 업로드 파일 읽어오기 (이문구 없으면 이미지 추가되지않음)
				}
				else{
					alert('이미지는 한번에 10개까지 등록 가능합니다.');
					return
				}*/


	});
}


// 태그 만들어주는 함수
function createElement(e, file) {
	const li = document.createElement('li');    // li 태그 만들기
	const img = document.createElement('img');  // img 태그 만들기
	img.setAttribute('src', e.target.result); // 만든 img 태그에 경로 속성 값 넣어줌
	img.setAttribute('data-file', file.name); // 만들 ing 태그에 파일 이름 속성 값 넣어줌


	img.addEventListener("click", e => {  // 해당 이미지 클릭시
		prouductImgCnt--; // 이미지 삭제시 개수 감소
		$(e.target).parent().remove(); // li안의 img까지 삭제
		$(".imgCount").text("(" + prouductImgCnt + "/10" + ")");
	});

	li.appendChild(img); // 이미지가 있는 li 태그 완성하여 li 리턴

	return li;
}

const realUpload = document.querySelector('.real-upload');
const upload = document.querySelector('.upload');

upload.addEventListener('click', () => realUpload.click()); // 이미지등록 클록시 input file타입 호출
realUpload.addEventListener('change', getImageFiles); // file타입에서 값 변경시키면 getImageFiles() 함수 호출




// ==== 가격 입력했을 때, 숫자만입력되고, 3자리수마다 ,로 구분해주는 작업
function comma(str) {
	str = String(str);
	return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
}

function uncomma(str) {
	str = String(str);
	return str.replace(/[^\d]+/g, "");
}

function inputNumberFormat(obj) {
	obj.value = comma(uncomma(obj.value));
}
//=====================================================


// ==== 제목 글자수 세주는 작업=====
$(".inputTitle").keyup(e => { // 해당 텍스트부분을 입력할 때
	$(".countTitle").text($(e.target).val().length + "/40");
	const length = $(e.target).val().length;

	if (length > 40) {
		alert("40글자 이하로 작성하세요");
		$(e.target).val($(e.target).val().substring(0, 40));
	}
	$(".countTitle").text($(e.target).val().length + "/40");
})




// -------------------------------------------------------------------------------------------------------------------
// 카테고리 선택하는 작업

$(()=>{
	$(".mainCate").trigger("change",$(".mainCate:selected").val());  // 페이지로딩되었을때, 자동으로 change 함수 실행
	 														//	대상값은 현재 그 select에 선택된 값
})

function chageSubCate(value) {
	console.log(value);
	$.ajax({
		url: "findSubCate",
		data: {"cateId": value},
		success: function(result) {
		
			const subCate = result.split(","); // 문자열로 넘어온 값들을 ,를 구분자로 배열을 만듬
			
			$(".middleCate option").remove();   // 메인카테고리 선택할때마다 옵션들 다 삭제
			for(let i=0; i<subCate.length; i++){
					var option = $("<option value=" + subCate[i] + ">"+subCate[i]+"</option>");
					$(".middleCate").append(option);
			}
		},
		error: function() {
			console.log("카테고리 선택 오류발생");
		}
	})
}





/*$(function() {
	var arr = ["서울", "경기도", "인천"];
	for(var i=0; i<arr.length; i++){
	var optionLabel = arr[i];
	var optionValue = 65+i;  
	optionValue = String.fromCharCode(optionValue); // 밸류값을 알파벳으로 바꿈
	
	
	var option = $("<option value=" + optionValue + ">" + optionLabel+"</option>");
	$(".mainCate").append(option);
	}
});*/


// -------------------------------------------------------------------------------------------------------------------

// 거래지역 선택 (api 코드)
function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("sample6_extraAddress").value = extraAddr;

			} else {
				document.getElementById("sample6_extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('sample6_postcode').value = data.zonecode;
			document.getElementById("sample6_address").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("sample6_detailAddress").focus();
		}
	}).open();
}



// -------------------------------------------------------------------------------------------------------------------



// ==== 설명 글자수 세주는 작업=====
$(".explan").keyup(e => { // 해당 텍스트부분을 입력할 때
	$(".countExpaln").text($(e.target).val().length + "/40");
	const length = $(e.target).val().length;

	if (length > 2000) {
		alert("2000글자 이하로 작성하세요");
		$(e.target).val($(e.target).val().substring(0, 2000));
	}
	$(".countExpaln").text($(e.target).val().length + "/2000");
})


// -------------------------------------------------------------------------------------------------------------------


// 상품태그 검색 관련 js
const dataList = ["#빨간색", "#파란색", "#노란색", "#검정색", "#빨강", "#빨대", "#빨지마", "#빨빨이", "#빨래", "#빨적", "#빨망", "#빨리와", "#빨각모", "#빨공", "#빨명", "#빨사"];
let registTagList = [];

const $searchTag = document.querySelector("#searchTag");
const $autoComplete = document.querySelector(".autocomplete");

let nowIndex = 0;
let matchDataList;
$searchTag.onkeyup = (event) => {
	// 검색어
	const value = $searchTag.value.trim();

	// 자동완성 필터링
	matchDataList = value
		? dataList.filter((label) => label.includes(value))
		: [];


	switch (event.keyCode) {
		// UP KEY
		case 38:
			nowIndex = Math.max(nowIndex - 1, 0);
			break;

		// DOWN KEY
		case 40:
			nowIndex = Math.min(nowIndex + 1, matchDataList.length - 1);
			// document.querySelector("#searchTag").value = matchDataList[nowIndex];
			break;

		// ENTER KEY
		case 13:
			document.querySelector("#searchTag").value = matchDataList[nowIndex] || "";

			const key = document.getElementById("searchTag").value;

			const aa = document.getElementById("registTag>li label");


			if ((key != "") && (!registTagList.includes(key))) {

				if (registTagList.length >= 5) {
					alert("태그는 최대 5개까지만 추가 가능합니다.");
					document.querySelector("#searchTag").value = "";  // 연관검색창 닫기
					break;
				}

				registTagList.push(key);
				const $li = document.createElement("li");

				document.getElementById("relativeTagDiv").appendChild($li);
				const $button1 = document.createElement("label");
				const $button2 = document.createElement("button");

				const $img = document.createElement("img");
				$img.height = "15";
				$img.width = "15";
				$img.src = context + "/images/productregist/xbtn.png";

				$img.addEventListener("click", e => {  // 해당 이미지 클릭시

					for (let i = 0; i < registTagList.length; i++) { // 저장해놓은 키워드배열에서 값 삭제하고 개수 줄임
						if (registTagList[i] == e.target.parentElement.previousElementSibling.innerHTML) {
							registTagList.splice(i, 1);
							break;
						}
					}
					$(e.target).parent().parent().remove(); // li밑 label+button 밑 img까지 삭제
				});

				$button2.appendChild($img);
				$button1.innerHTML = key;

				$li.appendChild($button1);
				$li.appendChild($button2);

				var input1 = document.createElement('input');
				input1.setAttribute("type", "hidden");
				input1.setAttribute("name", "data1");
				input1.setAttribute("value", key);

				$li.appendChild(input1);
			}

			// 초기화
			nowIndex = 0;
			matchDataList.length = 0;
			document.querySelector("#searchTag").value = ""; // 연관검색창 닫기
			break;

		case 27: // esc 눌렀을때 입력창 초기화 및 관련검색어 창 닫기
			document.querySelector("#searchTag").value = "";
			matchDataList.length = 0;

		// 그외 다시 초기화
		default:
			nowIndex = 0;
			break;

	}

	// 리스트 보여주기
	showList(matchDataList, value, nowIndex);
};

const showList = (data, value, nowIndex) => {
	// 정규식으로 변환
	const regex = new RegExp(`(${value})`, "g");

	$autoComplete.innerHTML = data
		.map(
			(label, index) => `
      <div class='${nowIndex === index ? "active" : ""}'>
        ${label.replace(regex, "<label>$1</label>")}
      </div>
    `
		)
		.join("");
};


$autoComplete.addEventListener("click", e => {  // 관련검색어 클릭했을경우

	let clickAnswer = e.target.innerHTML.trim();

	for (let i = 0; i <= 10; i++) {
		clickAnswer = clickAnswer.replace("<label>", "");
		clickAnswer = clickAnswer.replace("</label>", "");
	}

	document.querySelector("#searchTag").value = clickAnswer;

	const key = document.getElementById("searchTag").value;

	const aa = document.getElementById("registTag>li label");

	if (registTagList.length >= 5) {
		alert("태그는 최대 5개까지만 추가 가능합니다.");
		document.querySelector("#searchTag").value = "";  // 연관검색창 닫기
		return;
	}

	if ((key != "") && (!registTagList.includes(key))) {
		registTagList.push(key);
		const $li = document.createElement("li");

		document.getElementById("relativeTagDiv").appendChild($li);
		const $button1 = document.createElement("label");
		const $button2 = document.createElement("button");
		/*const $button2 = $("<button>").css({"border":"none", "background-color":"transparent"});
		*/


		const $img = document.createElement("img");
		$img.height = "15";
		$img.width = "15";
		$img.src = context + "/images/productregist/xbtn.png";

		$button2.appendChild($img);

		$button1.innerHTML = key;

		$li.appendChild($button1);
		$li.appendChild($button2);

		
		var input1 = document.createElement('input');
		input1.setAttribute("type", "hidden");
		input1.setAttribute("name", "data1");
		input1.setAttribute("value", key);

		$li.appendChild(input1);
		

		$img.addEventListener("click", e => {  // 해당 이미지 클릭시
			$(e.target).parent().parent().remove(); // li밑 label+button 밑 img까지 삭제

			for (let i = 0; i < registTagList.length; i++) { // 저장해놓은 키워드배열에서 값 삭제하고 개수 줄임
				if (registTagList[i] == e.target.parentElement.previousElementSibling.innerHTML) {
					registTagList.splice(i, 1);
					break;
				}
			}
		});

		document.querySelector("#searchTag").dispatchEvent(new KeyboardEvent("keyup", { keyCode: 13 })); // 엔터 한번 발생
		$("#searchTag").val("");   // document.querySelector("#searchTag").value =""; 
		$("#searchTag").focus();   // document.getElementById("searchTag").focus(); 

	}
})


/*============>  #키 입력 못하도록 설정*/
$(document).ready(function() {
	$("#searchTag").keypress(function(e) {
		if (event.key == '#') {
			e.preventDefault();
			e.returnValue = false;
		}
	});
});
/*=============================*/


/* 폼 전송 작업*/

function productRegist(){
	$(".container").submit();
}



