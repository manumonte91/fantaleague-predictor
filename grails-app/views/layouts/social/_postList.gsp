<div class="postList">
    <ul class="posts_">
    <g:if test="${postList.size() > 0}">
        <g:each in="${postList}" var="post" status="i">
            <g:if test="${i != 0}"><hr/></g:if>
                <g:render template="/layouts/social/post" model="['post':post]" />
                <g:javascript>
                    $('.commento_${post.id}').keyup(function(e){
                        if (e.which == 13 && !event.shiftKey && !!$.trim($(this).val())) {
                            sendComment(${post.id},${session.user.id});
                        }
                    });
                </g:javascript>
        </g:each>
    </g:if>
    </ul>
</div>
