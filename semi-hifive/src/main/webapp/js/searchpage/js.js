//$(document).ready(() => {
//    $('.searchbartext').keypress((e) => {
//      if (e.which === 13) { // Enter 키를 눌렀을 때
  
//        const searchText = $('.searchbartext').val().trim(); // 입력한 텍스트 가져오기
  
//       if (searchText !== '') { // 입력한 텍스트가 비어있지 않은 경우
//          const $newTag = $(`
//            <a href="" class="recentsearchtag">
//              <div class="recentsearchtagtext">${searchText}</div>
//            
//              <div class="recentsearchbtn">
//                <button>
//                  <svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512">
//                    <path d="M448 256c0-106-86-192-192-192S64 150 64 256s86 192 192 192 192-86 192-192z" fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="32"/>
//                    <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M320 320L192 192M192 320l128-128"/>
//                  </svg>
//                </button>
//              </div>
//            </a>
//          `);
  
//          $('.recentsearchmeun').prepend($newTag); // 새로운 태그 추가
  
//          $('.recentsearchmeun p').hide(); // "최근검색어가 없습니다" 문구 숨기기
//        }
//        $('.searchbartext').val(''); // 입력 필드 비우기
//      }
//    });
//});

// $(document).ready(function() {
//   $(".searchbartext").keypress(function(e) {
//     if (e.which === 13) { // Check if Enter key is pressed
//       var searchText = $(this).val(); // Get the search text

//       // Hide the "최근 검색어 내역이 없습니다." message
//       $(".recentsearchmeun p").hide();

//       // Add the search text to recent search tags
//       var recentSearchTag = '<a href="" class="recentsearchtag">' +
//                               '<div class="recentsearchtagtext">' + searchText + '</div>' +
//                               '<div class="recentsearchbtn">' +
//                                 '<button>' +
//                                   '<svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512">' +
//                                     '<path d="M448 256c0-106-86-192-192-192S64 150 64 256s86 192 192 192 192-86 192-192z" fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="32"/>' +
//                                     '<path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M320 320L192 192M192 320l128-128"/>' +
//                                   '</svg>' +
//                                 '</button>' +
//                               '</div>' +
//                             '</a>';

//       $(".recentsearchmeun").append(recentSearchTag);

//       // Clear the search text
//       $(this).val("");
//     }
//   });

//   $(document).on("click", ".recentsearchbtn button", function(event) {
//     $(event.target).closest(".recentsearchtag").remove();
//     event.preventDefault();//버블링; a태그 막기
//   });
// });

//input 태그에 비워주는 버튼 
$(() => {
  $(".removesearch").click(() => $(".searchbartext").val(""));
});

//
$(document).ready(function() {
  $(".searchbartext").keyup(function(e) {
    if (e.which === 13) { // Check if Enter key is pressed
      var searchText = $(this).val(); // Get the search text

      // Hide the "최근 검색어 내역이 없습니다." message
      $(".recentsearchmeun p").hide();

      // Add the search text to recent search tags within the ".recentsearchmeun" area
      var recentSearchTag = $('<a href="" class="recentsearchtag">' +
                              '<div class="recentsearchtagtext">' + searchText + '</div>' +
                              '<div class="recentsearchbtn">' +
                                '<button>' +
                                  '<svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512">' +
                                    '<path d="M448 256c0-106-86-192-192-192S64 150 64 256s86 192 192 192 192-86 192-192z" fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="32"/>' +
                                    '<path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M320 320L192 192M192 320l128-128"/>' +
                                  '</svg>' +
                                '</button>' +
                              '</div>' +
                            '</a>');

      var recentSearchMenu = $(".recentsearchmeun");

      var maxRecentSearchTags = 8; 
      if (recentSearchMenu.children().length >= maxRecentSearchTags) {
        recentSearchMenu.children().last().remove();
      }

      recentSearchMenu.prepend(recentSearchTag);

   
      $(this).val("");
    }
  });

  $(document).on("click", ".recentsearchbtn button", function(event) {
    $(event.target).closest(".recentsearchtag").remove();
    event.preventDefault(); // Prevent the default behavior of the link
  });
});

// 
 $(document).ready(function () {
  // 자동 완성 기능을 구현할 데이터 배열
  var searchData = ["검색어1", "검색어2", "검색어3", "검색어4", "검색어5", "브랜드", "상품명", "아이폰", "나이키"];

  // input 요소에 자동 완성 기능을 추가
  $('.searchbartext').autocomplete({
      source: searchData, // 자동 완성될 데이터 소스
      focus : function(event, ui) { // 방향키로 자동완성단어 선택 가능하게 만들어줌	
         			return false;
   		},
       minLength: 1,// 최소 글자수
       delay: 100,	//autocomplete 딜레이 시간(ms)
     //disabled: true, //자동완성 기능 끄기
       autoFocus : true,
 });
});

//
