package it.flp

class Like implements Serializable {
    
    Post post
    Utente utente
    
    static belongsTo = [post:Post, utente:Utente]
    
    static mapping = {
        table 'like_table'
        id composite: ['post', 'utente']
        version false
    }
}
