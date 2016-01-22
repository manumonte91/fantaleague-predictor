<div class="likeList">
    <ul class="likeList_${post.id}">
        <g:if test="${likeList && likeList.size() > 0}">
            <g:img dir="images" file="like.png" class="likeIcon" />
            <g:render template="/layouts/social/like" model="['likeList':likeList]" />
        </g:if>
    </ul>
</div>
