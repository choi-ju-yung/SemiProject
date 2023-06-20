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

// 모달 삭제
$(".modalDelBtn").click(e => {
	let productId = $(e.target)[0].id;

	let form = $("<form>").attr("method", "post").attr("action", context + "mypage/deleteProduct.do");
	let input = $("<input>").attr("type", "hidden").attr("name", "productId").val(productId);
	let input2 = $("<input>").attr("type", "hidden").attr("name", "userId").val(userId);
	form.append(input);
	form.append(input2);
	form.appendTo("body").submit();
	form.submit();
});

// 판매중, 예약중, 판매완료 데이터 변경 ajax
$(".selectStatus").change(e => {

	const selectValue = $(e.target).val();
	console.log(userId);
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


// 판매상태별 상품 나타내기 ajax
$("#allBtn").click(e => {
	$.ajax({
		url: context + "mypage/sellBtn.do",
		data: {
			"userId": userId,
			"status": "전체"
		},
		success: (data) => {
			$(e.target).attr({
				class: "nowButton"
			})
		}
	});
});

$("#sellBtn").click(e => {
	$.ajax({
		url: context + "mypage/sellBtn.do",
		data: {
			"userId": userId,
			"status": "판매중"
		},
		success: (data) => {
			$(e.target).attr({
				class: "nowButton"
			})
			$("#allBtn").attr("class", "");
			console.log(data);
			/*for(let i = 0; i < data.length; i++){
				$(".categoryA").text(data.subcategoryName);
			}*/
		}
	});
});

$("#resBtn").click(e => {
	$.ajax({
		url: context + "mypage/sellBtn.do",
		data: {
			"userId": userId,
			"status": "예약중"
		},
		success: (data) => {
			$(e.target).attr({
				class: "nowButton"
			})
			$("#allBtn").attr("class", "");
		}
	});
});

$("#solBtn").click(e => {
	$.ajax({
		url: context + "mypage/sellBtn.do",
		data: {
			"userId": userId,
			"status": "판매완료"
		},
		success: (data) => {
			$(e.target).attr({
				class: "nowButton"
			})
			$("#allBtn").attr("class", "");
		}
	});
});
