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