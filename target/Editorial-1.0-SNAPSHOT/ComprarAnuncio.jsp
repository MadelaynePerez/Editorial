<%-- Document : ComprarAnuncio Created on : 16 sept 2024, 5:13:50 Author : DELL --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Comprar Anuncio</title>
    <style>
        body {
            background-color: #f1f3ce; /* Color de fondo */
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #00293c; /* Color del texto */
        }

        .container {
            background-color: #00293c; /* Color de fondo del formulario */
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
            color: #f1f3ce; /* Color del texto dentro del contenedor */
        }

        h1 {
            color: #d4af37; /* Color dorado para el título */
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
            text-align: left;
            display: block;
            margin-bottom: 5px;
        }

        .form-select, input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #d4af37; /* Borde dorado */
            border-radius: 5px;
            background-color: #f1f3ce; /* Fondo de los campos */
            color: #00293c; /* Color del texto en los campos */
        }

        .btn {
            background-color: #d4af37; /* Color dorado para el botón */
            color: #00293c; /* Color del texto del botón */
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        .btn:hover {
            background-color: #f1f3ce; /* Cambio de color al pasar el ratón */
            color: #00293c; /* Color del texto al pasar el ratón */
            border: 1px solid #00293c;
        }

        input[type="number"]::placeholder {
            color: #00293c;
        }

        p {
            margin-bottom: 20px;
            color: #d4af37;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Comprar Anuncio</h1>
        <form action="PaginaPrincipal.jsp" method="post">
            <p>LLENA EL FORMULARIO PARA TU COMPRA</p>

            <div class="mb-3">
                <label for="tipoAnuncio" class="form-label">Tipo de Anuncio</label>
                <select class="form-select" id="tipoAnuncio" aria-label="Selecciona tu anuncio" required>
                    <option selected disabled>Selecciona tu anuncio</option>
                    <!-- Opciones aquí -->
                </select>
            </div>

            <div class="mb-3">
                <label for="Precio" class="form-label">Precio de anuncio</label>
                <select class="form-select" id="precioAnuncio" required>
                    <option selected disabled>Selecciona el precio</option>
                    <!-- Opciones aquí -->
                </select>
            </div>

            <div class="mb-3">
                <label for="Tiempo" class="form-label">Tiempo para anuncio</label>
                <select class="form-select" id="tiempoAnuncio" required>
                    <option selected disabled>Tiempos disponibles</option>
                    <!-- Opciones aquí -->
                </select>
            </div>

            <div class="mb-3">
                <label for="precioTiempo" class="form-label">Precio por tiempo</label>
                <select class="form-select" id="precioTiempo" required>
                    <option selected disabled>Selecciona el precio por tiempo</option>
                    <!-- Opciones aquí -->
                </select>
            </div>

            <div class="mb-3">
                <label for="Total">Total de compra:</label>
                <input type="number" id="totalCompra" name="totalCompra" placeholder="Q:00" required>
            </div>

            <button type="submit" class="btn">Comprar</button>
        </form>
    </div>

</body>
        </html>