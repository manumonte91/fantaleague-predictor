package it.flp

class GiornataPronostico {

    String descrizione
    
    static hasMany = [partite:PartitaPronostico]
    
    static belongsTo = [competizione:SessioneCompetizione]

    static constraints = {
        descrizione blank: false
    }
}
