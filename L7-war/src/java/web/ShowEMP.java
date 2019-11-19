/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import beans.EMP;
import beans.EMPFacade;
import beans.EMPFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DON
 */
public class ShowEMP extends HttpServlet {

    @EJB
    public EMPFacadeLocal emp = new EMPFacade();
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
            String employee = "";
            EMP empl = null;
            try{
                empl = emp.find(Long.parseLong(request.getParameter("id")));
            } catch ( NullPointerException e){
                employee = "No employee find!";
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<link rel=\"stylesheet\" href=\"table.css\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowEMP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Employee </h1>");
            if (employee.equals("No employee find!")){
                out.println("<h2>" + employee + "</h1>");
            } else {
                out.print("<table>\n" +
    "            <thead>\n" +
    "                <tr>\n" +
    "                    <th></th>\n" +
    "                    <th>ID</th>\n" +
    "                    <th>Name</th>\n" +
    "                    <th>Department</th>\n" +
    "                    <th>Salary</th>\n" +
    "                    <th>Remove</th>\n" +
    "                </tr>\n" +
    "            </thead>\n" +
    "            <tbody>");
                out.println("                <tr>\n" +
    "                    <td data-column=\"check\"><input type=\"checkbox\"></td> \n" +
    "                    <td data-column=\"ID\">" + empl.getId() + "</td>\n" +
    "                    <td data-column=\"Name\">" + empl.getName() + "</td>\n" +
    "                    <td data-column=\"Department\">" + empl.getDept().getName() + "</td>\n" +
    "                    <td data-column=\"Salary\">" + empl.getSal() + "</td>\n" +
    "                    <td data-column=\"Delete\"><a href=\"\">Remove</a></td>\n" +
    "                </tr>");
                out.println("</tbody>\n" +
    "        </table>");
            }
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
