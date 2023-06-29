function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};

function userId(){
	const userId = sessionStorage.getItem("loginId");
	return userId;
};

const productId = opener.document.getElementById("productId").value;
console.log(productId);

$(".closeBtn").click(e => {
	alert("거래자를 선택해주세요.");
	opener.$(".selectStatus").val("reservation").css({
			"border": "2px solid #FFD800",
			"color": "#FFD800"
		})
		console.log(productId);
	//window.close();
	
});

let buyerId;
$(".commentList").click(e => {
	buyerId = $(e.target)[0].id;
	$(".commentList").css({
		"background-color": "transparent"
	})
	$(e.target).css({
		"background-color": "#eee"
	})
})

$(".okBtn").click(e => {
	let productId = $(e.target)[0].id;
	
	$.ajax({
		url: getContextPath() + "/mypage/ajaxSelect.do",
		data: {
			"selectValue": "soldOut",
			"productId": productId,
			"userId": userId()
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
	
	
	let form = $("<form>").attr("method", "post").attr("action", getContextPath() + "mypage/sellListBuyerChoiceEnd.do");
	let input = $("<input>").attr("type", "hidden").attr("name", "productId").val(productId);
	let input2 = $("<input>").attr("type", "hidden").attr("name", "userId").val(userId());
	let input3 = $("<input>").attr("type", "hidden").attr("name", "buyerId").val(buyerId);
	form.append(input);
	form.append(input2);
	form.append(input3);
	form.appendTo("body").submit();
	form.submit();
})