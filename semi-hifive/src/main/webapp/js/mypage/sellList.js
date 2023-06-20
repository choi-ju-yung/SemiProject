const context = "http://localhost:9090/semi-hifive/";

/*$(function() {
	$('.select').change(function(e) {
		var $this = $(this);
		var c = $this.find('option:selected').data('color');
		$this.css({ 'color': c, 'border-color': c });
	});
	$('.ex-select').each(function() {
		var $this = $(this);
		$this.trigger('change');
		$this.find('option').each(function() {
			$(this).css('color', $(this).data('color'));
		});
	});
});*/

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


// 판매중, 예약중, 판매완료 데이터 변경 ajax
$(".selectStatus").change(e => {

	const selectValue = $(e.target).val();

	/* i = 인덱스, v = $(e.target).children() 배열 */
	/* option 3개 순회 */
	/* 클라이언트가 선택한 value가 option value와 같다면 */
	/* 옵션 id값 가져옴 */
	/*$(e.target).children().each((i,v)=>{
		if(selectValue==v.value){
			productId=v.id
		}
	});*/

	let productId = $(e.target).children()[0].id;
	let color = $(e.target).find('option:selected').data('color');	

	$.ajax({
		url: context + "mypage/ajaxSelect.do",
		data: {
			"selectValue": selectValue,
			"productId": productId
		},
		success: (data) => {
			$(e.target).css({
				border: "2px solid " + color,
				color: color
			})
			console.log("판매상태 변경 성공");

		},
		error: function() {
			console.log("판매상태 변경 실패");
		}
	});
})


// 판매상태별 상품 나타내기 ajax
$("#allBtn").click(e=>{
	// 현재 페이지 URL 가져오기
	var currentURL = window.location.href;

	// URL에서 쿼리스트링 파라미터 값 추출하기
	var queryString = currentURL.split('?')[1];
	var userId = queryString.split('=')[1];
	console.log(userId);
	
	$.ajax({
		url: context + "mypage/allBtn.do",
		data: {
			"userId": userId,
			"status": "전체"
		},
		success: (data) => {
			$(e.target).attr({
				class:"nowButton"
			})
		}
	});
});

$("#sellBtn").click(e=>{
	
});

$("#resBtn").click(e=>{
	
});

$("#solBtn").click(e=>{
	
});
