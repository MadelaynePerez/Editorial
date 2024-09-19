<%-- Document : PaginPrincipal Created on : 16 sept 2024, 3:42:15 Author : DELL --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                crossorigin="anonymous">
                <title>Página Principal</title>
                <style>
                    body {
                        background-color: #f1f3ce;
                        color: #00293c;
                        font-family: 'Arial', sans-serif;
                        padding: 0;
                        margin: 0;
                    }
            
                    header {
                        background-color: #00293c;
                        padding: 10px;
                        text-align: center;
                    }
            
                    header h1 {
                        color: #d4af37;
                    }
            
                    nav {
                        display: flex;
                        justify-content: space-around;
                        background-color: #00293c;
                        padding: 15px;
                    }
            
                    nav a {
                        color: #d4af37;
                        text-decoration: none;
                        font-size: 18px;
                        padding: 10px 20px;
                    }
            
                    nav a:hover {
                        background-color: #d4af37;
                        color: #00293c;
                        border-radius: 5px;
                    }
            
                    .content {
                        display: flex;
                        justify-content: space-between;
                        padding: 20px;
                    }
            
                    .main-content {
                        flex: 1;
                        background-color: #00293c;
                        color: #f1f3ce;
                        padding: 20px;
                        border-radius: 10px;
                        min-height: 500px; /* Ajusta la altura del contenedor */
                    }
            
                    .sidebar {
                        width: 200px;
                        background-color: #d4af37;
                        padding: 20px;
                        border-radius: 10px;
                    }
            
                    .search-container {
                        margin-bottom: 20px;
                    }
            
                    input[type="search"] {
                        width: 80%;
                        padding: 10px;
                        font-size: 18px;
                        border: 2px solid #d4af37;
                        border-radius: 5px;
                        margin-bottom: 10px;
                    }
            
                    .btn {
                        background-color: #d4af37;
                        color: #00293c;
                        padding: 10px 20px;
                        font-size: 18px;
                        border: none;
                        border-radius: 5px;
                        cursor: pointer;
                    }
            
                    .btn:hover {
                        background-color: #b68c2e;
                    }
            
                    .revistas-container {
                        margin-top: 20px;
                    }
            
                    .revista-item {
                        background-color: #f1f3ce;
                        color: #00293c;
                        border: 1px solid #d4af37;
                        border-radius: 10px;
                        padding: 10px;
                        margin-bottom: 10px;
                    }
            
                    .revista-item h3 {
                        margin: 0;
                    }
            
                    .revista-item button {
                        background-color: #d4af37;
                        color: #00293c;
                        border: none;
                        padding: 5px 10px;
                        border-radius: 5px;
                        cursor: pointer;
                    }
            
                    .revista-item button:hover {
                        background-color: #b68c2e;
                    }
                </style>
            </head>
            <body>
            
                <!-- Encabezado -->
                <header>
                    <h1>Bienvenido a la Plataforma de Revistas</h1>
                </header>
            
                <!-- Navegación principal -->
                <nav>
                    <a href="paginaPrincipal.jsp">Inicio</a>
                    <a href="publicarRevista.jsp">Publicar Revista</a>
                    <a href="comprarAnuncio.jsp">Comprar Anuncio</a>
                    <a href="verCartera.jsp">Ver Cartera Digital</a>
                    <a href="index.html">Cerrar Sesión</a>
                </nav>
            
                <!-- Contenedor principal -->
                <div class="content">
                    
                    <!-- Contenido central -->
                    <div class="main-content">
                        <!-- Contenedor de búsqueda integrado -->
                        <div class="search-container">
                            <h2>Buscar Revista</h2>
                            <form action="buscarRevistas.jsp" method="post">
                                <input type="search" id="busqueda" name="busqueda" list="sugerencias" placeholder="Buscar revistas...">
                                <datalist id="sugerencias">
                                    <option value="Revista Tecnología">
                                    <option value="Revista de Ciencia">
                                    <option value="Revista Literaria">
                                    <option value="Revista de Arte">
                                    <option value="Revista de Deportes">
                                </datalist>
                                <button type="submit" class="btn">Buscar</button>
                            </form>
                        </div>
            
                        <!-- Contenedor de revistas -->
                        <div class="revistas-container">
                            <h2>Revistas Disponibles</h2>
                            <div class="revista-item">
                                <h3>Revista Tecnología</h3>
                                <p>Descripción de la revista sobre tecnología.</p>
                                <button onclick="location.href='suscripcionRevista.jsp?revista=Tecnología'">Suscribirse</button>
                            </div>
                            <div class="revista-item">
                                <h3>Revista de Ciencia</h3>
                                <p>Descripción de la revista sobre ciencia.</p>
                                <button onclick="location.href='suscripcionRevista.jsp?revista=Ciencia'">Suscribirse</button>
                            </div>
                            <!-- Agrega más revistas aquí -->
                        </div>
                    </div>
            
                    <!-- Barra lateral de anuncios -->
                    <div class="sidebar">
                        <!-- Aquí irán tus anuncios laterales -->
                        <h3>Publicidad</h3>
                        <p>Espacio reservado para tus anuncios.</p>
                        
                    </div>
                </div>
            
            </body>
            </html>