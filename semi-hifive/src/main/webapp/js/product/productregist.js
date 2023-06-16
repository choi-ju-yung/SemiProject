// function getImageFiles(e) {
//     const files = e.currentTarget.files;
//     console.log(typeof files, files);
// }


// 사진 불러오기 작업 

let prouductImgCnt = 0; 

function getImageFiles(e) {
    const uploadFiles = [];
    const files = e.currentTarget.files;
    const imagePreview = document.querySelector('.image-preview');

    if (prouductImgCnt >= 10) {
        alert('이미지는 최대 10개 까지 업로드가 가능합니다.');
        return;
    }

    // 파일 타입 검사
    [...files].forEach(file => {  // 이미지 파일외 다른 파일 업로드시 (문구 + 이미지 적용 x)
        if (!file.type.match("image/.*")) {
            alert('이미지 파일만 업로드가 가능합니다.');
            return
        }

        // 파일 갯수 검사
        if ([...files].length < 11) { // 한번에 10개까지 이미지 등록가능

            const reader = new FileReader();
            reader.onload = (e) => {
                const preview = createElement(e, file);
                imagePreview.appendChild(preview);  
            };
			
            uploadFiles.push(file); // 이미지 파일이 7개 미만이면 배열에 파일추가
            prouductImgCnt++;  // 이미지 추가시 개수 증가
            $(".imgCount").text("("+prouductImgCnt+"/10"+")");
            console.log(prouductImgCnt);
            reader.readAsDataURL(file);  // 업로드 파일 읽어오기 (이문구 없으면 이미지 추가되지않음)
        }

		
		
/*		        // 파일 갯수 검사
        if ((prouductImgCnt+[...files].length) < 11) { // 한번에 10개까지 이미지 등록가능

            const reader = new FileReader();
            reader.onload = (e) => {
                const preview = createElement(e, file);
                imagePreview.appendChild(preview);  
            };

            
            // uploadFiles.push(file); // 이미지 파일이 7개 미만이면 배열에 파일추가
            prouductImgCnt++;  // 이미지 추가시 개수 증가
            $(".imgCount").text("("+prouductImgCnt+"/10"+")");
            console.log(prouductImgCnt);
            reader.readAsDataURL(file);  // 업로드 파일 읽어오기 (이문구 없으면 이미지 추가되지않음)
        }
        else{
			alert('이미지는 한번에 10개까지 등록 가능합니다.');
			return
		}*/
		
		
    });
}


// 태그 만들어주는 함수
function createElement(e, file) {
    const li = document.createElement('li');    // li 태그 만들기
    const img = document.createElement('img');  // img 태그 만들기
    img.setAttribute('src', e.target.result); // 만든 img 태그에 경로 속성 값 넣어줌
    img.setAttribute('data-file', file.name); // 만들 ing 태그에 파일 이름 속성 값 넣어줌
    
    
   	img.addEventListener("click",e=>{  // 해당 이미지 클릭시
		prouductImgCnt--; // 이미지 삭제시 개수 감소
		$(e.target).parent().remove(); // li안의 img까지 삭제
		$(".imgCount").text("("+prouductImgCnt+"/10"+")");
	});
	
    li.appendChild(img); // 이미지가 있는 li 태그 완성하여 li 리턴

    return li;
}

const realUpload = document.querySelector('.real-upload');
const upload = document.querySelector('.upload');

upload.addEventListener('click', () => realUpload.click()); // 이미지등록 클록시 input file타입 호출
realUpload.addEventListener('change', getImageFiles); // file타입에서 값 변경시키면 getImageFiles() 함수 호출






// ==== 가격 입력했을 때, 숫자만입력되고, 3자리수마다 ,로 구분해주는 작업
function comma(str) {
  str = String(str);
  return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, "$1,");
}

function uncomma(str) {
  str = String(str);
  return str.replace(/[^\d]+/g, "");
}

function inputNumberFormat(obj) {
  obj.value = comma(uncomma(obj.value));
}
//=====================================================


// ==== 제목 글자수 세주는 작업=====
$(".inputTitle").keyup(e => { // 해당 텍스트부분을 입력할 때
    $(".countTitle").text($(e.target).val().length+"/40");
    const length = $(e.target).val().length;

    if (length > 40) {
        alert("40글자 이하로 작성하세요");
        $(e.target).val($(e.target).val().substring(0, 40));
    }
    $(".countTitle").text($(e.target).val().length + "/40");
})




// -------------------------------------------------------------------------------------------------------------------
// 카테고리 선택하는 작업

// var groups = $("#aca_coo ").options.length;
var groups = document.querySelectorAll(".mainCate option").length

// var groups = document.frm1.aca_coo.options.length

var group = new Array(groups)

for (i = 0; i < groups; i++) {
    group[i] = new Array()
}

