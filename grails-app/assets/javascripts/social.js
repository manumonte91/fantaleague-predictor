/**
 * Created by OpenStyleDev on 07/04/2016.
 */
function sendPost(idUser) {
    var post = $('.post_').val();
    if (!!$.trim(post)) {
        Mask.lock("#postWrap");
        $.ajax({
            type: 'POST',
            url: urlSendPost,
            data: {
                post: $('.post_').val(),
                idUser: idUser
            }
        }).done(function (response) {
            $(response).hide().prependTo('.posts_').fadeIn('slow');
            $('.post_').val('');
            Mask.unlock();
        });
    } else {
        alert('Inserisci un post correttamente');
    }
}

function sendLike(idPost, idUser) {
    $.ajax({
        type: 'POST',
        url: urlSendLike,
        data: {
            idUser: idUser,
            idPost: idPost
        }
    }).done(function (response) {
        $('.likeSummary_' + idPost).html(response);
    });
}

function sendDislike(idPost, idUser) {
    $.ajax({
        type: 'POST',
        url: urlSendDislike,
        data: {
            idUser: idUser,
            idPost: idPost
        }
    }).done(function (response) {
        $('.likeSummary_' + idPost).html(response);
    });
}

function displayAllComments(idPost) {
    $.ajax({
        type: 'POST',
        url: urlSendDisplayAllComments,
        data: {
            idPost: idPost
        }
    }).done(function (response) {
        $('.post_' + idPost).html(response);
    });
}

function sendLikeComment(idComment, idUser) {
    $.ajax({
        type: 'POST',
        url: urlSendLikeComment,
        data: {
            idUser: idUser,
            idComment: idComment
        }
    }).done(function (response) {
        $('.likeCommentSummary_' + idComment).html(response);
    });
}

function sendDislikeComment(idComment, idUser) {
    $.ajax({
        type: 'POST',
        url: urlSendDislikeComment,
        data: {
            idUser: idUser,
            idComment: idComment
        }
    }).done(function (response) {
        $('.likeCommentSummary_' + idComment).html(response);
    });
}

function sendComment(idPost, idUser) {
    $.ajax({
        type: 'POST',
        url: urlSendComment,
        data: {
            commento: $('.commento_' + idPost).val(),
            idUser: idUser,
            idPost: idPost
        }
    }).done(function (response) {
        $('.post_' + idPost).append(response);
        $('.commento_' + idPost).val('');
        $('.commento_' + idPost).autosize({append: false});
    });
}