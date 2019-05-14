<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDO ES</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="styles/footer.css">
        <link rel="stylesheet" href="styles/styles.css">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">LOGO MyDO Application</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="registration.jsp">Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="tasks.jsp">Tareas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="projects.jsp">Proyectos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">Contacto</a>
                        </li>
                    </ul>
                </div> 
            </nav>
        </header>

        <div class="jumbotron text-light" style="background: url(images/partearriba.PNG);">
            <div class="container">
                <h1 class="display-4">¿Quieres conocernos?</h1>
                <p class="lead">Madrid Talent Meeting Point, ¿Te apuntas?</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Leer más</a>
            </div>
        </div>
        <div id="centro">
            <p class="display-4 text-center">¿Quienes somos?</p>
            <p class="text-center">MyDO es una propuesta que se lanzó como startup en enero de 2019. <br>
                Aun que de momento somos un equipo realmente pequeño,  <br> disponemos  de las ganas  y actitud necesarias para triunfar.</p>   

            <button class="btn btn-primary" style="margin-left: 47%;">Conocer más</button>

            <p class="display-4 text-center">¿Quieres trabajar con nosotros?</p>
            <p class="text-center">Para ello deberás crear tu cuenta si aún no la tienes. En la sección "Mi cuenta" encontrarás un apartado <br> 
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
            <p class="display-4">No importa quien seas, MyDO está diseñado para ti</p>

        </section>
        <footer id="myFooter">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <h2 class="logo"><a href="#"> LOGO </a></h2>
                    </div>
                    <div class="col-sm-2">
                        <h5>Comencemos</h5>
                        <ul>
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="registration.jsp">Registrarse</a></li>
                            <li><a href="#">Descargas</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-2">
                        <h5>Sobre nosotros</h5>
                        <ul>
                            <li><a href="#">Información de la compañía</a></li>
                            <li><a href="contact.jsp">Contactar</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-2">
                        <h5>Soporte</h5>
                        <ul>
                            <li><a href="#">FAQ</a></li>
                            <li><a href="#">Ayuda</a></li>
                            <li><a href="#">Foros</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-3">
                        <div class="social-networks">
                            <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                            <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                            <a href="#" class="google"><i class="fa fa-google-plus"></i></a>
                        </div>
                        <button type="button" class="btn btn-default">Contactar</button>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <p>© 2019 MyDO ES Co. </p>
            </div>
        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
</html>
