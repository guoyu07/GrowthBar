$(document).ready(function($) {
    $.ajax({
        url: '',
        type: "POST",
        dataType: "json",
        success: function(data) {
            var str = "";
            $.each(data.postbars, function(i, item) {
                str += ('<li class="list-group-item"><a class="pageGetName" href="#" id="getName' + i + '">' + item.postbar_title + '<p id="getId' + i + '" hidden>' + item.post_id + '</p></a></li>');
            });
            $("#anoTitle").html(str)
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    });
});
$(function($) {
    $(".pageAll").click(function() {
        var page = $(this).html();
        $.ajax({
            url: '',
            type: "POST",
            dataType: "json",
            data: {
                pageNum: page
            },
            success: function(data) {
                var str = "";
                $.each(data.postbars, function(i, item) {
                    str += ('<li class="list-group-item"><a class="pageGetName" href="#" id="getName' + i + '">' + item.postbar_title + '<p id="getId' + i + '" hidden>' + item.postbar_id + '</p></a></li>');
                });
                $("#anoTitle").html(str)
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        });
    });
})
$(document).on("click", ".pageGetName", function() {
    var textContent = $(this).clone();
    textContent.find(':nth-child(n)').remove()
    var topicTitle = textContent.html()
    var ano_id = $(this).children('p').html()
    $.ajax({
        url: '',
        type: 'POST',
        dataType: 'json',
        data: {
            post_id: ano_id,
        },
        success: function(data) {
            $("#remove1").remove()
            $("#remove2").remove()
            $("#remove3").remove()
            var title = ('<div class="col-md-12 col-sm-12 text-center"><h2>' + topicTitle + '</h2></div>')
            var str2 = ('</ul></div></div></div><div class="col-sm-2 col-md-2"></div></div>')
            var str = ('<div class="row Czb_margin_padding"><div class="col-sm-2 col-md-2"></div><div class="col-sm-8 col-md-8" ><div class="thumbnail"><div class="caption"><ul class="list-group" >')
            var content = ''
            $.each(data.postbar_comment, function(i, item) {
                content += ('<li class="list-group-item">' + item.comment_content + '<h2 class="text-right"><small>匿名用户'+item.comment_time+'</small></h2><p hidden>'+item.user_id+'</p>' + '</li>' + '</li>')
            });
            var str4 = ('<div id="remove4"><div class="col-sm-2 col-xs-2"></div><div class="col-sm-8 col-xs-8">添加评论<textarea class="form-control commentContent" rows="10"></textarea></div><div class="col-sm-2 col-xs-2"></div></div>');
            var button=('<div class="col-sm-offset-6 col-sm-6 Czb_Ano_blank" id="remove5"><button  class="btn btn-default " id="clickButton">提交</button></div>');
            $('#navBlank').html(title);
            $("#testBlank").html(str + content + str2 + str4 + button);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
})