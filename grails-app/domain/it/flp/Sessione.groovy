package it.flp

class Sessione {

    String descrizione
    
    static belongsTo = [stagione:Stagione]
    
    static hasMany = [competizioni:SessioneCompetizione]
    
    static constraints = {
        descrizione blank: false
    }
}
