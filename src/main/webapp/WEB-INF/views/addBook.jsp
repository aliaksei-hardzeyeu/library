<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleADD.css"/>

</head>
<body>
<div class="main-container">
    <div class="cover">

    </div>
    <div class="table-values">
        table-values

        <form id="send-values" action="${pageContext.request.contextPath}/add_book" method="post" enctype="multipart/form-data">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value=""><br>

            <label for="authors">Author:</label>
            <input type="text" id="authors" name="authors" value=""><br>

            <label for="publisher">Publisher:</label>
            <input type="text" id="publisher" name="publisher" value=""><br>

            <label for="publish_date">Publication date:</label>
            <input type="date" id="publish_date" name="publish_date" value=""><br>

            <label for="genres">Genre:</label>
            <input type="text" id="genres" name="genres" value=""><br>

            <label for="page_count">Page count:</label>
            <input type="text" id="page_count" name="page_count" value=""><br>

            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value=""><br>

            <label for="description">Description:</label>
            <input type="text" id="description" name="description" value=""><br>

            <label for="tot_amount">Total amount:</label>
            <input type="number" id="tot_amount" name="tot_amount" value=""><br>

            <label for="borrows">Borrows:</label>
            <input type="number" id="borrows" name="borrows" value=""><br>

            <div>
                <label for="file">Choose a file</label>
                <input type="file" id="file" name="cover_file">
            </div>

            <%--            <input type="submit" value="Submit">--%>
        </form>
        <input type="submit" form="send-values">
        <%--        <input type="submit" form="send-img">--%>


    </div>
</div>
<div class="buttons-area">
    buttons-area
</div>
</body>
</html>
