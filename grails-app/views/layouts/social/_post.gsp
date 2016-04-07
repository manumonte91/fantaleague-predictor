<li>
    <div style="margin-bottom:5px">
    <span style="float:left">
        <g:getProfilePicture idUser="${post.user.id}" avatarType="avatar_small" />
    </span>
        <div style="margin-left:3.5em">
            <a href="${createLink(controller:'profile',action:'view',id:post.user.id)}">
                ${post.user.nomeEsteso}
            </a>
            <br/>
            <div style="font-size:11px;font-weight:normal;">
                <g:getMomentDate date="${post.dataInserimento.format("dd/MM/yyyy HH:mm:ss")}" />
            </div>
            <span style="font-size:14px;font-weight:normal;">${post.testo}</span>
        </div>
        <%-- <br/>--%>
         <div class="replySummary">
             <div class="likeSummary_${post.id}">
                 <g:render template="/layouts/social/likeSummary" />
             </div>
             <div class="post_${post.id}">
                 <%-- <g:set var="allComments${post.id}" value="${commentList.size() < 10}" />--%>
                 <%--<g:getAllCommentsOfPost idPost="${post.id}" />--%>
                 <g:render template="/layouts/social/commentList" model="['commentList':post.comments]" />
             </div>
             <p class="comment">
                 <g:getProfilePicture idUser="${session.user.id}" avatarType="avatar_tiny" />
                 <input type="hidden" name="id" value="${session.user.id}" />

                 <g:textArea class="postText commento_${post.id}" name="commento_${post.id}" rows="1" placeholder="Scrivi un commento..."
                    onkeyup='if (event.which == 13 && !event.shiftKey && !!\$.trim(\$(this).val())) { sendComment(${post.id},${session.user.id}); }'></g:textArea>
             </p>
         </div>
    </div>
</li>
