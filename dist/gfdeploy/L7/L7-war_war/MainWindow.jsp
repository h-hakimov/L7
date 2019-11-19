<%-- 
    Document   : MainWindow
    Created on : May 30, 2019, 8:01:41 AM
    Author     : DON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="Main.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Window</title>
    </head>
    <body>
        <h3>MAIN MENU</h3>
        <form action="javascript:">
            <label for="id" >Show EMP</label>
            <style>
                #error { color: lightcoral }
            </style>
            <input type = "text" id="id" name = "id" placeholder="Insert ID here..." pattern="[0-9]{1,12}" required title="Only Numbers">
            <div id="text" class="error"></div>
            <script>
                id.onfocus = function() {
                    text.innerHTML = "";
                };
                id.onblur = function() {
                    if(!id.value > 0){
                        id.classList.add("check");
                        text.innerHTML = "123, for ex.";
                    }
                };
            </script>
            <button type="submit" formaction="/L7-war/ShowEMP.jsp">Show EMP</button>
	</form>
	<form action="/L7-war/ShowAllEMP.jsp">
            <label for="all" >Show All</label>
            <button type="submit">Show All</button>
	</form>
	<form action="/L7-war/InsertEMP.html">
            <label for="insert" >Insert EMP</label>
            <button type="submit">To insert page</button>
	</form>
	<form action="javascript:">
            <label for="delete" >Delete EMP</label>
            <input type = "text" name = "id" placeholder="Insert ID here..." pattern="[0-9]{1,12}" required title="Only Numbers">
            <button type="submit" formaction="/L7-war/RemoveServlet">Remove EMP</button>
	</form>
        <form action="/L7-war/ShowLogs.jsp">
            <label for="id" >Show EMP</label>
            <button type="submit">Show Logs</button> 
       </form>
        <form action="javascript:">
            <input type="text" name = "name" id="n" placeholder="Insert name.."  pattern="[a-zA-Z]{2,64}" required title="Only chars">
            <label for="id" >EMP name</label>
            <button type="submit" formaction="/L7-war/EMPsave.html">Save</button> 
       </form>
    </body>
</html>
