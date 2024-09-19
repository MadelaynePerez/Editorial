/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.editorial;

import Modelos.TipoDeUsuario;
import Modelos.Usuario;
import Querys.QueryTipoDeUsuario;
import Querys.QueryUsuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CrearUsuarioServlet", urlPatterns = {"/CrearUsuarioServlet"})
public class CrearUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Puedes pasar parámetros a tu JSP
        Querys.QueryTipoDeUsuario TipoUsuario = new QueryTipoDeUsuario();
        ArrayList<TipoDeUsuario> tiposdeUsuario = TipoUsuario.listar();
        request.setAttribute("Tipo", tiposdeUsuario);

        // Redirigir al JSP usando RequestDispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("CrearUsuario.jsp");
        dispatcher.forward(request, response);// tiene que ir en los get

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String descripcion = request.getParameter("descripcion");
        String interes = request.getParameter("interes");
        String gustos = request.getParameter("gustos");
        String hobbie = request.getParameter("hobbies");
        Querys.QueryUsuario crear = new QueryUsuario();
        String tipo = request.getParameter("tipo");
        
        Usuario entidad = new Usuario(-1L, name, contrasena, correo, hobbie, descripcion, interes, gustos, Long.parseLong(tipo), "");
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(contrasena.getBytes());

            // Convierte el hash en una cadena hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            entidad.setContrasena(sb.toString());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CrearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Querys.QueryUsuario tmp= new QueryUsuario();
        Usuario correoUno = tmp.encontrarPorCorreo(correo);
         if (correoUno != null) {
            // Si se encontró el usuario, continuamos con la solicitud
            request.setAttribute("mensaje", "El correo ya existe");
            RequestDispatcher dispatcher = request.getRequestDispatcher("InciarSesion.jsp");
            dispatcher.forward(request, response);
            return;
         }    
        boolean devolver = crear.crear(entidad);
        if (devolver) {
            request.setAttribute("mensaje", "USUARIO CREADO");
        } else {
            request.setAttribute("mensaje", "NO SE PUDO CREAR");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("CrearUsuario.jsp");
        dispatcher.forward(request, response);// tiene que ir en los get

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
