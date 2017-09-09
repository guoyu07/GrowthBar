$(document).ready(function($) {
    $.ajax({
        var i = 1;
        url: "/GrowthBar_1/article/viewArticles",
        type: "POST",
        dataType: "json",
        data: ('pageNum', 'i');
        success: function(data)  {
            var str = "";
            $.each(data.articles, function(i, item) {
                str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
            });
            $("#artTitle").html(str)

        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
});

$(document).ready(function($) {
    $("#page1").click(function() {
        $.ajax({
            var i = 1;
            url: "/GrowthBar_1/article/viewArticles",
            type: "POST",
            dataType: "json",
            data: ('pageNum', 'i');
            success: function(data)  {
                var str = "";
                $.each(data.articles, function(i, item) {
                    str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
                });
                $("#artTitle").html(str)
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })
    });
});


$(document).ready(function($) {
    $("#page1").click(function() {
        $.ajax({
            var i = 2;
            url: "/GrowthBar_1/article/viewArticles",
            type: "POST",
            dataType: "json",
            data: ('pageNum', '2');
            success: function(data)  {
                var str = "";
                $.each(data.articles, function(i, item) {
                    str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
                });
                $("#artTitle").html(str)
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })
    });
});


$(document).ready(function($) {
    $("#page1").click(function() {
        $.ajax({
            var i = 3;
            url: "/GrowthBar_1/article/viewArticles",
            type: "POST",
            dataType: "json",
            data: ('pageNum', '3');
            success: function(data)  {
                var str = "";
                $.each(data.articles, function(i, item) {
                    str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
                });
                $("#artTitle").html(str)
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })
    });
});

$(document).ready(function($) {
    $("#page1").click(function() {
        $.ajax({
            var i = 4;
            url: "/GrowthBar_1/article/viewArticles",
            type: "POST",
            dataType: "json",
            data: ('pageNum', '4');
            success: function(data)  {
                var str = "";
                $.each(data.articles, function(i, item) {
                    str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
                });
                $("#artTitle").html(str)
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })
    });
});

$(document).ready(function($) {
    $("#page1").click(function() {
        $.ajax({
            var i = 5;
            url: "/GrowthBar_1/article/viewArticles",
            type: "POST",
            dataType: "json",
            data: ('pageNum', '5');
            success: function(data)  {
                var str = "";
                $.each(data.articles, function(i, item) {
                    str += ('<li class="list-group-item"><a href="#">' + item.art_Name + '</a></li>')
                });
                $("#artTitle").html(str)

            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        })
    });
});

$(document).ready(function() {
    $.ajax({
        url: '',
        type: 'POST',
        dataType: 'json',
        // data: {param1: 'value1'},
        success: function(data) {
            var artTitle = "";
            var artArthour = "";
            var artTime = "";
            var artContent = "";
            $.each(data.articles, function(i, item) {
                artTitle += (item.art_name);
                artArthour += (item.user_id);
                artTime += (item.post_time);
                artContent += (item.art_content);
            });
            $("#artTitle").html(artTitle);
            $("#artTime").html(artArthour + '  ' + artTime);
            $("#artContent").html(artContent);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })

})