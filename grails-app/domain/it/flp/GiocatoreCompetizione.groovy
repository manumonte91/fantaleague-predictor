package it.flp

class GiocatoreCompetizione {
    
    Integer presenze
    Integer vittorie
    Integer pareggi
    Integer sconfitte
    Integer pronosticiRisultati
    Integer pronosticiEsiti
    Integer pronosticiNulli
    Integer puntiFatti
    Integer puntiSubiti
    Integer differenzaPunti
    
    static belongsTo = [giocatore:Giocatore, competizione:Competizione]

    static constraints = {
    }
}
