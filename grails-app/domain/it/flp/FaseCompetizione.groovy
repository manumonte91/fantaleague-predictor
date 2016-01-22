package it.flp

class FaseCompetizione {
    
    String descrizione
    
    static belongsTo = [competizione:Competizione]
    
    static hasMany = [turni:TurnoCompetizione]

    static constraints = {
        descrizione blank: false
    }
}
