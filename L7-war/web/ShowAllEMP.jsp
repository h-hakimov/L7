<%-- 
    Document   : ShowAllEMP
    Created on : Oct 11, 2019, 11:17:48 PM
    Author     : DON
--%>

<%@page import="beans.EMP"%>
<%@page import="beans.EMPFacadeLocal"%>
<%@page import="java.util.List"%>
<%@page import="beans.EMPFacade"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="table.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function deleteRow(r){
            var i=r.parentNode.parentNode.rowIndex;
            if (confirm("Delete?")){
                document.getElementById("empl").deleteRow(i);
            } else {
                alert("Canceled");
            }
            
        }
    </script>
    <body>
        <h1>Employee list</h1>
        <%
            String lookupUrl = "java:global/L7/L7-ejb/EMPFacade";
            InitialContext ctx = new javax.naming.InitialContext();
            EMPFacadeLocal emp = (EMPFacadeLocal) ctx.lookup(lookupUrl);

            List<EMP> empl = emp.findAll();
        %>
        <table id="empl">
            <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < empl.size(); i++){
                %>
                <tr>
                    <td data-column="check"><input type="checkbox"></td> 
                    <td data-column="ID"><%= empl.get(i).getId() %></td>
                    <td data-column="Name"><%= empl.get(i).getName() %></td>
                    <td data-column="Department"><%= empl.get(i).getDept().getName() %></td>
                    <td data-column="Salary"><%= empl.get(i).getSal() %></td>
                    <td data-column="Delete"><button onclick="deleteRow(this)">Remove</a></td>
                </tr>    
                <%    } %>
            </tbody>
        </table>    
    </body>
</html>
