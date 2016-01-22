<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
	</head>
	<body>
            <div class="nav" align="center">
                <ul id="menu">
                    <li id="link1"><a href="javascript:void(0)" data-page="calendar">Agenda</a></li>
                    <li id="link2"><a href="javascript:void(0)" data-page="list">Elenco</a></li>       
                </ul>
            </div>
            <div id="listNav">
                <div id="calendar"></div>
                <div id="list">
                    <table>
                        <g:each in="${list}" var="partita">
                            <tr>
                                <td><g:img dir="images" file="${partita.giornata.competizione.competizione.descrizione.replace(" ", "_")}.png" class="avatar_logo_tiny" /></td>
                                <td>
                                    <g:link controller="profile" action="view" id="${partita.casa.utente.id}">
                                        ${partita.casa.fantaLeague}
                                    </g:link>
                                </td>
                                <td><div class="flag_tiny" 
                                        idType="${partita.casa.tipoColoriSociali.id}" 
                                        color1="${partita.casa.coloreSociale1}" 
                                        color2="${partita.casa.coloreSociale2}" 
                                        color3="${partita.casa.coloreSociale3}"></div>
                                </td>
                                <td>${partita.puntiCasa}</td>
                                <td>-</td>
                                <td>${partita.puntiTrasferta}</td>
                                <td><div class="flag_tiny" 
                                        idType="${partita.trasferta.tipoColoriSociali.id}" 
                                        color1="${partita.trasferta.coloreSociale1}" 
                                        color2="${partita.trasferta.coloreSociale2}" 
                                        color3="${partita.trasferta.coloreSociale3}"></div>
                                </td>
                                <td>
                                    <g:link controller="profile" action="view" id="${partita.trasferta.utente.id}">
                                        ${partita.trasferta.fantaLeague}
                                    </g:link>
                                </td>
                            </tr>
                        </g:each>
                    </table>
                </div>
            </div>
            <script type="text/javascript">

            $(document).ready(function() {
                var curPage="";
                $("#listNav > div").each(function() {
                    $(this).hide();
                });
                $("#listNav > div:first").show();
                $("#menu a").click(function() {
                    $("#listNav > div").each(function() {
                        $(this).hide();
                    });
                    curPage=$(this).data("page");
                    $("#"+curPage).show();
                });
                
            var date = new Date();
			var d = date.getDate();
			var m = date.getMonth();
			var y = date.getFullYear();
                $("#calendar").fullCalendar({
                    lang: "it",
                    eventRender: function(event, element) {
                                                    $(element).height(100);
                                                    if(event.start.day() == 2 || event.start.day() == 3) {
                                                        $(element).css('background-image', 'url(../../assets/UCL_Wallpaper.jpg)');
                                                        $(element).css('background-size', 'cover');
                                                        $(element).css('background-position-y', '75%');
                                                    } else if(event.start.day() == 4) {
                                                        $(element).css('background-image', 'url(../../assets/UEL_Wallpaper.jpg)');
                                                        $(element).css('background-size', '130%');
                                                        $(element).css('background-position-y', '20%');
                                                    } else {
                                                        $(element).css('background-image', 'url(../../assets/Serie_A.png)');
                                                        $(element).css('background-size', 'contain');
                                                        $(element).css('background-position', 'center');
                                                    }
                                                    $(element).css('background-repeat', 'no-repeat');
                                                    //$(element).css('opacity', '0.5');
                                                },
                    events: [
                                ${json}
					/*{
						title: 'Serie A',
						start: new Date(y, 0, 31, 18, 0),
						end: new Date(y, 1, 1, 23, 0)
					},
                                        {
						title: 'Serie A',
						start: new Date(y, 1, 7, 18, 0),
						end: new Date(y, 1, 8, 23, 0)
					},
                                        {
						title: 'Serie A',
						start: new Date(y, 1, 14, 18, 0),
						end: new Date(y, 1, 15, 23, 0)
					},
                                        {
						title: 'Serie A',
						start: new Date(y, 1, 21, 18, 0),
						end: new Date(y, 1, 22, 23, 0)
					},
                                        {
						title: 'Serie A',
						start: new Date(y, 1, 28, 18, 0),
						end: new Date(y, 1, 29, 23, 0)
					},
					{
						title: 'UEFA Champions League',
						start: new Date(y, m, 3, 20, 0),
						end: new Date(y, m, 4, 23, 0)
					},
                                        {
						title: 'UEFA Champions League',
						start: new Date(y, m, 17, 20, 0),
						end: new Date(y, m, 18, 23, 0)
					},
                                        {
						title: 'UEFA Europa League',
						start: new Date(y, m, 5, 19, 0),
						end: new Date(y, m, 5, 23, 0)
					},
                                        {
						title: 'UEFA Europa League',
						start: new Date(y, m, 19, 19, 0),
						end: new Date(y, m, 19, 23, 0)
					},
					{
						title: 'Long Event',
						start: new Date(y, m, d-5),
						end: new Date(y, m, d-2)
					},
					{
						id: 999,
						title: 'Repeating Event',
						start: new Date(y, m, d-3, 16, 0),
						allDay: false
					},
					{
						id: 999,
						title: 'Repeating Event',
						start: new Date(y, m, d+4, 16, 0),
						allDay: false
					},
					{
						title: 'Meeting',
						start: new Date(y, m, d, 10, 30),
						allDay: false
					},
					{
						title: 'Lunch',
						start: new Date(y, m, d, 12, 0),
						end: new Date(y, m, d, 14, 0),
						allDay: false
					},
					{
						title: 'Birthday Party',
						start: new Date(y, m, d+1, 19, 0),
						end: new Date(y, m, d+1, 22, 30),
						allDay: false
					},
					{
						title: 'Click for Google',
						start: new Date(y, m, 28),
						end: new Date(y, m, 29),
						url: 'http://google.com/'
					}*/
				]
                });
            });
            
            </script>
	</body>
</html>
