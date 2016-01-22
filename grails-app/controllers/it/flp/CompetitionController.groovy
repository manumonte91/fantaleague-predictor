package it.flp

class CompetitionController {

    def index() { }
    
    def view = {
        def comp = SessioneCompetizione.get(params.id)
        
        def squadre = SquadraCompetizione.findAllWhere(
            competizione:StagioneCompetizione.findByCompetizione(comp.competizione))
        
        def giocatori = SessioneGiocatore.findAllWhere(
            competizione:comp.sessione)
        
        def giornate = GiornataPronostico.findAllWhere(
            competizione:comp.competizione
        )
        
        def model = [:]
        model["comp"] = comp
        model["squadre"] = squadre
        model["giocatori"] = giocatori
        model["giornate"] = giornate
        
        if (session["message"]) {
            flash.message = session["message"]
            session["message"] = null
        }
        
        render view:'view', model:model
    }
    
    def generateCalendar = {
        def comp = SessioneCompetizione.get(params.id)
        
        def giocatori = SessioneGiocatore.findAllWhere(
            competizione:comp.sessione).collect{it.giocatore}
        
        //mischio le squadre
        Collections.shuffle(giocatori)
        
        int numero_squadre = giocatori.size();
        int giornate = numero_squadre - 1;
 
        /* crea gli array per le due liste in casa e fuori */
        def casa = new ArrayList<Giocatore>()//[numero_squadre /2];
        def trasferta = new ArrayList<Giocatore>()//[numero_squadre /2];

        for (int i = 0; i < numero_squadre /2; i++) {
            casa.add(giocatori[i]); 
            trasferta.add(giocatori[numero_squadre - 1 - i]); 
        }
        
        for (int i = 0; i < giornate*2; i++) {
            // stampa le partite di questa giornata 
            //render i+1 + "a Giornata<br/>";
            def giornata = new GiornataPronostico()
            giornata.descrizione = i+1 + "a Giornata"
            giornata.competizione = comp

            // alterna le partite in casa e fuori 
            if (i % 2 == 0) {
                for (int j = 0; j < numero_squadre /2 ; j++)
                {
                    def partita = new PartitaPronostico()
                    partita.casa = trasferta.get(j)
                    partita.trasferta = casa.get(j)
                    giornata.addToPartite(partita)
                }
                     //render trasferta.get(j).nome + " - " + casa.get(j).nome + "<br/>"; 
            }
            else {
                for (int j = 0; j < numero_squadre /2 ; j++) 
                {
                    def partita = new PartitaPronostico()
                    partita.casa = casa.get(j)
                    partita.trasferta = trasferta.get(j)
                    giornata.addToPartite(partita)
                }
                     //render casa.get(j).nome + " - " + trasferta.get(j).nome + "<br/>"; 
            }

            //render "<br/>"

            // Ruota in gli elementi delle liste, tenendo fisso il primo elemento
            // Salva l'elemento fisso
            def pivot = casa.get(0);

            // sposta in avanti gli elementi di "trasferta" inserendo 
            //   all'inizio l'elemento casa[1] e salva l'elemento uscente in "riporto" 
            trasferta.add(0, casa.get(1));
            def riporto = trasferta.get(trasferta.size() - 1)
            casa.remove(1) 
            trasferta.remove(trasferta.size() - 1) 

            // sposta a sinistra gli elementi di "casa" inserendo all'ultimo 
            //   posto l'elemento "riporto" 
            casa.add(riporto);

            // ripristina l'elemento fisso
            casa.set(0, pivot);
            
            giornata.save(flush:true)
        }
        
        session.message = "Calendario generato con successo"
        redirect action:'view', id:params.id
    }
}
