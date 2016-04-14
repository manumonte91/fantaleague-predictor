package it.flp

class BaseController {
    
    static String controller = "base"
    static String actList = "search"
    static defaultAction = "index"

    def finderService
    
    def index() {
            
        redirect controller: params.controller, 
                 action: params.action,
                 id: params.id
    }
    
    def search = {
        log.info("SEARCH - PARAMS: ${params}")
        String query = params["query"]
        if(query){
            def srchResults
            if (query.split(' ').size() > 1)
                srchResults = finderService.searchByNameAndSurname(query.split(' ')[0], query.split(' ')[1])
            else
                srchResults = finderService.searchByNameOrSurname(query, query)

            log.info("QUERY SEARCHABLE - LIST: ${srchResults}")
            log.info("QUERY SEARCHABLE - SIZE: ${srchResults.size()}")
            
            if (srchResults.size() > 0)
                render(template:"/layouts/searchResult", model:[resultSearch:srchResults])
            else
                render(template:"/layouts/searchResult", model:[searchEmptyText:"Nessun risultato trovato"])
        }else{
            render(template:"/layouts/searchResult", model:[searchEmptyText:"Nessun risultato trovato"])
        }
    }
}
