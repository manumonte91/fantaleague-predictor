package it.flp

class FormatoCompetizione {
    
    static int CAMPIONATO_ITALIANA = 1
    static int FASE_FINALE = 2
    static int GIRONI_FASE_FINALE = 3
    static int GIRONE_UNICO = 4
    static int GIRONE_UNICO_FASE_FINALE = 5
    
    String descrizione

    static constraints = {
        descrizione blank: false
    }
}
