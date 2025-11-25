<%@ include file="header.jsp" %>

<div class="container mt-4">

    <h3>Reset Password</h3>

    <form action="/reset-password" method="post">

        <div class="form-group mb-3">
            <label>New Password</label>
            <input type="password" name="password" class="form-control" required>
        </div>

        <div class="form-group mb-3">
            <label>Confirm Password</label>
            <input type="password" name="confirmPassword" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-success">Reset Password</button>

    </form>

    <c:if test="${not empty error}">
        <p class="text-danger mt-3">${error}</p>
    </c:if>

</div>
