$("#stepButton").click(function() {
    $($('#stepContainer')[$(this).index("#stepButton")]).toggle('fast');
});