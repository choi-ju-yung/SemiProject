// function getImageFiles(e) {
//     const files = e.currentTarget.files;
//     console.log(typeof files, files);
// }


const context = "http://localhost:9090/semi-hifive";

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

// 거래지역 선택 (api 코드)
function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }



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


// -------------------------------------------------------------------------------------------------------------------


// 상품태그 검색 관련 js
const dataList = ["빨간색", "파란색", "노란색", "검정색", "빨강","빨대","빨지마","빨빨이","빨래","빨적","빨망","빨리와","빨각모","빨공","빨명","빨사"];
let registTagList=[];

const $searchTag = document.querySelector("#searchTag");
const $autoComplete = document.querySelector(".autocomplete");

let nowIndex = 0;
let matchDataList;
$searchTag.onkeyup = (event) => {
  // 검색어
  const value = $searchTag.value.trim();

  // 자동완성 필터링
  matchDataList = value
    ? dataList.filter((label) => label.includes(value))
    : [];


  switch (event.keyCode) {
    // UP KEY
    case 38:
      nowIndex = Math.max(nowIndex - 1, 0);
      break;

    // DOWN KEY
    case 40:
      nowIndex = Math.min(nowIndex + 1, matchDataList.length - 1);
      // document.querySelector("#searchTag").value = matchDataList[nowIndex];
      break;

    // ENTER KEY
    case 13:
      document.querySelector("#searchTag").value = matchDataList[nowIndex] || "";

      const key = document.getElementById("searchTag").value;
      
      const aa = document.getElementById("registTag>li label");
      

      if((key != "") && (!registTagList.includes(key))){

        if(registTagList.length >= 5){
        alert("태그는 최대 5개까지만 추가 가능합니다.");
        document.querySelector("#searchTag").value ="";  // 연관검색창 닫기
        break;
      }

        registTagList.push(key);
        const $li = document.createElement("li");
        
        document.getElementById("relativeTagDiv").appendChild($li);
        const $button1 = document.createElement("label");
        const $button2 = document.createElement("button");

        const $img = document.createElement("img");
        $img.height="15";
        $img.width="15";
        $img.src=context+"/images/productregist/xbtn.png";

        $img.addEventListener("click",e=>{  // 해당 이미지 클릭시
          
          for(let i = 0; i < registTagList.length; i++) { // 저장해놓은 키워드배열에서 값 삭제하고 개수 줄임
                if(registTagList[i] == e.target.parentElement.previousElementSibling.innerHTML)  {
                  registTagList.splice(i, 1);
                  break;
                  }
                }
           $(e.target).parent().parent().remove(); // li밑 label+button 밑 img까지 삭제
          });

        $button2.appendChild($img);
        $button1.innerHTML=key;

        $li.appendChild($button1);
        $li.appendChild($button2);

        var input1 = document.createElement('input');  
        input1.setAttribute("type", "hidden");
        input1.setAttribute("name", "data1");
        input1.setAttribute("value", key);
        
        $li.appendChild(input1);
      }     
      
      // 초기화
      nowIndex = 0;
      matchDataList.length = 0;
      document.querySelector("#searchTag").value =""; // 연관검색창 닫기
      break;
    
    case 27: // esc 눌렀을때 입력창 초기화 및 관련검색어 창 닫기
      document.querySelector("#searchTag").value =""; 
      matchDataList.length = 0;

    // 그외 다시 초기화
    default:
      nowIndex = 0;
      break;

  }

  // 리스트 보여주기
  showList(matchDataList, value, nowIndex);
};

const showList = (data, value, nowIndex) => {
  // 정규식으로 변환
  const regex = new RegExp(`(${value})`, "g");
  
  $autoComplete.innerHTML = data
    .map(
      (label, index) => `
      <div class='${nowIndex === index ? "active" : ""}'>
        ${label.replace(regex, "<label>$1</label>")}
      </div>
    `
    )
    .join("");
};


$autoComplete.addEventListener("click",e=>{  // 관련검색어 클릭했을경우

  let clickAnswer = e.target.innerHTML.trim();
  
  for(let i=0; i<=10; i++){
    clickAnswer = clickAnswer.replace("<label>","");
    clickAnswer = clickAnswer.replace("</label>","");
  }

  document.querySelector("#searchTag").value = clickAnswer;

   const key = document.getElementById("searchTag").value;
      
      const aa = document.getElementById("registTag>li label");
      
      if(registTagList.length >= 5){
        alert("태그는 최대 5개까지만 추가 가능합니다.");
        document.querySelector("#searchTag").value ="";  // 연관검색창 닫기
        return;
      }

      if((key != "") && (!registTagList.includes(key))){
        registTagList.push(key);
        const $li = document.createElement("li");
        
        document.getElementById("relativeTagDiv").appendChild($li);
        const $button1 = document.createElement("label");
        const $button2 = document.createElement("button");
        /*const $button2 = $("<button>").css({"border":"none", "background-color":"transparent"});
		*/
		

        const $img = document.createElement("img");
        $img.height="15";
        $img.width="15";
        $img.src=context+"/images/productregist/xbtn.png";

        $button2.appendChild($img);


        $button1.innerHTML=key;

        $li.appendChild($button1);
        $li.appendChild($button2);
  
  		
  	
        $img.addEventListener("click",e=>{  // 해당 이미지 클릭시
          $(e.target).parent().parent().remove(); // li밑 label+button 밑 img까지 삭제

          for(let i = 0; i < registTagList.length; i++) { // 저장해놓은 키워드배열에서 값 삭제하고 개수 줄임
                if(registTagList[i] == e.target.parentElement.previousElementSibling.innerHTML)  {
                  registTagList.splice(i, 1);
                  break;
                  }
              }
       });

       

      document.querySelector("#searchTag").dispatchEvent(new KeyboardEvent("keyup",{keyCode: 13})); // 엔터 한번 발생
      $("#searchTag").val("");   // document.querySelector("#searchTag").value =""; 
      $("#searchTag").focus();   // document.getElementById("searchTag").focus(); 

  }})


/*$("#searchTag").on("focus",
    function(){
      $(".autocomplete").css({
      "display":"block"
    });
});*/

/*$("#searchTag").on("blur",
    function(){
      $(".autocomplete").css({
      "display":"none"
    });
});*/

 
    // 특수문자 정규식 변수(공백 미포함)
    var replaceChar = /[#]/gi;
 
    // 완성형 아닌 한글 정규식
    var replaceNotFullKorean = /[ㄱ-ㅎㅏ-ㅣ]/gi;
    
    $(document).ready(function(){
        
        $("#inputName").on("focusout", function() {
            var x = $(this).val();
            if (x.length > 0) {
                if (x.match(replaceChar) || x.match(replaceNotFullKorean)) {
                    x = x.replace(replaceChar, "").replace(replaceNotFullKorean, "");
                }
                $(this).val(x);
            }
            }).on("keyup", function() {
                $(this).val($(this).val().replace(replaceChar, ""));

       });

    });       
    



