<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Register</h2>

<!-- JavaScript validation -->
<script>
    function validateForm() {

        let username = document.forms["regForm"]["username"].value;
        let email = document.forms["regForm"]["email"].value;
        let password = document.forms["regForm"]["password"].value;
        let confirmPassword = document.forms["regForm"]["confirmPassword"].value;

        // Username validation
        if (username.trim() === "") {
            alert("Username cannot be empty");
            return false;
        }

        // Email validation (simple regex)
        let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Enter a valid email address");
            return false;
        }

        // Password length check
        if (password.length < 6) {
            alert("Password must be at least 6 characters");
            return false;
        }

        // Confirm Password match
        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return false;
        }

        return true; // allow form submit
    }
</script>

<form name="regForm" action="/register" method="post" onsubmit="return validateForm();">

    Username: <input type="text" name="username" /><br/><br/>

    Email: <input type="email" name="email" /><br/><br/>

    Password: <input type="password" name="password" /><br/><br/>

    Confirm Password: <input type="password" name="confirmPassword" /><br/><br/>

    <button type="submit">Register</button>
</form>

<!-- Show backend validation -->
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<c:if test="${not empty success}">
    <p style="color:green;">${success}</p>
</c:if>
