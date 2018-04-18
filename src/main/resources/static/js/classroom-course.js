$(document).ready(function(){
    $("li.sub-menu").click(function(){
        $("ol", this).toggle();
    });
});