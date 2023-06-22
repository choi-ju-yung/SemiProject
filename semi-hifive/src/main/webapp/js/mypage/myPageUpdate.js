const context = "http://localhost:9090/semi-hifive/";

// 취소 버튼
$(".resetUpdate").click(function() {
	location.reload();
});


// 프로필 사진 삭제
$(".profileImgDel").on("click", function() {
	$(".profileImg").attr("src", context + "/images/mypage/profileImg_default.png");
});


// 프로필 사진 변경
$(".profileImgUpdate").on("click", function() {
	let imgFile = $(".profileImgInput");
	imgFile.click();
});


// 닉네임 최대 8글자, 정규표현식 설정
$("#nicknameInput").keyup(e => { 
	const regNickName1 = /^[ㄱ-ㅎ가-힣a-zA-Z0-9]{0,8}$/;
	const nickName = $(e.target).val();
	const filteredText = nickName.replace(regNickName1, '');
	
	if (!regNickName1.test(nickName)) {
		alert("닉네임은 한글, 영어, 숫자만 사용 가능합니다.");
		$(e.target).val(filteredText);
	} else if (nickName.length > 7) {
		alert("닉네임은 최대 8글자로 입력해주세요.");
		$(e.target).val(nickName.substring(0, 8));
	}
});

// 내 상점 가기 버튼
$(".goToStoreBtn").mouseover(e => {
	$(".goToStoreIcon").css("color", "white");
	$(".goToStore").css("color", "white");
	$(".goToStoreBtn").css("background-color", "#20C997");
});

$(".goToStoreBtn").mouseleave(e => {
	$(".goToStoreIcon").css("color", "#20C997");
	$(".goToStore").css("color", "#20C997");
	$(".goToStoreBtn").css("background-color", "white");
});

// 닉네임 중복확인
$("#nicknameInput").keyup(e=>{
	if(e.target.value.length>1 && e.target.value.length<8){
		$.ajax({
			url: context + "/mypage/duplicateNickname.do",
			data:{"nickname":$(e.target).val()},
			success:function(data){
				console.log(data);
				let msg="", css={};
				if(data==='true'){
					msg = "사용가능한 닉네임입니다.";
					css = {color:"#20C997"};
				} else {
					msg = "이미 존재하는 닉네임입니다.";
					css = {color:"red"};
				}
				$(".nicknameDuplSpan").text(msg).css(css); 
			}
		});
	} else if(e.target.value.length<2){
		$(".nicknameDuplSpan").text("두글자 이상 입력해주세요."); 
	}
});

// 프로필이미지 변경 미리보기
$(".profileImgInput").change(e=>{
	// change했을 때 accept="image/*" 분기처리
	const reader = new FileReader();
	reader.onload = e =>{
		$(".profileImg").attr("src", e.target.result);
	}
	reader.readAsDataURL(e.target.files[0]);
});

// 비밀번호 변경하기
const fn_updatePassword=()=>{
	var width = '450';
    var height = '300';
	// 팝업창 가운데
	let left = Math.ceil(( window.screen.width - width )/2);
    let top = Math.ceil(( window.screen.height - height )/2); 
	
	open(context + "mypage/updatePassword.do", "_blank", 'width=' + width + ', height=' + height + ', left=' + left + ', top = ' + top);
}
 
// 유저정보 수정
const updateMember=()=>{
	/* const form = new FormData();
	const fileInput = $(".profileImgInput");
	$.each(fileInput[0].files, (i,f)=>{
		form.append("profileImg" + i,f);
	}); */
	
	$("#updateUserFrm").attr("action", context+"member/updateEndMember.do").submit();
} 

// 소개글 최대 글자수 설정
$("#myPageIntroduce").keyup(e=>{
	let introduce = $(e.target).val();
	console.log(introduce);
	
	// 글자수 카운트
	if(introduce.length==0 || introduce==''){
		$('.introduceSpan').text('0/50');
	} else {
		$('.introduceSpan').text(introduce.length + '/50');
	}
	
	// 글자수 제한(50자)
	if(introduce.length > 50){
		$(e.target).val(introduce.substring(0, 50));
		alert('상점소개글은 최대 50자까지 입력 가능합니다.');
	};
});