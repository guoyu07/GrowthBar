// $(document).ready(function($) {
//     $.ajax({
//         url: "/GrowthBar_1/article/viewA rticles",
//         type: "POST",
//         dataType: "json",
//         success: function(data) {
//             var str = "";
//             $.each(data.postbars, function(i, item) {
//                 str += ('<li class="list-group-item"><a class="pageGetName" href="#" id="getName' + i + '">' + item.postbar_title + '<p id="getId' + i + '" hidden>' + item.post_id + '</p></a></li>');
//             });
//             $("#anoTitle").html(str)
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
//                 $.each(data.postbars, function(i, item) {
//                     str += ('<li class="list-group-item"><a class="pageGetName" href="#" id="getName' + i + '">' + item.postbar_title + '<p id="getId' + i + '" hidden>' + item.postbar_id + '</p></a></li>');
//                 });
//                 $("#anoTitle").html(str)
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
//     var textContent = $(this).clone();
//     textContent.find(':nth-child(n)').remove()
//     var topicTitle = textContent.html()
//     var ano_id = $(this).children('p').html()
//     $.ajax({
//         url: '/GrowthBar_1/article/viewArticle',
//         type: 'POST',
//         dataType: 'json',
//         data: {
//             post_id: post_id
//         },
//         success: function(data) {
//             $("#remove1").remove()
//             $("#remove2").remove()
//             $("#remove3").remove()
//             var title = ('<div class="col-md-12 col-sm-12 text-center"><h2>' + topicTitle + '</h2></div>')
//             var str2 = ('</ul></div></div></div><div class="col-sm-2 col-md-2"></div></div>')
//             var str = ('<div class="row Czb_margin_padding"><div class="col-sm-2 col-md-2"></div><div class="col-sm-8 col-md-8" ><div class="thumbnail"><div class="caption"><ul class="list-group" >')
//             var content = ''
//             $.each(data.postbar_comment, function(i, item) {
//                 content += ('<li class="list-group-item">' + item.comment_content + '<h2 class="text-right"><small>匿名用户'+item.comment_time+'</small></h2><p hidden>'+item.user_id+'</p>' + '</li>' + '</li>')
//             });
//             $('#navBlank').html(title)
//             $("#testBlank").html(str + content + str2);
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     })
// })