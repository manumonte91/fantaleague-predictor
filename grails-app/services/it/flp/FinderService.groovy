package it.flp

import grails.transaction.Transactional

@Transactional
class FinderService {

    def serviceMethod() {

    }
    
    /*def postCondizioni = { params ->
        def ricerca = params["ricerca"]
        log.info("RICERCA: ${ricerca}")
        def cond = {
            if (ricerca) {
                or {
                    ilike("username", '%' + ricerca + '%')
                    ilike("password", '%' + ricerca + '%')
                    ilike("name", '%' + ricerca + '%')
                }
            }
        }
        return cond
    }*/

    def postList = { params, srt, ord, offset, max ->
        //def cond = utenteCondizioni(params)
        def result = Post.createCriteria().list() {
            //and (cond)
            if (srt) {
                order(srt, ord)
            }
            if (max >= 0) maxResults(max)
            if (offset >= 0) firstResult(offset)
        }
    }

    def postCount = { params ->
        //def cond = utenteCondizioni(params)
        def tot = Post.createCriteria().get() {
            //and (cond)
            projections{
                countDistinct("id")
            }
        }
    }
    
    def likePostCondizioni = { params ->
        def idPost = params["post"]
        def cond = {
            if (idPost) {
                post {
                    eq('id', idPost)
                }
            }
        }
        return cond
    }
    
    def likesPostList = { params, srt, ord, offset, max ->
        def idPost = params["post"]
        def result = Like.findAllByPost(Post.get(idPost))
        
        return result
        /*def cond = likePostCondizioni(params)
        def result = Like.createCriteria().list() {
            and (cond)
            if (srt) {
                order(srt, ord)
            }
            if (max >= 0) maxResults(max)
            if (offset >= 0) firstResult(offset)
        }*/
    }

    def likesPostCount = { params ->
        def cond = commentPostCondizioni(params)
        def tot = Like.createCriteria().get() {
            and (cond)
            projections{
                countDistinct("id")
            }
        }
    }
    
    def commentPostCondizioni = { params ->
        def idPost = params["post"]
        def cond = {
            if (idPost) {
                post {
                    eq('id', idPost)
                }
            }
        }
        return cond
    }
    
    def commentsPostList = { params, srt, ord, offset, max ->
        def cond = commentPostCondizioni(params)
        def result = Commento.createCriteria().list() {
            and (cond)
            if (srt) {
                order(srt, ord)
            }
            if (max >= 0) maxResults(max)
            if (offset >= 0) firstResult(offset)
        }
    }

    def commentsPostCount = { params ->
        def cond = commentPostCondizioni(params)
        def tot = Commento.createCriteria().get() {
            and (cond)
            projections{
                countDistinct("id")
            }
        }
    }
    
    def likesCommentList = { params, srt, ord, offset, max ->
        def idComment = params["comment"]
        def result = LikeCommento.findAllByCommento(Commento.get(idComment))
        
        return result
        /*def cond = likePostCondizioni(params)
        def result = Like.createCriteria().list() {
            and (cond)
            if (srt) {
                order(srt, ord)
            }
            if (max >= 0) maxResults(max)
            if (offset >= 0) firstResult(offset)
        }*/
    }
    
    def findFriendship = { params ->
        
    }

    def searchByNameOrSurname (String nome, String cognome) {
        Utente.createCriteria().list(offset: 0, max: 1000) {
            or {
                ilike("nome", "%" + nome + "%")
                ilike("cognome", "%" + cognome + "%")
            }
        }
    }

    def searchByNameAndSurname (String nome, String cognome) {
        Utente.createCriteria().list(offset: 0, max: 1000) {
            and {
                ilike("nome", "%" + nome + "%")
                ilike("cognome", "%" + cognome + "%")
            }
        }
    }
}
