<g:if test="${likeCommentList && likeCommentList.size() > 0}">
    <span style="font-weight:normal">
        <g:img dir="images" file="like.png" class="likeIcon" />${likeCommentList.size()}
    </span>
</g:if>