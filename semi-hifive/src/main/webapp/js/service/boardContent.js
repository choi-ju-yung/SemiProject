//대댓글 토글
$(document).on("click",".recommentBtn",function(e){
	$(".recomment").find(".commentWrite").remove();
	const text=$("<textarea>").attr({
		"name":"boardComment",
		"class":"boardComment",
		"cols":"120",
		"rows":"5",
		"placeholder":"댓글을 작성하세요."
	});
	const btn=$("<button>").attr("class","commentBtn").text("댓글 작성");
	const commentfk=$(e.target).next(".commentPK").val();
	const input=$("<input>").attr({
		"type":"hidden",
		"value":commentfk,
		"class":"commentFK"
	});
	const div=$(e.target).parent().next().next(".recomment");
	console.log(div);
	div.prepend($("<div>").attr("class","commentWrite").append(text).append(btn).append(input));
});
