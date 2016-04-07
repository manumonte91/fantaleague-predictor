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
                var urlSendPost = "${createLink(controller:'social',action:'newPost')}";
                var urlSendDisplayAllComments = "${createLink(controller:'social',action:'displayAllComments')}";
                var urlSendLike = "${createLink(controller:'social',action:'like')}";
                var urlSendDislike = "${createLink(controller:'social',action:'dislike')}";
                var urlSendComment = "${createLink(controller:'social',action:'comment')}";
                var urlSendLikeComment = "${createLink(controller:'social',action:'likeComment')}";
                var urlSendDislikeComment = "${createLink(controller:'social',action:'dislikeComment')}";
            </g:javascript>
	</body>
</html>
