<%-- 
    Document   : ShowLogs
    Created on : Oct 14, 2019, 3:12:29 PM
    Author     : DON
--%>

<%@page import="beans.EMP_CH"%>
<%@page import="beans.EMP_CHFacadeLocal"%>
<%@page import="java.util.List"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="table.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Logs</h1>
        <%
            String lookupUrl = "java:global/L7/L7-ejb/EMP_CHFacade";
            InitialContext ctx = new javax.naming.InitialContext();
            EMP_CHFacadeLocal emp = (EMP_CHFacadeLocal) ctx.lookup(lookupUrl);

            List<EMP_CH> empl = emp.findAll();
        %>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Operation</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < empl.size(); i++){
                %>
                <tr>
                    <td data-column="ID"><%= empl.get(i).getId() %></td>
                    <td data-column="Operation"><%= empl.get(i).getOperation() %></td>
                    <td data-column="Date"><%= empl.get(i).getDate().toString() %></td>
                </tr>    
                <%    } %>
            </tbody>
        </table>
    </body>
</html>
