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
public class ContentServlet extends HttpServlet {
    
    
    private String color;
    private String bgColor;
    private String textSize;

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
        Cookie[] cookies = request.getCookies();
        if( cookies != null ) {
            for(Cookie cookie : cookies) {
                assignMemberOnCookieMatch(cookie);
            }
        }
        else {
            color = "red";
            bgColor = "#555";
            textSize = "14px";
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DefaultStyleChangeServlet</title>");            
            out.println("</head>");
            out.println("<body style="
                    + "\"height: 500px; text-align: center; padding: 50px; "
                    + "color: "
                    + color
                    + "; background-color: "
                    + bgColor 
                    + "; font-size: "
                    + textSize
                    + ";\" >"
                    + "<p>Some arbitrary text</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void assignMemberOnCookieMatch(Cookie cookie) {
        switch(cookie.getName()) {
            case "color":
                color = cookie.getValue();
                break;
            case "bgColor":
                bgColor = cookie.getValue();
                break;
            case "textSize":
                textSize = cookie.getValue();
                break;
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("don't use http post to this servlet");
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
