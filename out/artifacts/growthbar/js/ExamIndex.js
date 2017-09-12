// $(document).on('click','.submitAnswer',function(){
// var val=new Array()
// var flag=false
// for (var i = 0; i < 20; i++) {
// str='ans'+(i+1)
// val[i]=$('input[name='+str+']:checked').val()
// if(val[i]==undefined){
// flag=true
// }
// }
// if (flag) {alert('请检查你的所有选项')} else {
// $.ajax({
// url:'',
// type:'post',
// dataType:'JSON',
// data:answer=val,
// success:function(){
// var str=''
// alert('恭喜你完成测试，请等待测试结果。')
// $.each(data,function(i,item){
// str='<div class="thumbnail"><div class="caption"><ul class="list-group" id="ansAdd"><li class="list-group-item">item.result</li></ul></div></div>'
// })
// $('#result').html(str)
// },
// error: function(XMLHttpRequest, textStatus, errorThrown) {
// alert(XMLHttpRequest.responseText);
// alert(XMLHttpRequest.readyState);
// alert(textStatus);
// },
// })
// })
// $(document).ready(function($){
// $.ajax({
// url:'',
// type:'get',
// dataType:'JSON',
// success:function(data){
// var str='<li class="list-group-item">'
//   var num=1
//   $.each(data.que,function(i,item)){
//   queStr+=str+num+'.'+item.que+'+'<br><label><input type="radio" name="ans'+num+'" value=1> A:轻度 <input type="radio" name="ans'+num+'" value=2> B:重度 <input type="radio" name="ans'+num+'" value=3> C：重度 <input type="radio" name="ans'+num+'" value=4> D：你完了 </label></li>'
//   }
//   var str2='<div class="col-sm-4 col-md-4"></div><div class="col-sm-4 col-md-4"><button class="btn btn-default submitAnswer">提交</button></div><div class="col-sm-4 col-md-4"></div>'
//   $('#ansAdd').html(queStr+str2)
//   },
//   error: function(XMLHttpRequest, textStatus, errorThrown) {
//   alert(XMLHttpRequest.responseText);
//   alert(XMLHttpRequest.readyState);
//   alert(textStatus);
//   },
//   })
//   })