//댓글창
$(() => {
	$("#cmtText").keyup(contentInput).keydown(contentInput);
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
	if (length == 0) {
		$("#textContainer span").css("color", "#afafaf");
		$("#cmtBtn").css({ color: "#afafaf", "background-color": "#eeeeee" });
	} else if (length >= 1) {
		$("#textContainer span").css("color", "#20c997");
		$("#cmtBtn").css({ color: "white", "background-color": "#20c997" });
	}
}

$(document).ready(function() {
	$("#textContainer").on("keyup", "textarea", function(e) {
		$(this).css("height", "auto");
		$(this).height(this.scrollHeight);
	});
	$("#textContainer").find("textarea").keyup();

	const price = $("#productPrice")
		.html()
		.toString()
		.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	$("#productPrice").html(price);
});
//*댓글창*//


/*답글기능*/
$(".writeCmt").click(e=>{
	const cmtForm=$("#cmtForm").clone();
	const commentRef=$(e.target).val();
	cmtForm.find("#cmtText").val("");
	cmtForm.find("input[name=level]").val("2");
	cmtForm.find("input[name=commentRef]").val(commentRef);
	$("#reTagName").text(tagName);
	console.log($("#reTagName").text())
	$(e.target).parents("div").css("margin-bottom","-10px");
	cmtForm.insertAfter($(e.target).parents("div"));
	$(e.target).off("click");
})

$(".changeCmt").click(e=>{
	const cmtForm2=$("#cmtForm").clone();
	cmtForm2.find("#cmtText").val("");
	const commentNo=$(e.target).parents("div").children("input[name=commentNo]").val();
	cmtForm2.attr("action",getContextPath()+"/changeComment?commentNo="+commentNo);
	$(e.target).parents("div").css("margin-bottom","-10px");
	cmtForm2.insertAfter($(e.target).parents("div"));	
	$(e.target).off("click");
})

function getContextPath() {
  var hostIndex = location.href.indexOf( location.host ) + location.host.length;
  return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};
