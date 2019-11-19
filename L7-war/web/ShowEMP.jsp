<%-- 
    Document   : ShowEMP
    Created on : Nov 15, 2019, 4:53:30 PM
    Author     : DON
--%>
<%@page import="beans.EMP"%>
<%@page import="beans.EMPFacadeLocal"%>
<%@page import="java.util.List"%>
<%@page import="beans.EMPFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="EmpNotFound.jsp"%>
<!DOCTYPE html>
<link rel="stylesheet" href="table.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show Employee</h1>
        <%
            String lookupUrl = "java:global/L7/L7-ejb/EMPFacade";
            InitialContext ctx = new javax.naming.InitialContext();
            EMPFacadeLocal emp = (EMPFacadeLocal) ctx.lookup(lookupUrl);
            EMP empl = null;
            try{
                empl = emp.find(Long.parseLong(request.getParameter("id")));
            } catch ( NullPointerException e){
            }
        %>        
                <table id="empl">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Department</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr> 
                            <td data-column="ID"><%= empl.getId() %></td>
                            <td data-column="Name"><%= empl.getName() %></td>
                            <td data-column="Department"><%= empl.getDept().getName() %></td>
                            <td data-column="Salary"><%= empl.getSal() %></td>
                        </tr>
                    </tbody>
                </table>
    </body>
</html>
