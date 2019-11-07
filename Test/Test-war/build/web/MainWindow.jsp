<%-- 
    Document   : Main
    Created on : May 24, 2019, 7:50:28 PM
    Author     : DON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Window</title>
    </head>
    <body>
        <br>
	Show EMP
	<form action="/Test-war/ShowEMP">
		ID = <input type = "text" name = "id">
    	<button type="submit">Show EMP</button>
	</form>
	<br>
	Show All
	<form action="/Test-war/ShowAllEMP">
    	<button type="submit">Show All</button>
	</form>
	<br>
	Insert EMP
	<form action="/Test-war/InsertEMP">
		ID = <input type = "text" name = "id">
		Name = <input type = "text" name = "name">
		Position = <input type = "text" name = "pos">
		Manager ID = <input type = "text" name = "manager">
		Salary = <input type = "text" name = "sal">
		Comm. = <input type = "text" name = "comm">
		Department = <input type = "text" name = "dep">
    	<button type="submit">Insert EMP</button>
	</form>
	<br>
	Delete
	<form action="/Test-war/RemoveServlet">
		ID = <input type = "text" name = "id">
    	<button type="submit">Delete EMP</button>
	</form>
        <br>
        Show Logs
        <form action="/Test-war/ShowLogs">
            <button type="submit">Show Logs</button>
        </form>
    </body>
</html>
