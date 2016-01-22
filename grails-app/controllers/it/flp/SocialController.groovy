package it.flp

class SocialController {

    def newPost = {
        
        def post = new Post()
        post.testo = params.post
        post.tipo = TipoPost.get(1)
        post.user = Utente.get(params.idUser)
        post.save(flush:true)
        
        render template:'/layouts/social/post', model:[post:post]
    }
    
    def like = {
        def user = Utente.get(params.idUser)
        def post = Post.get(params.idPost)
        
        new Like(utente:user, post:post).save(flush:true)
        user.refresh()
        session.user = user
        
        def likeResult = Like.findAllByUtenteAndPost(user, post)
        
        render template:'/layouts/social/likeSummary', model:[likeList:likeResult, post:post]
    }
    
    def dislike = {
        def user = Utente.get(params.idUser)
        def post = Post.get(params.idPost)
        
        def like = Like.findWhere(utente:user, post:post)
        //user.removeFromLikes(like)
        like.delete(flush:true)
        //user.save(flush:true)
        //user.refresh()
        session.user = user
        
        def likeResult = Like.findAllByUtenteAndPost(user, post)
        
        render template:'/layouts/social/likeSummary', model:[likeList:likeResult, post:post]
    }
    
    def displayAllComments = {
        def post = Post.get(params.idPost)
        
        def commentList = Commento.findAllByPost(post)
        
        render template:'/layouts/social/commentList', model:[commentList:commentList,displayAll:true]
    }
    
    def likeComment = {
        def user = Utente.get(params.idUser)
        def comment = Commento.get(params.idComment)
        
        new LikeCommento(utente:user, commento:comment).save(flush:true)
        user.refresh()
        session.user = user
        
        def likeCommentResult = LikeCommento.findAllByUtenteAndCommento(user, comment)
        
        render template:'/layouts/social/likeCommentSummary', model:[likeCommentList:likeCommentResult, comment:comment]
    }
    
    def dislikeComment = {
        def user = Utente.get(params.idUser)
        def comment = Commento.get(params.idComment)
        
        def likeComment = LikeCommento.findWhere(utente:user, commento:comment)
        //user.removeFromLikesComment(likeComment)
        likeComment.delete(flush:true)
        session.user = user
        
        def likeCommentResult = LikeCommento.findAllByUtenteAndCommento(user, comment)
        
        render template:'/layouts/social/likeCommentSummary', model:[likeCommentList:likeCommentResult, comment:comment]
    }
    
    def comment = {
        def text = params.commento
        def user = Utente.get(params.idUser)
        def post = Post.get(params.idPost)
        
        def commento = new Commento()
        commento.testo = text
        commento.user = user
        commento.post = post
        commento.save(flush:true)
        
        render template:'/layouts/social/comment', model:[comment:commento]
    }
}
