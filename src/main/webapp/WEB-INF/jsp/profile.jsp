<%@ include file="header.jsp" %>

<div class="container mt-4">

    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow-sm">
                <div class="card-body">

                    <h3 class="text-center mb-4">My Profile</h3>

                    <table class="table table-bordered">
                        <tr>
                            <th>Username</th>
                            <td>${sessionScope.loggedUser.username}</td>
                        </tr>
                        <tr>
                            <th>Email</th>
                            <td>${sessionScope.loggedUser.email}</td>
                        </tr>
                    </table>

                    <div class="text-center mt-3">
                        <a href="/logout" class="btn btn-danger">Logout</a>
                    </div>

                </div>
            </div>

        </div>
    </div>

</div>
