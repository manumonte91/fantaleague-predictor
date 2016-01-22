package it.flp

import java.text.SimpleDateFormat

class SocialTagLib {
    //static defaultEncodeAs = [all:'raw']
    //static encodeAsForTags = [getAllPosts: [taglib:'html']/*, otherTagName: [taglib:'none']*/]
    //static defaultEncodeAs = 'html'
    def finderService
    
    def getProfilePicture = { attrs ->
        
        def item = Utente.get(attrs.idUser)
        def avatarType = attrs.avatarType
        
        if (item.avatar) {
            out << "<img class=\"$avatarType\" src=\"${createLink(controller:'profile', action:'avatar_image', id:item.ident())}\" />"
        }
        else if (item.avatarUrl) {
            out << "<img class=\"$avatarType\" src=\"$item.avatarUrl\" />"
        }
        else {
            out << img("class":avatarType,"dir":"images","file":(item.gender == 'male' ? 'user-male.png' : 'user-female.png'))
        }
        
    }
    
    def getMomentDate = { attrs ->
        def insert = attrs.date
        def dateInsert = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(insert).getTime()
        def dateNow = new Date().getTime()
        
        def difference = new Date(dateNow - dateInsert)
        Calendar cal = Calendar.getInstance();
        cal.setTime(difference);
        int year = cal.get(Calendar.YEAR) - 1970;
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH) - 1;
        int hour = cal.get(Calendar.HOUR_OF_DAY) - 1;
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        
        out << "<span title=\"$insert\">"
        if (year > 0) {
            out << year + " ann${year == 1 ? 'o' : 'i'} fa"
        }
        else if (month > 0) {
            out << month + " mes${month == 1 ? 'o' : 'i'} fa"
        }
        else if(day > 0) {
            out << day + " giorn${day == 1 ? 'o' : 'i'} fa"
        }
        else if(hour > 0) {
            out << hour + " or${hour == 1 ? 'a' : 'e'} fa"
        }
        else if(minute > 0) {
            out << minute + " minut${minute == 1 ? 'o' : 'i'} fa"
        }
        else {
            out << second + " second${second == 1 ? 'o' : 'i'} fa"
        }
        out << "</span>"
    }
    
    def getAllPosts = { attrs ->
        def list = finderService.postList([:], 'dataInserimento', 'desc', null, null)
        
        out << render(template:'/layouts/social/postList',model:[postList:list])
    }
    
    /*def getAllLikesOfPost = { attrs ->
        def post = attrs.idPost
        def list = finderService.likesPostList([post:post], null, null, null, null)
        
        out << render(template:'/layouts/social/likeList',model:[likeList:list])
    }*/
    
    /*def getAllCommentsOfPost = { attrs ->
        def post = attrs.idPost
        def list = finderService.commentsPostList([post:post], 'dataInserimento', 'asc', null, null)
        
        out << render(template:'/layouts/social/commentList',model:[commentList:list])
    }*/
    
    def getAllLikesOfComment = { attrs ->
        def comment = attrs.idComment
        def list = finderService.likesCommentList([comment:comment], null, null, null, null)
        
        out << render(template:'/layouts/social/likeComment',model:[likeCommentList:list])
    }
    
    def verifyFriendship = { attrs ->
        def idUser = attrs.remove('idUser')
        def myIdUser = attrs.remove('myIdUser')
        
        out << "<input type=\"button\" value=\"Richiedi amicizia\" />"
    }
}
