package it.flp

class Post {

    String testo
    TipoPost tipo
    
    Date dataInserimento
    
    static belongsTo = [user:Utente]
    
    static hasMany = [likes:Like, comments:Commento]
    
    static constraints = {
        testo blank: false, maxSize: 1000
        dataInserimento nullable: true
    }
    
    def beforeInsert = {
        dataInserimento = new Date()
    }
}
