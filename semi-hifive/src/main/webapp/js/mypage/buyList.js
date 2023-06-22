const open = () => {
	document.querySelector(".modal").classList.remove("hidden");
}

const close = () => {
	document.querySelector(".modal").classList.add("hidden");
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

});

// 후기메세지 최대 글자수 설정
$(".reviewMsg").keyup(e => {
	let reviewMsg = $(".reviewMsg").val();
	if (reviewMsg.length > 20) {
		alert("후기메세지는 최대 20자로 입력해주세요.");
		$(e.target).val(reviewMsg.substring(0, 20));
	}
});