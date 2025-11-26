<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Bootstrap centered container -->
<div class="container mt-5" style="max-width: 480px;">

    <!-- Card -->
    <div class="card shadow">
        <div class="card-header bg-primary text-white text-center">
            <h4>Create Your Account</h4>
        </div>

        <div class="card-body">

            <!-- Global error (like email exists) -->
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <!-- DTO validation errors -->
            <c:if test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${errors}" var="err">
                            <li>${err.defaultMessage}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

            <!-- Success message -->
            <c:if test="${not empty success}">
                <div class="alert alert-success">${success}</div>
            </c:if>

            <!-- Registration Form -->
            <form action="/register" method="post">

                <!-- Username -->
                <div class="mb-3">
                    <label class="form-label">Username</label>
                    <input type="text" name="username" class="form-control" required />
                </div>

                <!-- Email -->
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" required />
                </div>

                <!-- Password -->
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" required />
                </div>

                <!-- Confirm Password -->
                <div class="mb-3">
                    <label class="form-label">Confirm Password</label>
                    <input type="password" name="confirmPassword" class="form-control" required />
                </div>

                <!-- Submit -->
                <button type="submit" class="btn btn-primary w-100">Register</button>

            </form>
        </div>
    </div>
</div>
