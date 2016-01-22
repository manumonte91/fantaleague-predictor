package it.flp

class SquadraCompetizione implements Serializable {

    Squadra squadra
    StagioneCompetizione competizione
    Integer presenze = 0
    Integer vittorie = 0
    Integer pareggi = 0
    Integer sconfitte = 0
    Integer golFatti = 0
    Integer golSubiti = 0
    Integer differenzaReti = 0
    
    static mapping = {
        //id composite: ['squadra','competizione']
        //version false
        //table 'P_SQUADRA_COMPETIZIONE'
    }
    
}
