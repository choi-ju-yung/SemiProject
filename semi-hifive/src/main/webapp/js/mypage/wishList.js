// 찜목록 판매상태 뱃지 컬러 수정
$(document).ready(function() {
  $(".statusBtn").each(function() {
    var status = $(this).text();
    var div = $(this).closest(".statusBtnDiv");

    if (status == '판매중') {
      div.css("background-color", "#20C997");
    } else if (status == '예약중') {
      div.css("background-color", "#FFD800");
    } else {
      div.css("background-color", "#cccccc");
    }
  });
});