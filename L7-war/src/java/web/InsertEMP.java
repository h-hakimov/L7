/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import beans.DEPTFacade;
import beans.DEPTFacadeLocal;
import beans.EMP;
import beans.EMPFacade;
import beans.EMPFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DON
 */
public class InsertEMP extends HttpServlet {

    @EJB
    public EMPFacadeLocal emp = new EMPFacade();
    @EJB
    public DEPTFacadeLocal dept = new DEPTFacade();
    @Resource(name = "jms/connFac")
    public ConnectionFactory factory;
    @Resource(name = "jms/myQueue")
    public Destination queue;
    
    private void sendToQueueOnInsert(String text) throws JMSException {
        Connection conn = factory.createConnection();
        try {
            Session session = conn.createSession();
            MessageProducer mp = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setStringProperty("operation", "Insert");
            message.setText(text);
            mp.send(message);
        } finally {
            conn.close();
        }
    }
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
        EMP empl = EMP.create(
                Long.parseLong(request.getParameter("id")), 
		request.getParameter("name"), 
		request.getParameter("pos"), 
		Long.parseLong(request.getParameter("manager")),
		Long.parseLong(request.getParameter("sal")),
		Long.parseLong(request.getParameter("comm")),
		dept.find(Long.parseLong(request.getParameter("dep"))));
        emp.create(empl);
        try {
            sendToQueueOnInsert(request.getParameter("id"));
        } catch (JMSException ex) {
            Logger.getLogger(InsertEMP.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertEMP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertEMP :</h1>");
            out.println("<br>");
            out.println("<h1>   Inserted value :</h1>");
            out.println("<br>");
            out.print(emp.find(Long.parseLong(request.getParameter("id"))));
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
