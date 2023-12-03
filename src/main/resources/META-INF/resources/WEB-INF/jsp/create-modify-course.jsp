<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation-admin.jspf" %>

<div class="container">

    <h1>Enter Todo Details</h1>

    <form:form method="post" modelAttribute="course">

        <fieldset class="mb-3">
            <form:label path="courseName">Course Name</form:label>
            <form:input type="text" path="courseName" required="required"/>
            <form:errors path="courseName" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="coursePrefix">Course Prefix</form:label>
            <form:input type="text" path="coursePrefix" required="required"/>
            <form:errors path="coursePrefix" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="lecturer">Lecturer</form:label>
            <form:input type="text" path="lecturer" required="required"/>
            <form:errors path="lecturer" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="courseID"/>
<%--        <form:input type="hidden" path="done"/>--%>

        <input type="submit" class="btn btn-success"/>

    </form:form>

</div>

<%@ include file="common/footer.jspf" %>


<%@ include file="common/footer.jspf" %>