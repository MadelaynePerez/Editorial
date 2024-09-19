<%-- Document : newjsp Created on : 14 sept 2024, 20:58:04 Author : DELL --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Iniciar Sesión</title>
            <style>
                body {
                    background-color: #f1f3ce;
                    font-family: 'Arial', sans-serif;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 100vh;
                    margin: 0;
                }
        
                .container {
                    background-color: #00293c;
                    padding: 40px;
                    border-radius: 10px;
                    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
                    text-align: center;
                    color: #f1f3ce;
                    width: 300px;
                }
        
                h1 {
                    color: #d4af37;
                    margin-bottom: 20px;
                }
        
                h2 {
                    color: #f1f3ce;
                    margin-bottom: 30px;
                }
        
                .form-label {
                    color: #d4af37;
                    font-weight: bold;
                }
        
                .form-control {
                    width: 100%;
                    padding: 10px;
                    margin-bottom: 20px;
                    border: 1px solid #d4af37;
                    border-radius: 5px;
                    background-color: #f1f3ce;
                    color: #00293c;
                }
        
                .btn {
                    background-color: #d4af37;
                    color: #00293c;
                    padding: 10px 20px;
                    border: none;
                    border-radius: 5px;
                    cursor: pointer;
                    font-weight: bold;
                    width: 100%;
                }
        
                .btn:hover {
                    background-color: #f1f3ce;
                    color: #00293c;
                }
            </style>
        </head>
        <body>
            <div class="container">
                <h1>EDITORIAL NEXT!</h1>
                <h2>INICIAR SESIÓN</h2>
                <form action="IniciarSesionServlet" method="post">
                    <div class="mb-3">
                        <label for="Correo" class="form-label">Correo</label>
                        <input type="email" name="correo" class="form-control" id="username" placeholder="ejemplo@gmail.com" required>
                    </div>
                    <%
                    String mensaje = (String) request.getAttribute("mensaje");
                    if (mensaje != null && !mensaje.isEmpty()) {
                        out.println(mensaje);  // Mostrar mensaje solo si existe
                    }
                %>

                    <div class="mb-3">
                        <label for="Contraseña" class="form-label">Contraseña</label>
                        <input type="password" name="contrasena" class="form-control" id="password" placeholder="Contraseña" required>
                    </div>
                    <button type="submit"  class="btn">Iniciar Sesión</button>
                    
                </form>
            </div>
        </body>

        </html>