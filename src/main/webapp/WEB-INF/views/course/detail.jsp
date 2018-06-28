<%@include file="../shared/header.jsp" %>
<div class="page-header">
        <h1>Course Detail: ${course.name}!</h1>
</div>
        <h2>Fees:${course.fees}</h2>        
        <div>
            <a href="/enroll" class="btn btn-success">Enroll Now</a>
        </div>
<%@include file="../shared/footer.jsp" %>