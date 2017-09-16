$(document).ready(function ($) {
    $.ajax({
               url: "/article/viewArticles",
               type: "POST",
               dataType: "json",
               success: function (data) {
                   var str = "";
                   $.each(data.articles, function (i, item) {
                       str +=
                           ('<li class="list-group-item"><a href="#" class="pageGetName" id="getName' + i + '">'
                            + item.article_title + '<p id="getId' + i + '" hidden>' + item.article_id
                            + '</p></a></li>');
                   });
                   $("#artTitle").html(str)
               },
               error: function (XMLHttpRequest, textStatus, errorThrown) {
                   alert(XMLHttpRequest.responseText);
                   alert(XMLHttpRequest.readyState);
                   alert(textStatus);
               },
           });
});
$(function ($) {
    $(".pageAll").click(function () {
        var page = $(this).html();
        $.ajax({
                   url: "/article/viewArticles",
                   type: "POST",
                   dataType: "json",
                   data: {
                       pageNum: page
                   },
                   success: function (data) {
                       var str = "";
                       $.each(data.articles, function (i, item) {
                           str +=
                               ('<li class="list-group-item "><a class="pageGetName" href="#" id="getName">'
                                + item.art_name + '<p id="getId' + i + '" hidden>' + item.art_id
                                + '</p></a></li>');
                       });
                       $("#artTitle").html(str)
                   },
                   error: function (XMLHttpRequest, textStatus, errorThrown) {
                       alert(XMLHttpRequest.responseText);
                       alert(XMLHttpRequest.readyState);
                       alert(textStatus);
                   },
               })
    });
})

$(document).on("click", ".pageGetName", function () {
    var textContent = $(this).children('p').html();
    var str = "";
    $.ajax({
               url: '/article/viewArticle',
               type: 'POST',
               dataType: 'json',
               data: {
                   artId: textContent
               },
               success: function (data) {
                   str = ('<div class="container-fluid"><div class="row"><div class="col-xs-12" style="text-align: center;"><h2>'+ data.article.article_title + '</h2><p>' + data.article.user_account+ ' <small> ' + data.article.post_time+ '</small></p></div><div class="col-xs-3"></div><div class="col-xs-6"><div class="form-control" style="border:none;">'+ data.article.article_content+ '</div></div><div class="col-xs-3"></div></div></div>');
                    $("#artDisplay").html(str);
               },
               error: function (XMLHttpRequest, textStatus, errorThrown) {
                   alert(XMLHttpRequest.responseText);
                   alert(XMLHttpRequest.readyState);
                   alert(textStatus);
               },
           })
})