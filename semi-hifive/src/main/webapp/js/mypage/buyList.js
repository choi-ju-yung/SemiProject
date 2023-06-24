const context = "http://localhost:9090/semi-hifive/";
const userId = sessionStorage.getItem("loginId");

// 모달창 열기, 닫기
const open = () => {
	document.querySelector(".modal").classList.remove("hidden");
}

const close = () => {
	document.querySelector(".modal").classList.add("hidden");
	$(".btnSpanDiv input[type=radio]").prop("checked", false);
	$(".reviewMsg").val("");
}


const openBtn = document.querySelectorAll(".openBtn");
openBtn.forEach(e => {
	e.addEventListener("click", open);
})

const closeBtn = document.querySelectorAll(".closeBtn");
closeBtn.forEach(e => {
	e.addEventListener("click", close);
})

const bg = document.querySelectorAll(".bg");
bg.forEach(e => {
	e.addEventListener("click", close);
})


// 거래후기 유무 확인
$(".reviewBtn").click(e => {
	let productId = $(e.target)[0].id;
	
	$.ajax({
		url: context + "mypage/reviewList.do",
		type: "POST",
		data: {
			"userId": userId,
			"productId": productId
		},
		success: (data) => {
			if (data == "이미 등록된 거래후기가 있습니다.") {
					alert(data);
					$(".modal").addClass("hidden");
			} else {

			}
		}
	});
})

// 모달창 후기보내기(확인버튼)
$(".okBtn").click(e => {
	// 상품코드
	let productId = $(e.target)[0].id;

	// 좋아요, 보통, 싫어요 선택(super-happy, neutra1, super-sad)
	let rating = document.getElementsByName('rating');  // 이름값(js)
	let radioValue;

	for (var i = 0; i < rating.length; i++) {
		if (rating[i].checked) {
			radioValue = rating[i].value;
			break;
		}
	}

	// 후기 메세지
	let reviewMsg = $(".reviewMsg").val();

	// 서블릿으로 보내서 거래 테이블 저장하기 + 유저 온도 업데이트
	// 상품코드 말고 거래 아이디를 보내야되나?
	$.ajax({
		url: context + "mypage/reviewWrite.do",
		type: "POST",
		data: {
			"userId": userId,
			"productId": productId,
			"radioValue": radioValue,
			"reviewMsg": reviewMsg
		},
		success: (data) => {
			alert(data);
			/*$(".reviewBtn").css({
				"color": "#ccc",
				"border": "2px solid #ccc"
			});
			$(".reviewBtn").hover.css({
				"color": "#ccc",
				"border": "2px solid #ccc",
				"background-color": "white"
			});*/
			$(".modal").addClass("hidden");
		}
	});

});

// 후기메세지 최대 글자수 설정
$(".reviewMsg").keyup(e => {
	let reviewMsg = $(".reviewMsg").val();
	if (reviewMsg.length > 30) {
		alert("후기메세지는 최대 30자로 입력해주세요.");
		$(e.target).val(reviewMsg.substring(0, 30));
	}
});