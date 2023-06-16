

function checkSelectAll() {
	// 전체 체크박스
	const checkboxes // 전체 체크박스의 개수를 세기위해 만듬
		= document.querySelectorAll('input[name="agree"]');

	// 선택된 체크박스
	const checked
		= document.querySelectorAll('input[name="agree"]:checked');
	// select all 체크박스
	const selectAll
		= document.querySelector('input[name="selectall"]');

	if (checkboxes.length === checked.length) {  //  전체 체크개수와 현재 선택된 체크개수가 같으면 ->전체체크 상자에 체크해주고
		selectAll.checked = true;                   // 하나라도 박스에 체크가 빠지면, 전체체크 상자에 체크 표시 x
	} else {
		selectAll.checked = false;
	}

}

function selectAll(selectAll) {  // 이함수 호출시 1,2,3,4 체크부분들 다 체크표시로 설정
	const checkboxes
		= document.getElementsByName('agree');

	checkboxes.forEach((checkbox) => {
		checkbox.checked = selectAll.checked
	})
}

const fn_viewDetail1 = () => {
	window.open("/semi-hifive/views/enrollMemberPopup/popup1.jsp", "팝업창1", 'width=600, height=600 left=650 top=250'); // left, top -> 원하는 위치에 팝업창이 뜨도록 설정
}

const fn_viewDetail2 = () => {
	window.open("/semi-hifive/views/enrollMemberPopup/popup2.jsp", "팝업창2", 'width=600, height=600 left=650 top=250'); // left, top -> 원하는 위치에 팝업창이 뜨도록 설정
}

const fn_viewDetail3 = () => {
	window.open("/semi-hifive/views/enrollMemberPopup/popup3.jsp", "팝업창3", 'width=600, height=600 left=650 top=250'); // left, top -> 원하는 위치에 팝업창이 뜨도록 설정
}

const fn_viewDetail4 = () => {
	window.open("/semi-hifive/views/enrollMemberPopup/popup4.jsp", "팝업창4", 'width=600, height=600 left=650 top=250'); // left, top -> 원하는 위치에 팝업창이 뜨도록 설정
}

