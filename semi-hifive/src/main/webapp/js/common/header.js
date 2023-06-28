// 검색기능 (ex구글)
/*function searchData() {
  let keyword = document.getElementsByClassName("search")[0].value;
  location.href = "https://www.google.co.kr/search?q=" + keyword;
  console.log(keyword);
}*/

//절대경로 함수
function getContextPath() {
	var hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
};

// /검색기능/

//검색창
$(document).on("click", ".searchBar", function() {
	searchOn();
});

$(document).on("click", "section", function() {
	searchOff();
});

function searchOn() {
	$(".searchBar,.searchDetail *,.ui-autocomplete").css({
		"background-color": "white",
	});
	$(".searchpage").css("display", "block");
	if (!$.trim($("#searchInput").val()) == "") {
		$(".ui-autocomplete").css("display", "block");
	} else {

	}
	$("#recentList").after($(".ui-autocomplete"));
	if ($("#recentList li").length == 0) {
		$("#recentList").html("<p id='notRecent'>최근검색어 내역이 없습니다.</p>");
	} else {
		$("#notRecent").remove();
	}
}

function searchOff() {
	$(".searchBar,.searchDetail *").css({ "background-color": "#eeeeee" });
	$(".searchpage,.ui-autocomplete").css("display", "none");
}

$("#searchInput").on("keyup", function(e) {
	if ($(e.target).val().length) {
		$("#recentHead").text("연관검색어");
		$("#recentList").css("display", "none");
		$("#allDeleteBtn").css("display", "none");
		$(".ui-autocomplete").css({
			display: "block",
			width: "600px",
			border: "0px",
			position: "relative",
			top: "20px",
			left: "0px",
		});
		$("#resetBtn").css("display", "block");
		if ($(e.target).val().substr(0, 1) == "#") {
			$(e.target).css("color", "#20c997")
			$("#recentHead").text("키워드검색");
		} else {
			$(e.target).css("color", "black")
		}
	} else {
		$("#recentHead").text("최근검색어");
		$("#recentList").css("display", "block");
		$("#allDeleteBtn").css("display", "block");
		$(".ui-autocomplete").css("display", "none");
		$("#resetBtn").css("display", "none");
	}
});

/*$(document).on("click", "#resetBtn", e => {
	$(e.target).css("display", "none");
})*/

$(document).on("keydown", "#searchInput", e => {
	if (e.which == 13) {
		content = $(e.target).val();
		location.href = getContextPath() + "/search?content=" + content;
	}
})

$(document).on("click", ".recentTagText", e => {
	content = $(e.target).text().trim();
	location.href = getContextPath() + "/search?content=" + content;
})

$(document).on("click", "#submitBtn", e => {
	content = $("#searchInput").val()
	location.href = getContextPath() + "/search?content=" + content;
})

const searchForm = document.querySelector("#searchForm");
const searchInput = searchForm.querySelector("input");
const recentList = document.querySelector("#recentList");
const allDelete = document.querySelector(".allDelete");
const txt = document.querySelector(".txt");
const loginId = sessionStorage.getItem("loginId");
let textArray = new Array();

function saveRecentTag() {
	//item을 localStorage에 저장합니다.
	typeof (Storage) !== "undefined" &&
		localStorage.setItem(loginId, JSON.stringify(textArray));
}

function allDeleteRecentTag() {
	//전체 item을 삭제
	localStorage.removeItem(loginId);
	console.log(localStorage);
	recentList.innerHTML = "<p id='notRecent'>최근검색어 내역이 없습니다.</p>";
	saveRecentTag();
}

function deleteRecentTag(e) {
	//각각의 item을 삭제
	const li = e.target.parentElement.parentElement;
	li.remove();
	textArray = textArray.filter((rc) => rc.id !== parseInt(li.id));
	textArray.length === 0 &&
		(recentList.innerHTML =
			"<p id='notRecent'>최근검색어 내역이 없습니다.</p>");
	saveRecentTag();
}

