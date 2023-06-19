//댓글창
$(() => {

	const text=[];
	const cmt=[];
	$("div.cmtContainer").children(".cmt").each((i,v)=>{
		text.push($(v).text());
	});
	console.log(text);
	
	//for(var i=0; i<text.legnth;i++){
	//	cmt.push(text[i].substr(-5));
	//}
	
	text.forEach(v=>{
		cmt.push(v.substring(-5));
	})
	console.log(cmt);

});

function contentInput(e) {
	const length = $(e.target).val().length;
	if (length > 100) {
		alert("100글자이하로 작성하세요!");
		$(e.target).val($(e.target).val().substring(0, 100));
	}
	$(e.target)
		.next()
		.text(`${$(e.target).val().length}/100`);
		console.log(length);
	if (length == 0) {
		$("#textContainer span").css("color", "#afafaf");
		$("#cmtBtn").css({ color: "#afafaf", "background-color": "#eeeeee" });
	} else if (length >= 1) {
		$("#textContainer span").css("color", "#20c997");
		$("#cmtBtn").css({ color: "white", "background-color": "#20c997" });
	}
}

$(document).ready(function() {	
$("#textContainer").find("textarea").keyup();
	const price = $("#productPrice")
		.html()
		.toString()
		.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#productPrice").html(price);
});
//*댓글창*//
$(document).on("keyup",function(e){
	$("#textContainer").on("keyup","textarea",function(e){
		$(this).css("height","auto");
		$(this).height(this.scrollHeight);
	});
	
	$("#cmtText").keyup(contentInput).keydown(contentInput);
})

const cmtForm = $("#cmtForm").clone();
const cmtForm2 = $("#cmtForm").clone();
/*답글기능*/
$(".writeCmt").click(e => {

	const commentRef = $(e.target).val();
	cmtForm.find("#cmtText").val("");
	cmtForm.find("input[name=level]").val("2");
	cmtForm.find("input[name=commentRef]").val(commentRef);
	//$(e.target).parents("div.cmtContainer").css("margin-bottom", "-10px");

	if ($(e.target).next(cmtForm2).length) {
		cmtForm2.remove();
		cmtForm.insertAfter($(e.target).parents("div.cmtContainer"));
	}
	//$(e.target).off("click");
})

$(".changeCmt").click(e => {
	const text=$(e.target).parents("div.cmtContainer").children(".cmt").text()
	var leng=text.length;
	const cmt=text.substr(0,leng-5);
	
	cmtForm2.find("#cmtText").val(text);
	
	const commentNo = $(e.target).parents("div").children("input[name=commentNo]").val();
	cmtForm2.attr("action", getContextPath() + "/changeComment?commentNo=" + commentNo);
	//$(e.target).parents("div.cmtContainer").css("margin-bottom", "-10px")
	cmtForm2.find("#cmtBtn").html("수정");
	$(e.target).parents("div.cmtContainer").find("#cmtNone").css("display","inline-block");
	
	if ($(e.target).next(cmtForm).length) {
		cmtForm.remove();
		cmtForm2.insertAfter($(e.target).parents("div.cmtContainer"));
	}
	//$(e.target).off("click");
})

$(".reWriteCmt").click(e => {

	const commentRef = $(e.target).val();
	cmtForm.find("#cmtText").val("");
	cmtForm.find("input[name=level]").val("2");
	cmtForm.find("input[name=commentRef]").val(commentRef);
	//$(e.target).parents("div.cmtContainer").css("margin-bottom", "-10px");

	if ($(e.target).next(cmtForm2).length) {
		cmtForm2.remove();
		cmtForm.insertAfter($(e.target).parents("div.reComment"));
	}
	//$(e.target).off("click");
})

$(".reChangeCmt").click(e => {
	const text=$(e.target).parents("div.reComment").children(".cmt").text();
	
	cmtForm2.find("#cmtText").val(text);

	const commentNo = $(e.target).parents("div").children("input[name=commentNo]").val();
	cmtForm2.attr("action", getContextPath() + "/changeComment?commentNo=" + commentNo);
	//$(e.target).parents("div.cmtContainer").css("margin-bottom", "-10px")
	cmtForm2.find("#cmtBtn").html("수정");
	//$(e.target).parents("div.cmtContainer").find("#cmtNone").css("display","inline-block");
	
	if ($(e.target).next(cmtForm).length) {
		cmtForm.remove();
		cmtForm2.insertAfter($(e.target).parents("div.reComment"));
	}
	//$(e.target).off("click");
})

$(function(){
    $('.deleteCmt').click(e=>{
		const commentNo = $(e.target).parents("div").children("input[name=commentNo]").val();
		const productId = $("input[name=productId]").val();
        if(!confirm('댓글을 삭제 하시겠습니까?')){
            
        }else{
			location.href=getContextPath()+"/deleteComment?commentNo="+commentNo+"&&productId="+productId;
		}
    });
});

function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};
