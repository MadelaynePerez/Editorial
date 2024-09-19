<%-- Document : CrearUsuario Created on : 15 sept 2024, 10:21:40 Author : DELL --%>

    <%@page import="Modelos.TipoDeUsuario" %>
        <%@page import="java.util.ArrayList" %>
            <%@page import="java.util.List" %>
                <%@page contentType="text/html" pageEncoding="UTF-8" %>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                            rel="stylesheet"
                            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                            crossorigin="anonymous">
                        <title>JSP Page</title>
                        <style>
                            body {
                                margin: 0;
                                padding: 0;
                                font-family: 'Helvetica Neue', sans-serif;
                                background-color: #F1F3CE;
                                /* Fondo amarillo claro */
                                display: flex;
                                justify-content: center;
                                align-items: flex-start;
                                /* Permitir scroll si es necesario */
                                min-height: 100vh;
                            }

                            .container {
                                background-color: #ffffff;
                                /* Fondo blanco del formulario */
                                padding: 20px;
                                border-radius: 10px;
                                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
                                max-width: 600px;
                                width: 100%;
                            }

                            h1 {
                                color: #d4af37;
                                /* Azul oscuro */
                                text-align: center;
                                margin-bottom: 15px;
                                font-size: 2rem;
                                background-color: #00293C;
                            }

                            .form-label {
                                font-size: 1.1rem;
                                color: #00293C;
                                /* Azul oscuro */
                                margin-bottom: 8px;
                                display: block;
                            }

                            .form-control {
                                width: 100%;
                                padding: 10px;
                                border: 1px solid #ced4da;
                                border-radius: 5px;
                                margin-bottom: 20px;
                                font-size: 1rem;
                            }

                            .form-select {
                                width: 100%;
                                padding: 10px;
                                border-radius: 5px;
                                border: 1px solid #ced4da;
                                margin-bottom: 20px;
                                font-size: 1rem;
                            }

                            .btn {
                                padding: 10px 30px;
                                font-size: 1.1rem;
                                color: #F1F3CE;
                                /* Texto del botón */
                                background-color: #00293C;
                                /* Fondo azul oscuro */
                                border: 2px solid #00293C;
                                border-radius: 5px;
                                cursor: pointer;
                                transition: all 0.3s ease;
                                display: block;
                                width: 100%;
                                text-align: center;
                            }

                            .btn:hover {
                                background-color: #F1F3CE;
                                /* Cambia a amarillo claro en hover */
                                color: #00293C;
                                /* Cambia a azul oscuro en hover */
                                border-color: #00293C;
                            }

                            /* Espaciado adicional entre los campos */
                            .mb-3 {
                                margin-bottom: 20px;
                            }
                        </style>
                    </head>

                    <body>
                        <div class="container">
                            <h1>CREAR USUARIO</h1>
                            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                                <% // Recuperar los datos del atributo de la solicitud 
                                String mensaje=(String) request.getAttribute("mensaje"); out.println(mensaje); %>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"
                                        aria-label="Close"></button>
                            </div>
                            <form action="CrearUsuarioServlet" method="post">
                                
                                <div class="mb-3">
                                    <label for="tipoUsuario" class="form-label">Selecciona un tipo de usuario</label>
                                    <select name="tipo" class="form-select" id="tipoUsuario"
                                        aria-label="Default select example">

                                        <% // Recuperar los datos del atributo de la solicitud 
                                        ArrayList<TipoDeUsuario>
                                            options = (ArrayList<TipoDeUsuario>) request.getAttribute("Tipo");
                                                if (options != null) {
                                                for (TipoDeUsuario option : options) {
                                                out.println("<option value=\"" + option.getIdTipoUsuario() + "\">" +
                                                    option.getTipoDeUsuario() + "</option>");
                                                }
                                                }
                                                %>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="Nombre" class="form-label">Nombre</label>
                                    <input type="text" name="nombre" class="form-control" id="Nombre"
                                        placeholder="Nombre" required>
                                </div>

                                <div class="mb-3">
                                    <label for="correo" class="form-label">Correo Electrónico</label>
                                    <input type="email" name="correo" class="form-control" id="correo"
                                        placeholder="ejemplo@gmail.com" required>
                                </div>
                                <div class="mb-3">
                                    <label for="contrasena" class="form-label">Crea una contraseña</label>
                                    <input type="password" name="contrasena" class="form-control" id="contraseña"
                                        placeholder="Contraseña" required>
                                </div>
                                <div class="mb-3">
                                    <label for="descripcion" class="form-label">Descripción</label>
                                    <input type="text" name="descripcion" class="form-control" id="descripcion"
                                        placeholder="Descripción" required>
                                </div>
                                <div class="mb-3">
                                    <label for="temas de Interes" class="form-label">Temas de interés</label>
                                    <input type="text" name="interes" class="form-control" id="temasInteres"
                                        placeholder="Temas de interés" required>
                                </div>
                                <div class="mb-3">
                                    <label for="gustos" class="form-label">Gustos</label>
                                    <input type="text" name="gustos" class="form-control" id="gustos"
                                        placeholder="Cuáles son tus gustos" required>
                                </div>
                                <div class="mb-3">
                                    <label for="hobbies" class="form-label">Hobbies</label>
                                    <input type="text" name="hobbies" class="form-control" id="hobbies"
                                        placeholder="Hobbies" required>
                                </div>
                                <button type="submit" class="btn">Crear Usuario</button>
                                 <a href="PaginaPrincipal.jsp">Ir a la pagina pricipal</a>
                            </form>
                        </div>

                        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
                            crossorigin="anonymous"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
                            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
                            crossorigin="anonymous"></script>
                    </body>

                    </html>