group[0][0] = new Option("카테고리를 선택");
group[1][0] = new Option("카테고리를 선택");
group[1][1] = new Option("전체");
group[1][2] = new Option("상희");
group[1][3] = new Option("하의");
group[2][0] = new Option("카테고리를 선택");
group[2][1] = new Option("전체");
group[2][2] = new Option("신발");
group[2][3] = new Option("모자");
group[2][4] = new Option("가방");
group[2][5] = new Option("기타잡화");
group[3][0] = new Option("카테고리를 선택");
group[3][1] = new Option("전체");
group[3][2] = new Option("TV");
group[3][3] = new Option("세탁기");
group[3][4] = new Option("냉장고");
group[3][5] = new Option("주방가전");
group[4][0] = new Option("카테고리를 선택");
group[4][1] = new Option("전체");
group[4][2] = new Option("데스크탑");
group[4][3] = new Option("노트북");
group[4][4] = new Option("기타 주변기기");
group[5][0] = new Option("카테고리를 선택");
group[5][1] = new Option("전체");
group[5][2] = new Option("가구");
group[5][3] = new Option("인테리어");
group[6][0] = new Option("카테고리를 선택");
group[6][1] = new Option("전체");
group[6][2] = new Option("주방용품");
group[6][3] = new Option("식품");
group[6][4] = new Option("생활잡화");
group[7][0] = new Option("카테고리를 선택");
group[7][1] = new Option("전체");
group[7][2] = new Option("골프");
group[7][3] = new Option("등산용품");
group[7][4] = new Option("캠핑용품");
group[8][0] = new Option("카테고리를 선택");
group[8][1] = new Option("전체");
group[8][2] = new Option("교육용품");
group[8][3] = new Option("소설/만화책");
group[8][4] = new Option("문구/사무용품");
group[8][5] = new Option("기타잡화");
group[9][0] = new Option("카테고리를 선택");
group[9][1] = new Option("전체");
group[9][2] = new Option("중고차");
group[9][3] = new Option("오토바이");
group[10][0] = new Option("카테고리를 선택");
group[10][1] = new Option("무료나눔");
group[11][0] = new Option("카테고리를 선택");
group[11][1] = new Option("기타");

// var temp = document.frm1.aca_2ndcoo
var temp = document.querySelector(".middleCate")

function redirect(x) {
    for (m = temp.options.length - 1; m > 0; m--)temp.options[m] = null;
    for (i = 0; i < group[x].length; i++) {
        temp.options[i] = new Option(group[x][i].value)
    }
}

redirect(0);
/* document.querySelector(".mainCate").addEventListener("focus",e=>{
	$(e.target).find("option").first().css("display","none");
	*/
 document.querySelector(".mainCate").addEventListener("focus",e=>{
	$(e.target).find("option").first().css("display","none");	
	
});
// -------------------------------------------------------------------------------------------------------------------

// 지역 카테고리 선택하는 작업
var placeGroups = document.querySelectorAll(".mainPlace option").length

// var groups = document.frm1.aca_coo.options.length
console.log(placeGroups);
var placeGroup = new Array(placeGroups)

for (i = 0; i < placeGroups; i++) {
    placeGroup[i] = new Array()
}

placeGroup[0][0] = new Option("카테고리를 선택");
placeGroup[1][0] = new Option("카테고리를 선택");
placeGroup[1][1] = new Option("전체");
placeGroup[1][2] = new Option("상희");
placeGroup[1][3] = new Option("하의");
placeGroup[2][0] = new Option("카테고리를 선택");
placeGroup[2][1] = new Option("전체");
placeGroup[2][2] = new Option("신발");
placeGroup[2][3] = new Option("모자");
placeGroup[2][4] = new Option("가방");
placeGroup[2][5] = new Option("기타잡화");
placeGroup[3][0] = new Option("카테고리를 선택");
placeGroup[3][1] = new Option("전체");
placeGroup[3][2] = new Option("TV");
placeGroup[3][3] = new Option("세탁기");
placeGroup[3][4] = new Option("냉장고");
placeGroup[3][5] = new Option("주방가전");
placeGroup[4][0] = new Option("카테고리를 선택");
placeGroup[4][1] = new Option("전체");
placeGroup[4][2] = new Option("데스크탑");
placeGroup[4][3] = new Option("노트북");
placeGroup[4][4] = new Option("기타 주변기기");
placeGroup[5][0] = new Option("카테고리를 선택");
placeGroup[5][1] = new Option("전체");
placeGroup[5][2] = new Option("가구");
placeGroup[5][3] = new Option("인테리어");
placeGroup[6][0] = new Option("카테고리를 선택");
placeGroup[6][1] = new Option("전체");
placeGroup[6][2] = new Option("주방용품");
placeGroup[6][3] = new Option("식품");
placeGroup[6][4] = new Option("생활잡화");
placeGroup[7][0] = new Option("카테고리를 선택");
placeGroup[7][1] = new Option("전체");
placeGroup[7][2] = new Option("골프");
placeGroup[7][3] = new Option("등산용품");
placeGroup[7][4] = new Option("캠핑용품");
placeGroup[8][0] = new Option("카테고리를 선택");
placeGroup[8][1] = new Option("전체");
placeGroup[8][2] = new Option("교육용품");
placeGroup[8][3] = new Option("소설/만화책");
placeGroup[8][4] = new Option("문구/사무용품");
placeGroup[8][5] = new Option("기타잡화");
placeGroup[9][0] = new Option("카테고리를 선택");
placeGroup[9][1] = new Option("전체");
placeGroup[9][2] = new Option("중고차");
placeGroup[9][3] = new Option("오토바이");
placeGroup[10][0] = new Option("카테고리를 선택");
placeGroup[10][1] = new Option("무료나눔");
placeGroup[11][0] = new Option("카테고리를 선택");
placeGroup[11][1] = new Option("기타");


var placeTemp = document.querySelector(".middlePlace")

function placeRedirect(x) {
    for (m = placeTemp.options.length - 1; m > 0; m--)placeTemp.options[m] = null;
    for (i = 0; i < placeGroup[x].length; i++) {
        placeTemp.options[i] = new Option(placeGroup[x][i].value)
    }
	
}


	placeRedirect(0);
// -------------------------------------------------------------------------------------------------------------------





// ==== 설명 글자수 세주는 작업=====
$(".explan").keyup(e => { // 해당 텍스트부분을 입력할 때
    $(".countExpaln").text($(e.target).val().length+"/40");
    const length = $(e.target).val().length;

    if (length > 2000) {
        alert("2000글자 이하로 작성하세요");
        $(e.target).val($(e.target).val().substring(0, 2000));
    }
    $(".countExpaln").text($(e.target).val().length + "/2000");
})