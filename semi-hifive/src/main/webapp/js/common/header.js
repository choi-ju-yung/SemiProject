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
	localStorage.clear(textArray);
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

//자동완성
var locList = [
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

var keywordList = [
	"#아이폰",
	"#노트북",
	"#스마트폰",
	"#갤럭시",
	"#가방",
];

$(document).ready(function() {
	// input필드에 자동완성 기능을 걸어준다
	$("#searchInput").autocomplete({
		source: locList,
		focus: function(event, ui) {
			return false;
		},
		select: function(event, ui) { },
		minLength: 1,
		delay: 100,
		autoFocus: true,
	});

});

/*$("#searchForm input").autocomplete({
  source: function (request, response) {
	$.ajax({
	  url: stat_path + "/locList",
	  type: "POST",
	  dataType: "json",
	  data: {value: request.term},
	  success: function (data) {
		response(
		  $.map(data, function (item) {
			return {
			  label: item.AREA_NAME,
			  value: item.AREA_NAME,
			  idx: item.IDX,
			};
		  })
		);
	  },
	});
  },
  focus: function (event, ui) {
	return false;
  },
  select: function (event, ui) {
	console.log(ui.item.idx);
  },
  delay: 100,
  autoFocus: true,
});*/

// /검색창/

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
});
$("#category0").mouseleave(function() {
	$("#menuList a").css({ "background-color": "white", color: "#afafaf" });
});
$(".sideMenu").mouseleave(function() {
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
$(".headercategorybtn").click(function(e) {
	$.ajax({
		url: "<%=request.getContextPath()%>/ajax/headercategory.do",
		success: function(data) {
			console.log(data);
			$("#menuList>ul>li").html(data);
		},
	});
});

// /상단메뉴바/

// 카테고리 사이드바

$(".collapse").on("show.bs.collapse", function() {
	var target = $("[href='#" + $(this).prop("id") + "']");
	target.removeClass("fa-plus-square");
	target.addClass("fa-minus-square");
});
$(".collapse").on("shown.bs.collapse", function() {
	var target = $("[href='#" + $(this).prop("id") + "']");
	target.removeClass("fa-plus-square");
	target.addClass("fa-minus-square");
});
$(".collapse").on("hide.bs.collapse", function() {
	var target = $("[href='#" + $(this).prop("id") + "']");
	target.removeClass("fa-minus-square");
	target.addClass("fa-plus-square");
});
$(".collapse").on("hidden.bs.collapse", function() {
	var target = $("[href='#" + $(this).prop("id") + "']");
	target.removeClass("fa-minus-square");
	target.addClass("fa-plus-square");
});
//카테고리 사이드바
