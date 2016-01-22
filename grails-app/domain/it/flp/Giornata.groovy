package it.flp

class Giornata {
    
    String descrizione
    
    static hasMany = [partite:Partita]
    
    static belongsTo = [competizione:StagioneCompetizione]

    static constraints = {
        descrizione blank: false
    }
}
