$(document).ready(function() {
$.ajax({
url : "newsservlet",
dataType : "json",
type : "post",
async : false,
success : function(data) {
var html = "";
for(var i=0;i<data.length;i++){
var ls = data[i];
text="<li class="list-group-item"><a href="#">ls.art_name</a></li>"
$("#articleTitle").html(text);
}
},
})
})