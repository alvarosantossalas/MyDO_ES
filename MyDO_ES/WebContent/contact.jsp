<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.utilities.structure.Structure" %>
<!DOCTYPE html>
<html>
    <head>
        <% out.println(Structure.getInstance().returnHead()); %>
    </head>
    <body>

	<% out.println(Structure.getInstance().returnHeaderWithoutLogin()); %>

        <div class="jumbotron text-light" style="background: url(images/partearriba.PNG);">
            <div class="container">
                <h1 class="display-4">�Quieres conocernos?</h1>
                <p class="lead">Madrid Talent Meeting Point, �Te apuntas?</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Leer m�s</a>
            </div>
        </div>
        <div id="centro">
            <p class="display-4 text-center">�Quienes somos?</p>
            <p class="text-center">MyDO es una propuesta que se lanz� como startup en enero de 2019. <br>
                Aun que de momento somos un equipo realmente peque�o,  <br> disponemos  de las ganas  y actitud necesarias para triunfar.</p>   

            <button class="btn btn-primary" style="margin-left: 47%;">Conocer m�s</button>

            <p class="display-4 text-center">�Quieres trabajar con nosotros?</p>
            <p class="text-center">Para ello deber�s crear tu cuenta si a�n no la tienes. En la secci�n "Mi cuenta" encontrar�s un apartado <br> 
                dedicado para ello. Estaremos encantados de conocerte : )</p>


            <div class="container" style="margin-left: 42%;">
                <button class="btn btn-secondary">
                    Crear una cuenta    
                </button>
                <button class="btn btn-primary">
                    Login
                </button>
            </div>
            <br>

        </div>
        <section id="info" style="background: url(images/fondo.jpg);">
            <p class="display-4">No importa quien seas, MyDO est� dise�ado para ti</p>

        </section>
		<% out.println(Structure.getInstance().returnFooterWithoutLogin()); %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
</html>
