// 검색기능 (ex구글)
/*function searchData() {
  let keyword = document.getElementsByClassName("search")[0].value;
  location.href = "https://www.google.co.kr/search?q=" + keyword;
  console.log(keyword);
}*/
// /검색기능/

//검색창
$(document).on("click", ".searchBar", function () {
  searchOn();
});

$(document).on("click", "section", function () {
  searchOff();
});

function searchOn() {
  $(".searchBar,.searchDetail,.search").css({"background-color": "white"});
  $(".searchpage").css("display", "block");
}

function searchOff() {
  $(".searchBar,.searchDetail,.search").css({"background-color": "#eeeeee"});
  $(".searchpage").css("display", "none");
}
// /검색창/
// 상단메뉴바
$(document).on("mouseenter",'#menuList a', function () {
  const id = $(this).attr("id");
  $(".sideMenu")
    .not($("#sideMenu-" + id))
    .css("display", "none");
  $("#menuList a")
    .not($(this))
    .css({"background-color": "white", color: "#afafaf"});
  $(this).css({"background-color": "#20c997", color: "white"});
  $("#sideMenu-" + id).css("display", "block");
});
$("#category0").mouseleave(function () {
  $("#menuList a").css({"background-color": "white", color: "#afafaf"});
});
$(document).on("moustleave",".sideMenu", function () {
  $(".sideMenu").css("display", "none");
  $("#menuList a").css({"background-color": "white", color: "#afafaf"});
});
$("section").mouseenter(function () {
  $(".sideMenu").css("display", "none");
  $("#menuList a").css({"background-color": "white", color: "#afafaf"});
});
$("section").click(function (e) {
  if ($("#menuIcon").is(":checked")) {
    $("#menuIcon").prop("checked", false);
  }
});

/*$(document).on("mouseenter", '#menuList a', function () {
  const id = $(this).attr("id");
  $(".sideMenu")
    .not($("#sideMenu-" + id))
    .css("display", "none");
  $("#menuList a")
    .not($(this))
    .css({"background-color": "white", color: "#afafaf"});
  $(this).css({"background-color": "#20c997", color: "white"});
  $("#sideMenu-" + id).css("display", "block");
});

$(document).on("mouseleave", '#menuList', function () {
  $(".sideMenu").css("display", "none");
  $("#menuList a").css({"background-color": "white", color: "#afafaf"});
});*/

// /상단메뉴바/

/*// 카테고리 사이드바

$(".collapse").on("show.bs.collapse", function () {
  var target = $("[href='#" + $(this).prop("id") + "']");
  target.removeClass("fa-plus-square");
  target.addClass("fa-minus-square");
});
$(".collapse").on("shown.bs.collapse", function () {
  var target = $("[href='#" + $(this).prop("id") + "']");
  target.removeClass("fa-plus-square");
  target.addClass("fa-minus-square");
});
$(".collapse").on("hide.bs.collapse", function () {
  var target = $("[href='#" + $(this).prop("id") + "']");
  target.removeClass("fa-minus-square");
  target.addClass("fa-plus-square");
});
$(".collapse").on("hidden.bs.collapse", function () {
  var target = $("[href='#" + $(this).prop("id") + "']");
  target.removeClass("fa-minus-square");
  target.addClass("fa-plus-square");
});
//카테고리 사이드바*/
