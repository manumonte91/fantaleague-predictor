package it.flp

class Pronostico {
    
    Integer golCasa
    Integer golTrasferta
    Integer punteggio
    
    static belongsTo = [partita:Partita, partitaPronostico:PartitaPronostico]

    static constraints = {
        golCasa nullable: false
        golTrasferta nullable: false
        punteggio nullable: false
    }
}
