package it.flp

class Notifica {
    
    String descrizione
    boolean isRead = 0
    
    static belongsTo = [user:Utente]

    static constraints = {
        descrizione blank: false
    }
}
