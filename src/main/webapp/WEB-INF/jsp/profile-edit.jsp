<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Bootstrap Page Wrapper -->
<div class="container mt-4" style="max-width: 600px;">

    <h2 class="mb-4 text-center">Edit Profile</h2>

    <!-- Success Message -->
    <c:if test="${not empty success}">
        <div class="alert alert-success">${success}</div>
    </c:if>

    <form action="/profile/edit" method="post">

        <!-- Username -->
        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text" name="username" class="form-control"
                   value="${user.username}" required>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" name="email" class="form-control"
                   value="${user.email}" required>
        </div>

        <!-- Password (optional) -->
        <div class="mb-3">
            <label class="form-label">New Password (optional)</label>
            <input type="password" name="password" class="form-control"
                   placeholder="Enter new password only if you want to change">
        </div>

        <!-- Submit -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary w-50">
                Update Profile
            </button>
        </div>
    </form>
</div>
