<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <div class="summary">
            <div class="summaryCompetitions">
                Riepilogo Competizioni<br/>
                <div class="flag" 
                    idType="${session.user.giocatore.tipoColoriSociali.id}" 
                    color1="${session.user.giocatore.coloreSociale1}" 
                    color2="${session.user.giocatore.coloreSociale2}" 
                    color3="${session.user.giocatore.coloreSociale3}"></div>
                <span class="fantaLeague">${session.user.giocatore.fantaLeague}</span>
            </div>
            <div class="summarySocial">
                Social
                <input type="hidden" name="id" value="${session.user.id}" />
                <div id="postWrap">
                    <p>
                        <g:textArea class="postText post_" name="testo" rows="5" cols="30" placeholder="Scrivi un post..." />
                    </p>    
                    <input type="button" class="btnSendPost" name="invia" value="Invia" onclick="sendPost(${session.user.id})" />
                </div>
            <hr/>
            <g:getAllPosts />
            </div>
            <div class="summaryContacts">
                Contatti
                <%--
                <iframe src="https://www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2FFantaLeaguePredictor&amp;width=350&amp;height=500&amp;show_faces=true&amp;colorscheme=light&amp;stream=true&amp;border_color&amp;header=false&amp;appId=133010033523978" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:350px; height:500px; background-color:white;" allowTransparency="true"></iframe>
                --%>
            </div>
            </div>
            <g:javascript>
                $(document).ready(function(){
                    $('.postText').autosize({append:false});
                    modelFlag (${session.user.giocatore.tipoColoriSociali.id});
                });
                
                function sendPost(idUser){
                    var post = $('.post_').val();
                    if (!!$.trim(post)){
                        Mask.lock("#postWrap");
                        $.ajax({
                          type: 'POST',
                          url: '${createLink(controller:'social',action:'newPost')}',
                          data: {
                            post: $('.post_').val(),
                            idUser: idUser
                          }
                        }).done(function(response){
                          $(response).hide().prependTo('.posts_').fadeIn('slow');
                          $('.post_').val('');
                          Mask.unlock();
                        });
                    } else {
                        alert ('Inserisci un post correttamente');
                    }
                }
                
                function sendLike(idPost, idUser){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'like')}',
                      data: {
                        idUser: idUser,
                        idPost: idPost
                      }
                    }).done(function(response){
                      $('.likeSummary_' + idPost).html(response);
                    });
                }
                
                function sendDislike(idPost, idUser){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'dislike')}',
                      data: {
                        idUser: idUser,
                        idPost: idPost
                      }
                    }).done(function(response){
                      $('.likeSummary_' + idPost).html(response);
                    });
                }
                
                function displayAllComments(idPost){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'displayAllComments')}',
                      data: {
                        idPost: idPost
                      }
                    }).done(function(response){
                      $('.post_' + idPost).html(response);
                    });
                }
                
                function sendLikeComment(idComment, idUser){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'likeComment')}',
                      data: {
                        idUser: idUser,
                        idComment: idComment
                      }
                    }).done(function(response){
                      $('.likeCommentSummary_' + idComment).html(response);
                    });
                }
                
                function sendDislikeComment(idComment, idUser){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'dislikeComment')}',
                      data: {
                        idUser: idUser,
                        idComment: idComment
                      }
                    }).done(function(response){
                      $('.likeCommentSummary_' + idComment).html(response);
                    });
                }
                
                function sendComment(idPost, idUser){
                    $.ajax({
                      type: 'POST',
                      url: '${createLink(controller:'social',action:'comment')}',
                      data: {
                        commento: $('.commento_' + idPost).val(),
                        idUser: idUser,
                        idPost: idPost
                      }
                    }).done(function(response){
                      $('.post_' + idPost).append(response);
                      $('.commento_' + idPost).val('');
                      $('.commento_' + idPost).autosize({append:false});
                    });
                }
            </g:javascript>
	</body>
</html>
