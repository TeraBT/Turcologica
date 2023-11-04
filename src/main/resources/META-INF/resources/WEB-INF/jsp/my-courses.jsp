<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>My Courses</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Semester</th>
            <th>Name</th>
            <th>Lectured By</th>
            <th></th>
<%--            <th></th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courseList}" var="course">
            <tr>
                <td>${course.courseID}</td>
                <td>${course.coursePrefix}</td>
                <td>${course.courseName}</td>
                <td>${course.lecturer}</td>
                <td> <a href="cancel-course?id=${course.courseID}" class="btn btn-danger">Leave Course</a>   </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="book-course" class="btn btn-success">Book New Course</a>
</div>

<%@ include file="common/footer.jspf" %>