/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puser
 */
public class MyHttpServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>");
        out.println("Form");
        out.println("</TITLE></HEAD>");
        out.println("<BODY>");
        request.getRequestDispatcher("header-banner.html").include(request,response);
        out.println("<H1>Form<H1>");
        out.println("<form action=\"MyHttpServlet\" method=\"POST\">");
        out.println("<input type=\"text\" name=\"formFirstName\" placeholder=\"first name\">");
        out.println("<input type=\"text\" name=\"formLastName\" placeholder=\"last name\">");
        out.println("<input type=\"text\" name=\"formAge\" placeholder=\"age\">");
        out.println("<input type=\"submit\" name=\"Submit\">");        
        request.getRequestDispatcher("footer-banner.html").include(request,response);
        out.println("</form>");
        out.println("</BODY>");
        out.println("</HTML>");
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
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>");
        out.println("Form");
        out.println("</TITLE></HEAD>");
        out.println("<BODY>");        
        request.getRequestDispatcher("header-banner.html").include(request,response);
        out.println("<H1>Form Values</H1>");
        out.println("First name: " + request.getParameter("formFirstName")+ "<br>");
        out.println("Last name: " + request.getParameter("formLastName")+ "<br>");
        out.println("Age: " + request.getParameter("formAge"));
        request.getRequestDispatcher("footer-banner.html").include(request,response);
        out.println("</BODY>");
        out.println("</HTML>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
