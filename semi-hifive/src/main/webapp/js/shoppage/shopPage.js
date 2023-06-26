$(".radio-input input").on("change", function () {
  // const input = $(".radio-input input").val();
  const input = $("input[name='value-radio']:checked").val();
  if (input == "value-1") {
    $("#shopProductContainer").css("display", "block");
    $("#reviewContainer").css("display", "none");
  } else if (input == "value-2") {
    $("#shopProductContainer").css("display", "none");
    $("#reviewContainer").css("display", "block");
  }
});