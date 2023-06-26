const userId = sessionStorage.getItem("loginId");
const context = "http://localhost:9090/semi-hifive/";

$(".closeBtn").click(e => {
	window.close();
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
	console.log(productId);
	console.log(buyerId);
	console.log(userId);
	
	let form = $("<form>").attr("method", "post").attr("action", context + "mypage/sellListBuyerChoiceEnd.do");
	let input = $("<input>").attr("type", "hidden").attr("name", "productId").val(productId);
	let input2 = $("<input>").attr("type", "hidden").attr("name", "userId").val(userId);
	let input3 = $("<input>").attr("type", "hidden").attr("name", "buyerId").val(buyerId);
	form.append(input);
	form.append(input2);
	form.append(input3);
	form.appendTo("body").submit();
	form.submit();
})