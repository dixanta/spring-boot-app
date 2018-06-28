<%@include file="../shared/header.jsp" %>
<div class="page-header">
        <h1>Enroll-Now!</h1>
</div>
<form action="/enroll" method="post">
    <div class="form-group">
        <label>First Name</label>
        <input type="text" name="firstName" class="form-control" required="required"/>
    </div>
    <div class="form-group">
        <label>Last Name</label>
        <input type="text" name="lastName" class="form-control" required="required"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" class="form-control" required="required"/>
    </div>
    
    <div class="form-group">
        <label>Contact No</label>
        <input type="text" name="contactNo" class="form-control" required="required"/>
    </div>
    <div class="form-group">
        <label>Interested Course</label>
        <select name="course.id" class="form-control" required="required">
            <option value="">Select Course</option>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Enroll</button>
</form>      
<%@include file="../shared/footer.jsp" %>