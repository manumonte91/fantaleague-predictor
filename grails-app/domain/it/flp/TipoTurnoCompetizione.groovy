package it.flp

class TipoTurnoCompetizione {
    
    static int GIRONE_UNICO = 1
    static int GIRONI = 2
    static int TRENTADUESIMI_FINALE = 3
    static int SEDICESIMI_FINALE = 4
    static int OTTAVI_FINALE = 5
    static int QUARTI_FINALE = 6
    static int SEMIFINALI = 7
    static int FINALE = 8
    
    String descrizione

    static constraints = {
        descrizione blank: false
    }
}
