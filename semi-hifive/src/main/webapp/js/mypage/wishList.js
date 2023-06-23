const context = "http://localhost:9090/semi-hifive/";
const userId = sessionStorage.getItem("loginId");

// 찜목록 판매상태 뱃지 컬러 수정
$(document).ready(function() {
	$(".statusBtn").each(function() {
		var status = $(this).text();
		var div = $(this).closest(".statusBtnDiv");

		if (status == '판매중') {
			div.css("background-color", "#20C997");
		} else if (status == '예약중') {
			div.css("background-color", "#FFD800");
		} else {
			div.css("background-color", "#cccccc");
		}
	});
});

// 찜추가, 찜삭제
$(".wishCheck").click(e => {
	let isChecked = $(e.target).prop('checked');
	let productId = $(e.target).attr("id");
	/* 뭘해도 1이 되는데 현재 모든 하트를 첫번째 상품의 하트로 인식*/
	if (!isChecked) {
		// 하트가 꺼질 경우(=찜 취소) -> 새로고침 시 상품 사라짐
		$.ajax({
			url: context + "/myPage/wishListDel.do", 
			data: {"userId": userId,
					"productId": productId},
			success: (data)=> {
				console.log("삭제 완료");
			},
			error: (data)=>{
				alert("삭제 실패");
				// 어떻게 안빠지지?
			}
		});
	} else {
		// 취소한거 다시 찜하기
		$.ajax({
			url: context + "/mypage/wishListInsert.do", 
			data: {"userId": userId,
					"productId": productId},
			success: (data)=> {
				console.log("추가 완료");
			},
			error: (data)=>{
				alert("삭제 실패");
			}
		});
	}
});