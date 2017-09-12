// $(document).on("click", "#submitTopic", function() {
//     var anoTopic = $("#anoTopic").val()
//     var userId = $("#userId").val()
//     $.ajax({
//         url: '',
//         type: 'post',
//         dataType: 'json'
//         data: {
//             user_id: userId,
//             ano_name: anoTopic
//         },
//         success: function(data) {

//             window.location.href = 'Ano_index.html'
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     })
// })

// $(document).ready(function() {
//     $.ajax({
//         url: '',
//         type: 'post',
//         dataType: 'json'
//         success: function(data) {
//             var str = ''
//             $.each(data.ano, function(i, item) {
//                 str += ('<li class="list-group-item"><a href="#">' + item.ano_name + '</a></li>')
//             });
//             $("#addAnoTopic").html(str)
//         },
//         error: function(XMLHttpRequest, textStatus, errorThrown) {
//             alert(XMLHttpRequest.responseText);
//             alert(XMLHttpRequest.readyState);
//             alert(textStatus);
//         },
//     })
// })