package httpServlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author puser
 */
public class SessionStyleChangeServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setAttribute("formColor", request.getParameter("formColor"));
        session.setAttribute("formBgColor", request.getParameter("formBgColor"));
        session.setAttribute("formTextSize", request.getParameter("formTextSize"));
//        if(request.getParameter("Reset") != null){
//            response.sendRedirect("SessionStyleChangeServlet");
//        }
        String color = (String) session.getAttribute("formColor");
        color = color != null ? color : "red";
        
        String bgColor = (String) session.getAttribute("formBgColor") ;
        bgColor = bgColor != null ? bgColor : "#555";
        
        String textSize = (String) session.getAttribute("formTextSize");
        textSize = textSize != null? textSize : "14px";        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SessionStyleChangeServlet</title>");            
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
            out.println("<form action=\"SessionStyleChangeServlet\" method=\"POST\">");
            request.getRequestDispatcher("style-form-contents.html").include(request, response);
            out.println("</form>");
            out.println("<form action=\"SessionStyleChangeServlet\" method=\"POST\">");
            out.println("<input type=\"submit\" name=\"Reset\" value=\"reset\">");
            out.println("</form>");
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