function printRecentTag(newRecentTag) {
	//화면에 뿌림
	const { id, text } = newRecentTag;
	const item = document.createElement("li");
	const span = document.createElement("span");
	span.className = "recentTagText"
	const button = document.createElement("button");
	item.id = id;
	span.innerText = text;
	button.innerHTML = "<ion-icon name='close-circle-outline'></ion-icon>";
	button.addEventListener("click", deleteRecentTag);
	allDelete.addEventListener("click", allDeleteRecentTag);
	item.appendChild(span);
	item.appendChild(button);
	recentList.appendChild(item);
	newRecentTag !== null && allDelete.classList.remove("off");
}

function handleToDoSubmit(event) {
	//form 전송
	event.preventDefault();
	const newRecentTagItem = searchInput.value;
	searchInput.value = "";
	const newRecentTagObj = {
		id: Date.now(),
		text: newRecentTagItem,
	};
	textArray.push(newRecentTagObj);
	printRecentTag(newRecentTagObj);
	saveRecentTag();
}

searchForm.addEventListener("submit", handleToDoSubmit);

const savedRecentTags = JSON.parse(localStorage.getItem(loginId));
if (savedRecentTags !== null) {
	textArray = savedRecentTags; //전에 있던 items들을 계속 가지도 있다록 합니다.
	savedRecentTags.forEach(printRecentTag);
}


var dataList2 = [
	"영등포본동",
	"영등포동",
	"여의동",
	"당산1동",
	"당산2동",
	"도림동",
	"문래동",
	"양평1동",
	"양평2동",
	"신길1동",
	"신길2동",
	"신길3동",
	"신길4동",
	"신길5동",
	"신길6동",
	"신길7동",
	"대림1동",
	"대림2동",
	"#아이폰",
	"#노트북",
	"#스마트폰",
	"#갤럭시",
	"#가방",
];


const CHO_HANGUL = [
  'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ',
  'ㄹ', 'ㅁ', 'ㅂ','ㅃ', 'ㅅ',
  'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ',
  'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
];


const HANGUL_START_CHARCODE = "가".charCodeAt();


const CHO_PERIOD = Math.floor("까".charCodeAt() - "가".charCodeAt());
const JUNG_PERIOD = Math.floor("개".charCodeAt() - "가".charCodeAt());


function combine(cho, jung, jong) {
  return String.fromCharCode(
    HANGUL_START_CHARCODE + cho * CHO_PERIOD + jung * JUNG_PERIOD + jong
  );
}


function makeRegexByCho(search = "") {
  const regex = CHO_HANGUL.reduce(
    (acc, cho, index) =>
      acc.replace(
        new RegExp(cho, "g"),
        `[${combine(index, 0, 0)}-${combine(index + 1, 0, -1)}]`
      ),
    search
  );

  return new RegExp(`(${regex})`, "g");
}

function includeByCho(search, targetWord) {
  return makeRegexByCho(search).test(targetWord);
}



const searchBar=document.querySelector("#searchInput");
const autoSearch=document.querySelector(".autoSearch");
let nowIndex2=0;

	
	
searchBar.onkeyup=(event)=>{
	
const value=searchBar.value.trim()
	const matchData=value
	?dataList2.filter((label)=>includeByCho(value,label))
	:[];
	
	switch(event.keyCode){

    case 38:
      nowIndex2 = Math.max(nowIndex2 - 1, 0);
      break;

    case 40:
      nowIndex2 = Math.min(nowIndex2 + 1, matchData.length - 1);

      break;

    case 13:
      document.querySelector("#search").value = matchData[nowIndex2] || "";
      nowIndex2 = 0;
      matchData.length = 0;
      break;

    default:
      nowIndex2 = 0;
      break;
	}

	//console.log(matchData[nowIndex2])
	
	showList2(matchData, value, nowIndex2);
	
}

