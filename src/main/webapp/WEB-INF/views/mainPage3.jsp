<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style2.css"/>

</head>

<body>

    <div class="side-nav">
        <a href="#">List of books</a>
        <a href="#">Reader`s page</a>
        <a href="#">Book preview gallery</a>
    </div>
    <div class="flex-container">
    <div class="some-page-wrapper">

        <div class='row'>
            <div class='column'>
                <div class='header-column border-black'>
                    Title
                </div>
            </div>
            <div class='column'>
                <div class='header-column border-black'>
                    Author(s)
                </div>
            </div>
            <div class='column'>
                <div class='header-column border-black'>
                    Publication Date
                </div>
            </div>
            <div class='column'>
                <div class='header-column border-black'>
                    Total Amount
                </div>
            </div>
            <div class='column'>
                <div class='header-column border-black'>
                    Actions
                </div>
            </div>
        </div>
        <c:forEach var="book" items="${listOfBooks}">
        <div class='row'>
            <div class='column'>
                <div class='for-entries border-black'>
                    <a href="<%=request.getContextPath()%>/edit_book?isbn=<c:out value='${book.ISBN}'/>"><c:out
                            value="${book.title}"/></a>
                </div>
            </div>
            <div class='column'>
                <div class='for-entries border-black'>
                    <span><c:out value="${book.authors}"/></span>

                </div>
            </div>
            <div class='column'>
                <div class='for-entries border-black'>
                    <span><c:out value="${book.publishingDate}"/></span>

                </div>
            </div>
            <div class='column'>
                <div class='for-entries border-black'>
                    <span><c:out value="${book.amount}"/></span>

                </div>
            </div>
            <div class='column'>
                <div class='for-entries border-black'>
                    <a href="<%=request.getContextPath()%>/remove_book?isbn=<c:out value='${book.ISBN}' />">Remove</a>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>

<form action="<%=request.getContextPath()%>/add_book" method="get">
    <button type="submit">Add Book</button>
</form>
</body>

</html>

