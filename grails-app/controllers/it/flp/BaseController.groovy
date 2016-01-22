package it.flp

class BaseController {

    def searchableService
    
    static String controller = "base"
    static String actList = "searchable"
    static defaultAction = "index"
    
    def index() {
        if(!session.user)
            redirect uri:'/'
            
        redirect controller: params.controller, 
                 action: params.action,
                 id: params.id
    }
    
    def searchable = {
        log.info("SEARCHABLE - PARAMS: ${params}")
        def query = params["query"]
        if(query){
            def srchResults = searchableService.search(query, ["offset": 0, "max": 1000])

            log.info("QUERY SEARCHABLE - LIST: ${srchResults.results}")
            log.info("QUERY SEARCHABLE - SIZE: ${srchResults.total}")
            
            if (srchResults.total > 0)
                render(template:"/layouts/searchResult", model:[resultSearch:srchResults.results])
            else
                render(template:"/layouts/searchResult", model:[searchEmptyText:"Nessun risultato trovato"])
        }else{
            render(template:"/layouts/searchResult", model:[searchEmptyText:"Nessun risultato trovato"])
        }
    }
}
