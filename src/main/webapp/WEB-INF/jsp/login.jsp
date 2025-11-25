<%@ include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Login</h2>

<!-- JavaScript validation -->
<script>
    function validateLogin() {

        let email = document.forms["loginForm"]["email"].value;
        let password = document.forms["loginForm"]["password"].value;

        // Email empty
        if (email.trim() === "") {
            alert("Email cannot be empty");
            return false;
        }

        // Email format validation
        let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Enter a valid email address");
            return false;
        }

        // Password empty
        if (password.trim() === "") {
            alert("Password cannot be empty");
            return false;
        }

        return true; // allow login submit
    }
</script>

<form name="loginForm" action="/login" method="post" onsubmit="return validateLogin();">

    Email: <input type="email" name="email" /><br/><br/>

    Password: <input type="password" name="password" /><br/><br/>

    <button type="submit">Login</button>
</form>
<p class="mt-3">
    <a href="/forgot-password">Forgot Password?</a>
</p>
<c:if test="${param.resetSuccess == 'true'}">
    <p class="text-success">Password reset successfully! Please login.</p>
</c:if>


<!-- Backend errors -->
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
