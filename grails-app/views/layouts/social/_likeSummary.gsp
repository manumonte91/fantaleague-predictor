<g:if test="${session.user.likes.find { it.post.id == post.id }}">
    <a href="javascript:void(0)" onclick="sendDislike(${post.id}, ${session.user.id})">Non mi piace più</a> 
</g:if>
<g:else>
    <a href="javascript:void(0)" onclick="sendLike(${post.id}, ${session.user.id})">Mi piace</a> 
</g:else>
- <a href="javascript:void(0)">Commenta</a>
<hr/>
<g:render template="/layouts/social/likeList" model="['likeList':post.likes]" />
<%--<g:getAllLikesOfPost idPost="${post.id}" />--%>