const showList2 = (data, value, nowIndex2) => {
  const regex = makeRegexByCho(value);
 
  autoSearch.innerHTML = data
    .map(
      (label, index) => `
       <div class='${nowIndex2 === index ? "active" : ""}'>
        ${label.replace(regex, "<mark>$1</mark>")}
      </div>
    `
    )
    .join("");
    
};


$(".autoSearch").on("click",function(e){
	const text=($(e.target).text()).trim()		
	console.log(text)
	location.href = getContextPath() + "/search?content=" + text;
		    
})

/*$("#searchInput").on("keydown",function(e){
	const text=$(".autoSearch>div.active").text().trim()
	console.log(text)
	console.log($(e.target).val())
	$(e.target).val(text)
})*/

// 상단메뉴바
$("#menuList a").mouseenter(function() {
	const id = $(this).attr("id");
	$(".sideMenu")
		.not($("#sideMenu-" + id))
		.css("display", "none");
	$("#menuList a")
		.not($(this))
		.css({ "background-color": "white", color: "#afafaf" });
	console.log(this);
	$(this).css({ "background-color": "#20c997", color: "white" });
	$("#sideMenu-" + id).css("display", "block");

})
$(document).on("mouseenter", '#menuList a', function() {
	const id = $(this).attr("id");
	$(".sideMenu")
		.not($("#sideMenu-" + id))
		.css("display", "none");
	$("#menuList a")
		.not($(this))
		.css({ "background-color": "white", color: "#afafaf" });
	$(this).css({ "background-color": "#20c997", color: "white" });
	$("#sideMenu-" + id).css("display", "block");
});
$("#category0").mouseleave(function() {
	$("#menuList a").css({ "background-color": "white", color: "#afafaf" });
});
$(".sideMenu").mouseleave(function() {
	$(".sideMenu").css("display", "none");
	$("#menuList a").css({ "background-color": "white", color: "#afafaf" });
})
$(document).on("moustleave", ".sideMenu", function() {
	$(".sideMenu").css("display", "none");
	$("#menuList a").css({ "background-color": "white", color: "#afafaf" });
});

$("section").mouseenter(function() {
	$(".sideMenu").css("display", "none");
	$("#menuList a").css({ "background-color": "white", color: "#afafaf" });
});

$("section").click(function(e) {
	if ($("#menuIcon").is(":checked")) {
		$("#menuIcon").prop("checked", false);
	}
});

// 상단 메뉴바 카테고리 클릭시 카테고리 출력 함수
/*$(".headercategorybtn").click(function(e) {
	$.ajax({
		url: "/ajax/headercategory.do",
		success: function(data) {
			console.log(data);
			$("#menuList>ul>li").html(data);
		}
	})
});*/

$(document).ready(function() {
	printSearch()
})

var printsearch="";

//setInterval( printSearch() , 1000)

function printSearch() {
	$.ajax({
		url: getContextPath() + "/printsearch",
		success: function(data) {
			
			$.each(data,function(index,item){
				printsearch+="<li class='allCycle'>"+(index+1)+". "+item.searchKeyword+"</li>"
			})
				$("#rankAllSearch").append(printsearch);
				
			let count=1;
			let count2=1;
			$("#rankSearch").html("<div id=rankCycle>"+"1. "+data[0].searchKeyword+"</div>");
			
			setInterval(function(){
				$("#rankSearch").html("<div id='rankCycle'>"+((count++%10)+1)+". "+data[count2++%10].searchKeyword+"</div>")			
			},5000);
		
		}
	})
}

$("#printSearch button").on("click" ,function(e){
	$("#printSearch").css("display","none")	
	$("#rankAllSearch").css("display","block")	
})

$("#rankAllSearch button").on("click",function(e){
	$("#printSearch").css("display","block")	
	$("#rankAllSearch").css("display","none")	
})
