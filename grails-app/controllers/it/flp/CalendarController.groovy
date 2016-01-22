package it.flp

import java.util.*
import groovy.json.JsonBuilder

class CalendarController {

    def view = {
        def player = Utente.get(params.id).giocatore
        
        def list = PartitaPronostico.findAllByCasaOrTrasferta(player, player).sort{it.id}
        
        def json = buildJsonCalendar(list)
        log.info "JSON $json"
        
        render view:"view", model:[list:list, listJson:json]
    }
    
    public String buildJsonCalendar(def partite) {
       


        def json = new JsonBuilder()

        json{
             matches(partite.collect {
                           [title: it.giornata.competizione.competizione.descrizione,
                            start: it.dataPartita,
                            end: it.dataPartita]
                    })
        }

        return json.toPrettyString()
    }
    
    def calendarSimulator = {
        
        def squadre = SquadraCompetizione.findAllByCompetizione(Competizione.findByDescrizione("Serie A")).collect{ it.squadra }
        
        //mischio le squadre
        Collections.shuffle(squadre)
        
        int numero_squadre = squadre.size();
        int giornate = numero_squadre - 1;
 
        /* crea gli array per le due liste in casa e fuori */
        def casa = new ArrayList<Squadra>()//[numero_squadre /2];
        def trasferta = new ArrayList<Squadra>()//[numero_squadre /2];

        for (int i = 0; i < numero_squadre /2; i++) {
            casa.add(squadre[i]); 
            trasferta.add(squadre[numero_squadre - 1 - i]); 
        }
        
        for (int i = 0; i < giornate*2; i++) {
            /* stampa le partite di questa giornata */
            render i+1 + "a Giornata<br/>";

            /* alterna le partite in casa e fuori */
            if (i % 2 == 0) {
                for (int j = 0; j < numero_squadre /2 ; j++)
                     render trasferta.get(j).nome + " - " + casa.get(j).nome + "<br/>"; 
            }
            else {
                for (int j = 0; j < numero_squadre /2 ; j++) 
                     render casa.get(j).nome + " - " + trasferta.get(j).nome + "<br/>"; 
            }

            render "<br/>"

            // Ruota in gli elementi delle liste, tenendo fisso il primo elemento
            // Salva l'elemento fisso
            def pivot = casa.get(0);

            /* sposta in avanti gli elementi di "trasferta" inserendo 
               all'inizio l'elemento casa[1] e salva l'elemento uscente in "riporto" */
            trasferta.add(0, casa.get(1));
            def riporto = trasferta.get(trasferta.size() - 1)
            casa.remove(1) 
            trasferta.remove(trasferta.size() - 1) 

            /* sposta a sinistra gli elementi di "casa" inserendo all'ultimo 
               posto l'elemento "riporto" */
            casa.add(riporto);

            // ripristina l'elemento fisso
            casa.set(0, pivot);
        } 
        
    }
}
