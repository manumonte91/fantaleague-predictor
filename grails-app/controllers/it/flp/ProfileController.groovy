package it.flp

import grails.converters.JSON

class ProfileController extends BaseController {
    
    def springSecurityService
    def passwordEncoder
    def mailSenderService
    
    static String controller = "profile"
    static String actList = "view"
    static defaultAction = "view"

    def view = {
//        if (!session.user) {
//            redirect uri:'/'
//            return
//        }
        
        def user = Utente.get(params.id)
        if (session.user.id == params.id) session.user = user
        //log.info "SESSION USER: ${session.user as JSON}"
        //log.info "USER: ${user as JSON}"
        
        render view:'view', model:[user:user]
    }
    
    def edit = {
        def user = Utente.get(params.id)
        if (session.user.id == params.id) session.user = user
        //log.info "SESSION USER: ${session.user as JSON}"
        //log.info "USER: ${user as JSON}"
        
        render view:'edit', model:[user:user]
    }
    
    def newProfilePicture = {
        render(template:"newProfilePicture", model:[id:params.id])
    }
    
    private static final okcontents = ['image/png', 'image/jpeg', 'image/gif']
    def upload_avatar() {
      def user = Utente.get(session.user.id) // or however you select the current user

      // Get the avatar file from the multi-part request
      def f = request.getFile('avatar')

      // List of OK mime-types
      if (!okcontents.contains(f.getContentType())) {
        flash.message = "Avatar must be one of: ${okcontents}"
        render(view:'view', model:[user:user])
        return
      }

        log.info("FILE: $f")
        log.info("BYTES: $f.bytes")
        log.info("TYPE: $f.contentType")
      // Save the image and mime type
      user.avatar = f.bytes
      user.avatarType = f.contentType
      log.info("File uploaded: $user.avatarType")

      // Validation works, will check if the image is too big
      if (!user.hasErrors() && user.save(flush:true)) {
          flash.message = "Avatar (${user.avatarType}, ${user.avatar.size()} bytes) uploaded."
          session.user = user
          redirect(action:'view', id: user.id)
      }
      else {
          flash.message = "Errori: $user.errors"
          render(view:'view', model:[user:user])
      }
      
    }
    
    def avatar_image() {
        log.info "AVATAR IMAGE: $params"
        def avatarUser = Utente.get(params.id)
        if (!avatarUser || !avatarUser.avatar || !avatarUser.avatarType) {
          response.sendError(404)
          return
        }
        response.contentType = avatarUser.avatarType
        response.contentLength = avatarUser.avatar.size()
        OutputStream out = response.outputStream
        out.write(avatarUser.avatar)
        out.close()
    }
    
    def changePassword = {
        if (!session.user)
            redirect uri:'/'
    }
    
    def confirmChange = {
        log.info "CONFIRM CHANGE PARAMS: $params"
        def user = Utente.get(session.user.id)
        def oldPassword = params.j_old_password
        def newPassword = params.j_new_password
        def confirmNewPassword = params.j_confirm_new_password
        
        if (!oldPassword || !newPassword || !confirmNewPassword) {
            flash.error = "Inserire i campi richiesti"
        }
        else if (!passwordEncoder.isPasswordValid(user.password, oldPassword, null)) {
            flash.error = "Vecchia Password non corretta"
        }
        else if (oldPassword == newPassword) {
            flash.error = "La Nuova Password deve essere diversa da quella vecchia"
        }
        else if (newPassword != confirmNewPassword) {
            flash.error = "Nuova Password non corrispondente alla Conferma Password"
        }
        
        if (flash.error) {
            render view: 'changePassword'
        } else {
            user.password = newPassword
            user.save(flush:true)
            flash.message = "Password cambiata con successo"
            
            render view: 'view'
        }
    }
    
    def sendMailConfirmation = {
        def user = session.user
        
        mailSenderService.sendMailConfirmation(user)
        
        flash.message = "Mail inviata all'indirizzo $user.email"
        render view:'view'
    }
    
    def mailConfirmed = {
        
        if (params.format == null) {
            def user = Utente.get(Integer.valueOf(params.id))
            user.emailEnabled = true
            user.save(flush:true)
            session.user = user

            flash.message = "Mail $user.email confermata con successo"
            render view:'/dashboard.gsp'
        }
    }
}
