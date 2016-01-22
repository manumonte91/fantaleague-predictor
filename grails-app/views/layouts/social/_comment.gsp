<li>
    <p style="margin-bottom:5px">
        <span style="float:left">
            <g:getProfilePicture idUser="${comment.user.id}" avatarType="avatar_tiny" />
        </span>
        <div style="margin-left:3em">
            <a href="${createLink(controller:'profile',action:'view',id:comment.user.id)}">
                ${comment.user.nomeEsteso}
            </a>
            <span style="font-size:12px;font-weight:normal;">${comment.testo}</span>
            <br/>
            <span style="font-weight:normal;vertical-align:middle">
                <g:getMomentDate date="${comment.dataInserimento.format("dd/MM/yyyy HH:mm:ss")}" />
            </span> - 
            <span style="vertical-align:middle" class="likeCommentSummary_${comment.id}">
                <g:render template="/layouts/social/likeCommentSummary" />
            </span>
        </div>
    </p>
</li>