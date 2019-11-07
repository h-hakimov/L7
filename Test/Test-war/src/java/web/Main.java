/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import entity.DEPTFacade;
import entity.DEPTFacadeLocal;
import entity.EMP;
import entity.EMPFacade;
import entity.EMPFacadeLocal;
import entity.SALGRADEFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import test.DataSourceTest;
import test.DataSourceTestLocal;
import entity.SALGRADEFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author DON
 */
@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    @EJB
    public SALGRADEFacadeLocal sal = new SALGRADEFacade();
    @EJB
    public EMPFacadeLocal emp = new EMPFacade();
    @EJB
    public DEPTFacadeLocal dept = new DEPTFacade();
    @Resource(name = "jms/connFac")
    public ConnectionFactory factory;
    @Resource(name = "jms/myQueue")
    public Destination queue;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void sendToQueueOnInsert(String text) throws JMSException {
        Connection conn = factory.createConnection();
        try {
            Session session = conn.createSession();
            MessageProducer mp = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText(text);
            mp.send(message);
        } finally {
            conn.close();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Main</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                out.print(DataSourceTest.getDataSource().getConnection().getMetaData().getDatabaseProductVersion());
                sendToQueueOnInsert("hello!");
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JMSException e){
                e.printStackTrace();
            }
            out.print("<br>");
            out.print(sal.find(2L).toString());
            out.print("<br>");
            EMP empl = EMP.create(1L, "Holly", "General", 5L, 5000L, 0L, dept.find(10L));
            out.print("<br>");
            out.print(empl.toString());
            out.print("<br>");
            out.print(emp.find(7939L).toString());
            out.print("<br>");
            out.println("<h1>Servlet Main at " + request.getContextPath() + "</h1>");
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
