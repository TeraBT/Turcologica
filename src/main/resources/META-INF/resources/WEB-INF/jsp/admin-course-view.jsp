<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-admin.jspf" %>
<div class="container">
    <h1 style="background-color: red; text-align: center">COURSE ADMINISTRATION PAGE</h1>
    <h2 style="background-color: red; text-align: center">CHANGES ARE PERMANENT!!!</h2>
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
                <td> <a href="delete-course?id=${course.courseID}" class="btn btn-danger">Delete</a></td>
                <td> <a href="modify-course?id=${course.courseID}" class="btn btn-secondary">Modify</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="create-course" class="btn btn-success">Create New Course</a>
</div>

<%@ include file="common/footer.jspf" %>