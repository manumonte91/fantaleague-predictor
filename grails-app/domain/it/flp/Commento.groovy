package it.flp

class Commento {
    
    String testo
    Post post
    
    Date dataInserimento
    
    static belongsTo = [user:Utente]
    
    static hasMany = [likes:Like]

    static constraints = {
        testo blank: false, maxSize: 1000
        dataInserimento nullable: true
    }
    
    def beforeInsert = {
        dataInserimento = new Date()
    }
}
