//게시판 카테고리 선택하면 발생하는 이벤트
$(".titleSelect").change(e => {
	const title = $(e.target).val();
	if (title == "notice") {
		$(".QASelect").css("display", "none");
	} else {
		$(".QASelect").css("display", "inline");
	}
});

//전송 전 제목 체크
const titleCheck = e => {
	const title = $("#baordTitle").val();
	if (title.length == 0) {
		$("#titleCheck").text("제목은 비어있을 수 없습니다.").css({
			"color": "red",
			"fontWeight": "bolder",
			"marginTop": "5px"
		});
		return false;
	}
}

//제목 글자 수 체크
$("#baordTitle").keyup(e => {
	const num = $(e.target).val().length;
	if (num >= 40) {
		alert("제목은 40자 이하로 작성하세요.");
		focus(e.target);
	}
	$("#titleTextNum").text(num + "/40");
});