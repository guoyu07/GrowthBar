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
//             var str = ('<div><h1 class="text-center" >' + data.article.art_name + '</h1><h2 class="text-right">' + data.article.user_id + '&nbsp;&nbsp;<small id="artTime">' + data.article.post_time + '</small></h2><h2 class="text-left " style="  word-break: break-all;word-wrap: break-word;" id="artContent" >' + data.article.art_content + '</h2></div>');
//             $("#artTitle").html(str);
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     })
// })