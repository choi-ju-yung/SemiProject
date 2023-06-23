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
	let isChecked = $('.wishCheck').prop('checked');
	console.log(isChecked);
	console.log($(".wishCheck").attr("id"));
	/* 뭘해도 1이 되는데 현재 모든 하트를 첫번째 상품의 하트로 인식*/
	if (isChecked) {
		// 하트가 켜져있는 경우(=찜o)

		// 
		/*$.ajax({
			url: '/wishlist/' + itemId, 
			type: 'DELETE',
			success: function(response) {
				console.log('삭제 요청이 성공했습니다.');
				// 여기서 추가적인 처리를 수행할 수 있습니다.
			},
			error: function(xhr, status, error) {
				console.log('삭제 요청이 실패했습니다: ' + error);
				// 여기서 에러 처리를 수행할 수 있습니다.
			}
		});*/
	} else {
		// 하트가 꺼져있는 경우(=찜x)
		isChecked = true;
	}
});