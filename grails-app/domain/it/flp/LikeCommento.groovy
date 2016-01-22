package it.flp

class LikeCommento implements Serializable {

    Commento commento
    Utente utente
    
    static belongsTo = [commento:Commento, utente:Utente]
    
    static mapping = {
        //table 'SOCIAL_LIKE_COMMENT'
        id composite: ['commento', 'utente']
        version false
    }
}
