$("#asideButton").click(function () {
    $("aside").toggle("slow");
    if($('aside').css('display') == 'none')
    {
        $("#mainContainer").css("marginLeft", "0px")
    }
    else {
        $("#mainContainer").css("marginLeft", "210px")
    }
});
$("#courseAside").click(function () {
    $("#courseAsideSub").toggle("slow");
});
$("#trackAside").click(function () {
    $("#trackAsideSub").toggle("slow");
});
$("#mentorAside").click(function () {
    $("#mentorAsideSub").toggle("slow");
});
$("#blogAside").click(function () {
    $("#blogAsideSub").toggle("slow");
});
$("#languageAside").click(function () {
    $("#languageAsideSub").toggle("slow");
});
$("#categoryAside").click(function () {
    $("#categoryAsideSub").toggle("slow");
});