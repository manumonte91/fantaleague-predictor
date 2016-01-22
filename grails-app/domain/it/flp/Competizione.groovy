package it.flp

class Competizione {
    
    TipoCompetizione tipoComp
    String siglaNazione
    String codComp
    String descrizione
    FormatoCompetizione formato
    Integer squadre
    
    static hasMany = [fasi:FaseCompetizione]

    static constraints = {
        siglaNazione maxSize: 2
        codComp maxSize: 1
        descrizione maxSize: 255
        squadre nullable: false
    }
    
    static mapping = {
        table 'c_competizione'
    }
}
