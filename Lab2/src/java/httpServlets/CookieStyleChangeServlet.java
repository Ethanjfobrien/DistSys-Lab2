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
import javax.servlet.http.Cookie;

/**
 *
 * @author puser
 */
public class CookieStyleChangeServlet extends HttpServlet {

    

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
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ex 3b</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"CookieStyleChangeServlet\" method=\"POST\">");
            request.getRequestDispatcher("style-form-contents.html").include(request, response);
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Cookie[] cookies = new Cookie[3];
        String color = getIfNotNull(request.getParameter("formColor"), "");
        cookies[0] = new Cookie("color",color);
        String bgColor = getIfNotNull(request.getParameter("formBgColor"), "");
        cookies[1] = new Cookie("bgColor", bgColor);
        String textSize = getIfNotNull(request.getParameter("formTextSize"), "");
        cookies[2] = new Cookie("textSize", textSize);
        
        for(Cookie cookie : cookies){
            response.addCookie(cookie);
        }
        response.sendRedirect("ContentServlet");
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("don't use http post to this servlet");
        }*/        
    }
    
    private static <T extends Object> T getIfNotNull(T possiblyNull, T alternateValue) {
        if(possiblyNull == null){
            return alternateValue;
        }
        else {
            return possiblyNull;
        }
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
