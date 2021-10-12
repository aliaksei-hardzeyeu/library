<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/st4.css"/>

</head>

<body>
<div class="content-table">
    <div class="flex-row">
        <div class="cell">
            Title
        </div>
        <div class="cell">
            Author
        </div>
        <div class="cell">
            Publ Date
        </div>
        <div class="cell">
            Amount
        </div>
        <div class="cell">
            Actions
        </div>
    </div>


    <c:forEach var="book" items="${listOfBooks}">

        <div class="flex-row">
            <div class="cell">
                <a href="<%=request.getContextPath()%>/edit_book?isbn=<c:out value='${book.ISBN}'/>"><c:out
                        value="${book.title}"/></a>
            </div>
            <div class="cell">
                <c:out value="${book.authors}"/>
            </div>
            <div class="cell">
                <c:out value="${book.publishingDate}"/>
            </div>
            <div class="cell">
                <c:out value="${book.amount}"/>
            </div>
            <div class="cell">
                <a href="<%=request.getContextPath()%>/remove_book?isbn=<c:out value='${book.ISBN}' />">Remove</a>
            </div>
        </div>
    </c:forEach>


    <form class="button-add" action="<%=request.getContextPath()%>/add_book" method="get">
        <button type="submit">Add Book</button>
    </form>
</div>


</body>

</html>
