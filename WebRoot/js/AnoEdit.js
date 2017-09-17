$(document).on("click", "#submitTopic", function() {
    $.ajax({
        url: '/User/check',
        type: 'POST',
        dataType: 'json',
        success: function(data) {
            if (data.status == true) {
                var anoTopic = $("#anoTopic").val()
                var anoContent = $("#anoContent").val()
                $.ajax({
                    url: '/postbar/add',
                    type: 'post',
                    dataType: 'json',
                    data: {
                        postTitle: anoTopic,
                        postContent: anoContent,
                    },
                    success: function(data) {
                        if (data.status == true) {
                            window.location.href = 'Ano_index.html';
                        } else {
                            alert("发帖失败，请重新发帖。");
                        }
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert(XMLHttpRequest.responseText);
                        alert(XMLHttpRequest.readyState);
                        alert(textStatus);
                    },
                })
            } else {
                alert("请登录");
            }
        },
    })
})
$(document).ready(function() {
    $.ajax({
        url: '/User/check',
        type: 'POST',
        dataType: 'json',
        success: function(data) {
            if (data.status == true) {
                var userAccount = data.userAccount;
                $("#getUserID").html('<li><a>' + userAccount + '</a></li>');
                $("#getUserID").toggle();
            } else {
                $("#getUserID").toggle();
            }
        },
    })
    $.ajax({
        url: '/postbar/viewAll',
        type: 'post',
        dataType: 'json',
        success: function(data) {
            var str = "";
            $.each(data.postList, function(i, item) {
                str += ('<li class="list-group-item"><a class="pageGetName" href="#" id="getName' + i + '">' + item.post_title + '<p id="getId' + i + '" hidden>' + item.post_id + '</p></a></li>');
            });
            $("#addAnoTopic").html(str);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    })
})

$(document).on("click", ".pageGetName", function() {
    var textContent = $(this).clone();
    textContent.find(':nth-child(n)').remove();
    var topicTitle = textContent.html();
    var ano_id = $(this).children('p').html();
    $.ajax({
        url: '/postbar-comment/viewCommentByPost',
        type: 'POST',
        dataType: 'json',
        data: {
            postId: ano_id,
        },
        success: function(data) {
            $("#remove1").remove()
            $("#remove2").remove()
            $("#remove3").remove()
            var title = ('<div class="col-md-12 col-sm-12 text-center"><h2>' + topicTitle + '</h2></div>')
            var str2 = ('</ul></div></div></div><div class="col-sm-2 col-md-2"></div></div>')
            var str = ('<div class="row Czb_margin_padding"><div class="col-sm-2 col-md-2"></div><div class="col-sm-8 col-md-8" ><div class="thumbnail"><div class="caption"><ul class="list-group" >')
            var content = ''
            $.each(data.comments, function(i, item) {
                content += ('<li class="list-group-item">' + item.comment_content + '<h2 class="text-right"><small>匿名用户' + item.comment_time + '</small></h2><p hidden>' + item.user_account + '</p>' + '</li>' + '</li>')
            });
            var str4 = ('<div id="remove4"><div class="col-sm-2 col-xs-2"></div><div class="col-sm-8 col-xs-8">添加评论<textarea class="form-control commentContent" rows="10" id="anoContent"></textarea></div><div class="col-sm-2 col-xs-2"></div></div>');
            var button = ('<div class="col-sm-offset-6 col-sm-6 Czb_Ano_blank" id="remove5"><button  class="btn btn-default " id="commentButton">提交</button></div>');
            $('#navBlank').html(title);
            $("#testBlank").html(str + content + str2 + str4 + button);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.responseText);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        },
    });
    $(document).on('click', '#commentButton', function() {
        $.ajax({
            url: '/User/check',
            type: 'POST',
            dataType: 'json',
            success: function(data) {
                if (data.status == true) {
                    var commentContent = $("#anoContent").val();
                    $.ajax({
                        url: '/postbar-comment/comment',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            postId: ano_id,
                            content: commentContent
                        },
                        success: function(data) {
                            if (data.status == true) {
                                alert("评论成功");
                                $.ajax({
                                    url: '/postbar-comment/viewCommentByPost',
                                    type: 'POST',
                                    dataType: 'json',
                                    data: {
                                        postId: ano_id,
                                    },
                                    success: function(data) {
                                        $("#remove1").remove()
                                        $("#remove2").remove()
                                        $("#remove3").remove()
                                        var title = ('<div class="col-md-12 col-sm-12 text-center"><h2>' + topicTitle + '</h2></div>')
                                        var str2 = ('</ul></div></div></div><div class="col-sm-2 col-md-2"></div></div>')
                                        var str = ('<div class="row Czb_margin_padding"><div class="col-sm-2 col-md-2"></div><div class="col-sm-8 col-md-8" ><div class="thumbnail"><div class="caption"><ul class="list-group" >')
                                        var content = ''
                                        $.each(data.comments, function(i, item) {
                                            content += ('<li class="list-group-item">' + item.comment_content + '<h2 class="text-right"><small>匿名用户' + item.comment_time + '</small></h2><p hidden>' + item.user_account + '</p>' + '</li>' + '</li>')
                                        });
                                        var str4 = ('<div id="remove4"><div class="col-sm-2 col-xs-2"></div><div class="col-sm-8 col-xs-8">添加评论<textarea class="form-control commentContent" rows="10" id="anoContent"></textarea></div><div class="col-sm-2 col-xs-2"></div></div>');
                                        var button = ('<div class="col-sm-offset-6 col-sm-6 Czb_Ano_blank" id="remove5"><button  class="btn btn-default " id="commentButton">提交</button></div>');
                                        $('#navBlank').html(title);
                                        $("#testBlank").html(str + content + str2 + str4 + button);
                                    },
                                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                                        alert(XMLHttpRequest.responseText);
                                        alert(XMLHttpRequest.readyState);
                                        alert(textStatus);
                                    },
                                });
                            } else {
                                alert("请重新评论");
                            }
                        }
                    });
                } else {
                    alert("请登录！");
                }
            },
        });
    })
})