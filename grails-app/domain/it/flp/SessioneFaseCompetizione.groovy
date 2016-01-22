package it.flp

class SessioneFaseCompetizione {

    String descrizione
    
    static belongsTo = [competizione:SessioneCompetizione]
    
    static hasMany = [turni:SessioneTurnoCompetizione]

    static constraints = {
        descrizione blank: false
    }
}
