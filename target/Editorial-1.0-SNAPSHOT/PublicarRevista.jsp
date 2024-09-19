<%-- 
    Document   : PublicarRevista
    Created on : 16 sept 2024, 5:53:52
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <<title>Publicar Revista</title>
        <style>
            body {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: #00293c;
            color: #00293c;
            font-family: Arial, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-publicar {
            background-color: #f1f3ce;
            padding: 35px;
            border-radius: 10px;
            border: 2px solid #00293c;
            width: 100%;
            max-width: 500px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
            margin: 0 auto;
        }

        h1 {
            text-align: center;
            color: #00293c;
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
            margin-bottom: 5px;
            color: #00293c;
        }

        .form-control, .form-select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #00293c;
            border-radius: 5px;
            background-color: #ffffff;
        }

        .form-check {
            margin-bottom: 15px;
        }

        .form-check-label {
            margin-left: 5px;
            color: #00293c;
        }

        .btn {
            background-color: #d4af37;
            color: #00293c;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #c19a36;
        }
        </style>
    </head>
    <body>
        <div class="container-form">
            <form class="form-publicar" action="SubirRevistaServlet" method="post" enctype="multipart/form-data">
                <h1>Publicar Revista</h1>
                
                <label for="nombreRevista" class="form-label">Nombre de la Revista</label>
                <input type="text" class="form-control" id="nombreRevista" name="nombreRevista" placeholder="Nombre de la Revista" required>
    
                <label for="categoria" class="form-label">Categoría</label>
                <select class="form-select" id="categoria" name="categoria" required>
                    <option selected>Selecciona la Categoría</option>
                    <option value="cultura">Cultura</option>
                    <option value="tecnologia">Tecnología</option>
                    <option value="deportes">Deportes</option>
                    <option value="moda">Moda</option>
                </select>
    
                <label for="autor" class="form-label">Autor</label>
                <input type="text" class="form-control" id="autor" name="autor" placeholder="Nombre del Autor" required>
    
                <label for="fecha" class="form-label">Fecha de Creación</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
    
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" placeholder="Descripción de la Revista" required></textarea>
    
                <label for="archivoRevista" class="form-label">Subir Revista (PDF)</label>
                <input type="file" class="form-control" id="archivoRevista" name="archivoRevista" accept=".pdf" required>
    
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="aceptarComentarios" name="aceptarComentarios">
                    <label class="form-check-label" for="aceptarComentarios">Aceptar Comentarios</label>
                </div>
    
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="aceptarMeGusta" name="aceptarMeGusta">
                    <label class="form-check-label" for="aceptarMeGusta">Aceptar Me Gusta</label>
                </div>
    
                <button type="submit" class="btn">Publicar Revista</button>
            </form>
        </div>
    </body>
</html>
