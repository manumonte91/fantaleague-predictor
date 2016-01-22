class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            //controller = 'base'
            //action = 'index'
            /*constraints {
                // apply constraints here
            }*/
        }
        
        //"/*/*/"(controller:'base', action:'index')

        "/"(view:"/index")
        "/dashboard"(view:"/dashboard")
        "500"(view:'/error') 
	}
}
