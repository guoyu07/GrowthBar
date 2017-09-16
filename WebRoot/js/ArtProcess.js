// $(document).ready(function($) {
//     $.ajax({
//         url: "/GrowthBar_1/article/viewArticles",
//         type: "POST",
//         dataType: "json",
//         success: function(data) {
//             var str = "";
//             $.each(data.articles, function(i, item) {
//                 str += ('<li class="list-group-item"><a href="#" id="getName' + i + '">' + item.art_name + '<p id="getId' + i + '" hidden>' + item.art_id + '</p></a></li>');
//             });
//             $("#artTitle").html(str)
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     });
// });
// $(function($) {
//     $(".pageAll").click(function() {
//         var page = $(this).html()
//         alert(page)
//         $.ajax({
//             url: "/GrowthBar_1/article/viewArticles",
//             type: "POST",
//             dataType: "json",
//             data: {
//                 pageNum: page
//             },
//             success: function(data) {
//                 var str = "";
//                 $.each(data.articles, function(i, item) {
//                     str += ('<li class="list-group-item "><a class="pageGetName" href="#" id="getName">' + item.art_name + '<p id="getId' + i + '" hidden>' + item.art_id + '</p></a></li>');
//                 });
//                 $("#artTitle").html(str)
//             },
//             error: function(XMLHttpRequest, textStatus, errorThrown) {
//                 alert(XMLHttpRequest.responseText);
//                 alert(XMLHttpRequest.readyState);
//                 alert(textStatus);
//             },
//         })
//     });
// })

// $(document).on("click", ".pageGetName", function() {
//     var textContent = $(this).children('p').html();
//     $.ajax({
//         url: '/GrowthBar_1/article/viewArticle',
//         type: 'POST',
//         dataType: 'json',
//         data: {
//             artId: textContent
//         },
//         success: function(data) {
            // var str =('<div class="container-fluid"><div class="row"><div class="col-xs-12" style="text-align: center;"><h2>'+data.article.art_name+'</h2><p>'+data.article.user_id+' <small> '+data.article.post_time+'</small></p></div><div class="col-xs-3"></div><div class="col-xs-6"><div class="form-control" style="">'+data.article.art_content+'</div></div><div class="col-xs-3"></div></div></div>'); 
            // $("#artDisplay").html(str);
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     })
// })