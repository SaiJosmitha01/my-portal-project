<%@ include file="header.jsp" %>

<div class="container mt-4">

    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow-sm">
                <div class="card-body">

                    <h3 class="mb-4">Dashboard</h3>

                    <p>Welcome, <strong>${sessionScope.loggedUser.username}</strong>!</p>

                    <p>This is your dashboard. From here you can access:</p>

                    <ul>
                        <li>Your Profile</li>
                        <li>Update Account Information</li>
                        <li>View Tasks (future feature)</li>
                        <li>Claims / SOAP integration (future feature)</li>
                    </ul>

                </div>
            </div>

        </div>
    </div>

</div>
