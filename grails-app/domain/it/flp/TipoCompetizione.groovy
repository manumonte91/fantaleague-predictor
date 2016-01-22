package it.flp

class TipoCompetizione {
    
    String descrizione

    static constraints = {
        descrizione maxSize: 255
    }
    
    static mapping = {
        table 'c_tipo_competizione'
    }
}
