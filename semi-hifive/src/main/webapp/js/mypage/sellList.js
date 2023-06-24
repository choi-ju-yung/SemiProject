const context = "http://localhost:9090/semi-hifive/";
// sessionStorage 사용해서 userId 추출하기(header.jsp)
const userId = sessionStorage.getItem("loginId");

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

// 상품 삭제하기
$(".openBtn").click(e => {
	let productId = $(e.target)[0].id;
	console.log(productId);
	$(".modalDelBtn").click(e => {
		let form = $("<form>").attr("method", "post").attr("action", context + "mypage/deleteProduct.do");
		let input = $("<input>").attr("type", "hidden").attr("name", "productId").val(productId);
		let input2 = $("<input>").attr("type", "hidden").attr("name", "userId").val(userId);
		form.append(input);
		form.append(input2);
		form.appendTo("body").submit();
		form.submit();
	});
})

// 판매중, 예약중, 판매완료 데이터 변경 ajax
$(".selectStatus").change(e => {

	const selectValue = $(e.target).val();
	console.log(selectValue);
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

	if (selectValue === 'soldOut') {
		// 새 창 열기
		var width = '450';
		var height = '400';
		// 팝업창 가운데
		let left = Math.ceil((window.screen.width - width) / 2);
		let top = Math.ceil((window.screen.height - height) / 2);

		window.open(context + "mypage/buyerIdChoice.do?productId=" + productId, "_blank", 'width=' + width + ', height=' + height + ', left=' + left + ', top = ' + top);
	}

	$.ajax({
		url: context + "mypage/ajaxSelect.do",
		data: {
			"selectValue": selectValue,
			"productId": productId,
			"userId": userId
		},
		success: (data) => {
			$(e.target).css({
				border: "2px solid " + color,
				color: color
			});

			$("#allBtn").text("전체 " + data.total);
			$("#sellBtn").text("판매중 " + data.countStatusSell);
			$("#resBtn").text("예약중 " + data.countStatusRes);
			$("#solBtn").text("판매완료 " + data.countStatusSol);

			console.log("판매상태 변경 성공");
		},
		error: function() {
			alert("판매상태 변경 실패");
		}
	});
})
