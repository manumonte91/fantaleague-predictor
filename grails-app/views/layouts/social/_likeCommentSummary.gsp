<g:if test="${session.user.likesComment.find { it.commento.id == comment.id }}">
    <a href="javascript:void(0)" onclick="sendDislikeComment(${comment.id}, ${session.user.id})">
        Non mi piace più
    </a> 
</g:if>
<g:else>
    <a href="javascript:void(0)" onclick="sendLikeComment(${comment.id}, ${session.user.id})">
        Mi piace
    </a> 
</g:else>
<g:getAllLikesOfComment idComment="${comment.id}" />