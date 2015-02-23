/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpServlets;

import dataTypes.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puser
 */
public class UserStyleChangeServlet extends HttpServlet {

    private ArrayList<User> users = new ArrayList();

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
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String userName = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    userName = cookie.getValue();
                    break;
                }
            }
            if(userName != null ) {
                
                User currentUser = new User(userName);
                if( users.contains(currentUser) ) {
                    currentUser = users.get(users.indexOf(currentUser));
                }
                else {
                    users.add(currentUser);
                }                        
                
                currentUser.update(request);
                
                String color = currentUser.getColor() ;
                color = color != null ? color : "red";
                
                String bgColor = currentUser.getBgColor() ;
                bgColor = bgColor != null ? bgColor : "#555";

                String textSize = currentUser.getTextSize();
                textSize = textSize != null? textSize : "14px";
                
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet DefaultStyleChangeServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div style="
                            + "\"height: 500px; text-align: center; padding: 50px; "
                            + "color: "
                            + color
                            + "; background-color: "
                            + bgColor 
                            + "; font-size: "
                            + textSize
                            + ";\" >"
                            + "<p>Some arbitrary text</p>"
                            + "</div>"
                            + "<hr>");
                    out.println("<form action=\"UserStyleChangeServlet\" method=\"POST\">");
                    request.getRequestDispatcher("style-form-contents.html").include(request, response);
                    out.println("</form>");
                    out.println("<a href=\"MultipleUserLoginServlet\">back to login</a>");
                    out.println("</body>");
                    out.println("</html>");
                    return ;// servlet's job is done when document body is printed 
                }
            }
        }
        response.sendRedirect("MultipleUserLoginServlet");
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
        processRequest(request, response);
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
