<%@ include file="header.jsp" %>

<div class="container mt-4">

    <h3>Forgot Password</h3>

    <form action="/forgot-password" method="post">

        <div class="form-group mb-3">
            <label>Email Address</label>
            <input type="email" name="email" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Verify Email</button>
    </form>

    <c:if test="${not empty error}">
        <p class="text-danger mt-3">${error}</p>
    </c:if>

</div>
