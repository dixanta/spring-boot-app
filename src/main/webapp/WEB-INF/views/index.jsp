<%@include file="shared/header.jsp" %>
<div class="page-header">
        <h1>Available Courses!</h1>
</div>

<c:forEach var="course" items="${courses}">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h2>
                <a href="/course/detail/${course.id}"> ${course.name}</a>
            </h2>
        </div>
    </div>
</c:forEach>

<%@include file="shared/footer.jsp" %>
