<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2>Edit Profile</h2>

    <form action="/profile/update" method="post">

        <label>Username:</label>
        <input type="text" name="username" class="form-control"
               value="${user.username}" required /><br>

        <label>Email:</label>
        <input type="email" name="email" class="form-control"
               value="${user.email}" required /><br>

        <label>New Password (optional):</label>
        <input type="password" name="password" class="form-control" /><br>

        <button type="submit" class="btn btn-success">Save Changes</button>
    </form>

    <c:if test="${not empty success}">
        <p class="text-success mt-3">${success}</p>
    </c:if>
</div>
