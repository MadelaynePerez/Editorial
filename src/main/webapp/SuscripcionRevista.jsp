<%-- 
    Document   : SuscripcionRevista
    Created on : 16 sept 2024, 6:01:47
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suscripción a Revista</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f1f3ce; /* Color de fondo claro */
                color: #00293c; /* Color del texto principal */
            }
            .container {
                max-width: 800px;
                margin: 2rem auto;
            }
            .btn-custom {
                background-color: #d4af37; /* Color dorado */
                color: #00293c; /* Color del texto del botón */
            }
            .btn-custom:hover {
                background-color: #bfa72a; /* Color dorado más oscuro en hover */
            }
            .form-label {
                color: #00293c; /* Color de las etiquetas del formulario */
            }
            .form-control {
                border: 1px solid #00293c; /* Borde de los campos del formulario */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Suscripción a Revista</h1>
            <form action="procesarSuscripcion.jsp" method="post">
                <div class="mb-3">
                    <label for="revista" class="form-label">Revista</label>
                    <select class="form-select" id="revista" name="revista" required>
                        <option value="" disabled selected>Selecciona una revista</option>
                        <!-- Aquí deberías llenar las opciones dinámicamente desde el servidor -->
                        <option value="1" data-precio="10">Revista de Tecnología</option>
                        <option value="2" data-precio="12">Revista de Ciencia</option>
                        <!-- Agregar más opciones según sea necesario -->
                    </select>
                </div>
                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción de la Revista</label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" readonly>
                </div>
                <div class="mb-3">
                    <label for="autor" class="form-label">Autor</label>
                    <input type="text" class="form-control" id="autor" name="autor" readonly>
                </div>
                <div class="mb-3">
                    <label for="categoria" class="form-label">Categoría</label>
                    <input type="text" class="form-control" id="categoria" name="categoria" readonly>
                </div>
                <div class="mb-3">
                    <label for="precio" class="form-label">Precio</label>
                    <input type="text" class="form-control" id="precio" name="precio" readonly>
                </div>
                <button type="submit" class="btn btn-custom">Suscribirse</button>
            </form>
        </div>
    </body>
</html>
