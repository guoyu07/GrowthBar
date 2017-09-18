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
                      $(document).on('click', '#addArticle', function() {
                          var str1 = '<tr style="text-align: center;">';
                          var str2 = '</tr>';
                          var content = '';
                          $.ajax({
                                  url: '/article/viewOwn',
                                  type: 'POST',
                                  dataType: 'json',
                                  success: function(data) {
                                      $.each(data.articles, function(i, item) {
                                          content += ('<td><a class="clickArt">' + item.article_title + '<p hidden>' + item.article_id + '</p>' + '</a></td>');
                                      });
                                      $("#addInfo").html(str1 + content + str2);
                                  }
                              })
                              /* Act on the event */
                      });
                      $(document).on('click', '#addPost', function() {
                          var str1 = '<tr style="text-align: center;">';
                          var str2 = '</tr>';
                          var content = '';
                          $.ajax({
                                  url: '/postbar/viewRelated',
                                  type: 'POST',
                                  dataType: 'json',
                                  success: function(data) {
                                      $.each(data.postList, function(i, item) {
                                          content += ('<td><a class="clickPost">' + item.post_title + '<p hidden>' + item.postabar_id + '</p>' + '</a></td>');
                                      });
                                      $("#addInfo").html(str1 + content + str2);
                                  }
                              })
                              /* Act on the event */
                      });
                      $(document).on('click', '.clickPost', function() {
                          var ano_id = $(this).children('p').html();
                          $.ajax({
                                  url: '/postbar-comment/viewCommentByPost',
                                  type: 'POST',
                                  dataType: 'json',
                                  data: {
                                      postId: ano_id,
                                  },
                                  success: function(data) {
                                      var str2 = ('</ul></div></div></div><div class="col-sm-2 col-md-2"></div></div>')
                                      var str = ('<div class="row Czb_margin_padding"><div class="col-sm-2 col-md-2"></div><div class="col-sm-8 col-md-8" ><div class="thumbnail"><div class="caption"><ul class="list-group" >')
                                      var content = ''
                                      $.each(data.comments, function(i, item) {
                                          content += ('<li class="list-group-item">' + item.comment_content + '<h2 class="text-right"><small>匿名用户' + item.comment_time + '</small></h2><p hidden>' + item.user_account + '</p>' + '</li>' + '</li>')
                                      });
                                      $(this).html(str + content + str2);
                                  }
                              })
                              /* Act on the event */
                      });
                      $(document).on('click', '.clickArt', function() {
                          var article_id = $(this).children('p').html();
                          var str = '';
                          $.ajax({
                                  url: '/article/viewArticle',
                                  type: 'POST',
                                  dataType: 'json',
                                  data: {
                                      artId: article_id,
                                  },
                                  success: function(data) {
                                      str = ('<div class="container-fluid"><div class="row"><div class="col-xs-12" style="text-align: center;"><h2>' + data.article.article_title + '</h2><p>' + data.article.user_account + ' <small> ' + data.article.post_time + '</small></p></div><div class="col-xs-3"></div><div class="col-xs-6"><div class="form-control" style="border:none;">' + data.article.article_content.replace(/\n/g, '<br>') + '</div></div><div class="col-xs-3"></div></div></div>');
                                      $(this).html(str);
                                  },

                              })
                              /* Act on the event */
                      });

                      $(document).on('click', '#addExam', function() {
                          var quTiHua = 0;
                          var qiangPo = 0;
                          var renJi = 0;
                          var yiYu = 0;
                          var jiaoLv = 0;
                          var diDui = 0;
                          var kongBu = 0;
                          var pianZhi = 0;
                          var jingShenBing = 0;
                          var shuiMian = 0;
                          $.ajax({
                                  url: '/Exam/queryOwnResults',
                                  type: 'POST',
                                  dataType: 'json',
                                  success: function(data) {
                                      quTiHua = data.exam.quTiHua;
                                      qiangPo = data.exam.qiangPo;
                                      renJi = data.exam.renJi;
                                      yiYu = data.exam.yiYu;
                                      jiaoLv = data.exam.jiaoLv;
                                      diDui = data.exam.jiaoLv;
                                      kongBu = data.exam.kongBu;
                                      pianZhi = data.exam.pianZhi;
                                      jingShenBing = data.exam.jingShenBing;
                                      shuiMian = data.exam.shuiMian;
                                      $("#addInfo").html('<tr>' + '<td>特征' + '</td>' + '<td>得分' + '</td>' + '</tr>' + '<tr>' + '<td>躯体化' + '</td>' + '<td>' + quTiHua + '</td>' + '</tr>' + '<tr>' + '<td>强迫' + '</td>' + '<td>' + qiangPo + '</td>' + '</tr>' + '<tr>' + '<td>焦虑' + '</td>' + '<td>' + jiaoLv + '</td>' + '</tr>' + '<tr>' + '<td>敌对性' + '</td>' + '<td>' + diDui + '</td>' + '</tr>' + '<tr>' + '<td>恐怖' + '</td>' + '<td>' + kongBu + '</td>' + '</tr>' + '<tr>' + '<td>偏执' + '</td>' + '<td>' + pianZhi + '</td>' + '</tr>' + '<tr>' + '<td>精神病性' + '</td>' + '<td>' + jingShenBing + '</td>' + '</tr>' + '<tr>' + '<td>睡眠及饮食' + '</td>' + '<td>' + shuiMian + '</td>' + '</tr>');
                                  },
                              })
                              /* Act on the event */
                      });
                      $(document).on('click', '#addOnline', function(data) {
                          var str1 = '<tr style="text-align: center;">';
                          var str2 = '</tr>';
                          var content = '';
                          $.ajax({
                                  url: '/appointment/viewOwn',
                                  type: 'POST',
                                  dataType: 'json',
                                  success: function(data) {
                                      $.each(data.online, function(i, item) {
                                          content += ('<td><a class="clickPost">' + item.activity_theme + '<p hidden>' + item.activity_id + '</p>' + '</a></td>' + '<td>' + activity_content + '</td>' + '<td>' + activity_time + '</td>' + '<td>' + activity_place + '</td>')
                                      });
                                      $("#addInfo").html(str1 + content + str2);
                                  }
                              })
                              /* Act on the event */
                      });
                  } else {
                      $("#getUserID").toggle();
                  }
              },
          })
      });