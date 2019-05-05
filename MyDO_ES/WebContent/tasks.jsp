<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDO Es</title>
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
                <h1 class="display-4">¡Totalmente gratis!</h1>
                <p class="lead">Proponemos soluciones para particulares y empresas</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Leer más</a>
            </div>
        </div>
        <div id="centro">
            <p class="display-4 text-center">Llena tu vida de color, llena tu trabajo de alegría.</p>
            <p class="h5 text-center">Optimizar tu tiempo es nuestro trabajo, por tanto, tienes a tu disposición distintos tipos de tareas definidas según colores para mejorar tu rendimiento.</p>     


            <div class="card border-primary mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea actual</div>
                <div class="card-body text-primary">
                    <h5 class="card-title">En progreso...</h5>
                    <p class="card-text">Este tipo de tarea es para aquellas que están en ejecución, y de prioridad <b>normal.</b></p>
                </div>
            </div>
            <div class="card border-secondary mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea actual</div>
                <div class="card-body text-secondary">
                    <h5 class="card-title">Relax, no hay prisa</h5> 
                    <p class="card-text">Este tipo de tareas es para aquellas que están en ejecución, y de prioridad <b>baja</b>.</p>
                </div>
            </div>
            <div class="card border-warning mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea actual</div>
                <div class="card-body text-warning">
                    <h5 class="card-title">¡No te relajes!</h5>
                    <p class="card-text">Este tipo de tareas es para aquellas que están en ejecución, y de prioridad <b>alta</b></p>
                </div>
            </div>
            <div class="card border-success mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea finalizada</div>
                <div class="card-body text-success">
                    <h5 class="card-title">¡Buen trabajo!</h5>
                    <p class="card-text">El trabajo se ha cumplido. Esta tarea se quedará abierta hasta que el usuario decida cerrarla.</p>
                </div>
            </div>
            <div class="card border-danger mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea abortada</div>
                <div class="card-body text-danger">
                    <h5 class="card-title">Vaya...</h5>
                    <p class="card-text">Por una cosa o por otra, alguna vez tendremos que abandonar tareas. Esta será la tarjeta.</p>
                </div>
            </div>

            <div class="card border-info mb-3 tarea_ejemplo" style="max-width: 18rem;">
                <div class="card-header">Tarea en proyecto</div>
                <div class="card-body text-info">
                    <h5 class="card-title">¡Trabajo en equipo!</h5>
                    <p class="card-text">Así se marcarán las tareas que pertenezcan a un proyecto. Te ayudará a manterte organizado : )</p>
                </div>
            </div>
            <br>

        </div>
        <p class="text-center">¿Crees que esta definición de tareas no se corresponde a lo que estás buscando? 
            <br>
            No te preocupes, dispondrás de un modo de personalización para que diseñes tarjetas a tu gusto.</p>   
        <br><br>
        <section id="info" style="background: url(images/fondo.jpg);">
            <p class="display-4">No importa quien seas, MyDO está diseñado para ti</p>



        </section>
        <footer id="myFooter">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <h2 class="logo"><a href="index.jsp"> LOGO </a></h2>
                    </div>
                    <div class="col-sm-2">
                        <h5>Comenzemos</h5>
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
