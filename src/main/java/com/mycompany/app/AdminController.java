/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

@WebServlet(name = "AdminController")
@ServletSecurity( @HttpConstraint(rolesAllowed = {"admin"}) )
public class AdminController extends HttpServlet {
    OracleConnector jdbcTemplate;
    final static Logger logger = Logger.getLogger(AdminController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("private controller started");
        response.setContentType("text/html;charset=UTF-8");
        logger.debug(request.getServletPath());
        if ("/admin".equals(request.getServletPath())){
            Connection conn = (Connection) request.getSession().getAttribute("connection");
            ArrayList<User> users = OracleProtocol.getUsers(conn);
            request.setAttribute("users", users);
            request.setAttribute("name", request.getUserPrincipal().getName());
            request.getRequestDispatcher("WEB-INF/admin/admin.jsp").forward(request, response);
        }else
        if ("/logout".equals(request.getServletPath())){
            logger.debug("/logout");
            HttpSession session = request.getSession(false);
            if (session!= null){
                session.invalidate();
            }
            response.sendRedirect("admin");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
