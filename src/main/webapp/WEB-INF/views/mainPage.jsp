<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Library</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>

<body>

<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32">
            <use xlink:href="#bootstrap"></use>
        </svg>
        <span class="fs-4">Sidebar</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="#" class="nav-link active" aria-current="page">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#home"></use>
                </svg>
                Home
            </a>
        </li>
        <li>
            <a href="#" class="nav-link text-white">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#speedometer2"></use>
                </svg>
                Dashboard
            </a>
        </li>
        <li>
            <a href="#" class="nav-link text-white">
                <svg class="bi me-2" width="16" height="16">
                    <use xlink:href="#table"></use>
                </svg>
                Orders
            </a>
        </li>

    </ul>
    <hr>

</div>
<div class="row">
    <ul>
        <li><a href="${pageContext.request.contextPath}/">List of books</a>
        <li><a href="${pageContext.request.contextPath}/readers_page">Reader`s page</a>
        <li><a href="${pageContext.request.contextPath}/preview_gallery">Book preview gallery</a>
    </ul>

    <div class="container">
        <h3 class="text-center">List of Books</h3>
        <hr>

        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th><input type="checkbox" name="nameOfChoice" value="${book.ISBN}"></th>
                <th>Title</th>
                <th>Author</th>
                <th>Publication Date</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="book" items="${listOfBooks}">

                <tr style="transform: rotate(0)">
                    <td><input type="checkbox" name="nameOfChoice" value="${book.ISBN}"></td>
                    <td>&nbsp&nbsp<c:out value="${book.title}"/></td>
                    <td><c:out value="${book.authors}"/></td>
                    <td><c:out value="${book.publishingDate}"/></td>
                    <td><c:out value="${book.amount}"/></td>

                    <td>
                        <a href="<%=request.getContextPath()%>/edit_book?isbn=<c:out value='${book.ISBN}' />">Edit</a>

                        &nbsp;&nbsp;&nbsp;&nbsp;

                        <a href="<%=request.getContextPath()%>/remove_book?isbn=<c:out value='${book.ISBN}' />">Remove</a>

                    </td>


                        <%--                      <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>--%>
                        <%--                              <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="container text-danger">
            <a href="<%=request.getContextPath()%>/add_new_book"
               class="btn btn-success">Add Book</a>
        </div>
        <br>
        <div class="container text-danger">
            <a href="<%=request.getContextPath()%>/remove_book"
               class="btn btn-success">Remove Book</a>
        </div>


    </div>
</div>
<div class="example-wrap">
    <h4 class="example-title">Condensed Table</h4>
    <p>Add<code>.table-condensed</code>to make tables more compact by
        cutting cell padding in half.</p>
    <div class="example table-responsive">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Invoice</th>
                <th>Username</th>
                <th>Amount</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><a href="javascript:void(0)">Order #53451</a></td>
                <td>Mary Adams</td>
                <td>$24.98</td>
                <td>2015/7/26</td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)">Order #53452</a></td>
                <td>Caleb Richards</td>
                <td>$564.00</td>
                <td>2015/7/15</td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)">Order #53453</a></td>
                <td>June Lane</td>
                <td>$58.87</td>
                <td>2015/7/01</td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)">Order #53454</a></td>
                <td>Crystal Bates</td>
                <td>$97.50</td>
                <td>2015/6/26</td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)">Order #53455</a></td>
                <td>Heather Harper</td>
                <td>$249.99</td>
                <td>2015/6/09</td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)">Order #53456</a></td>
                <td>Willard Wood</td>
                <td>$24.98</td>
                <td>2015/6/01</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ"
        crossorigin="anonymous"></script>
</body>

</html>
