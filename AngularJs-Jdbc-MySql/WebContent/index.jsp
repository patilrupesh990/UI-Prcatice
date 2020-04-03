<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>

<!-- Javascript Files -->
<script type="text/javascript" src="js/angular_v1.6.0.js"></script>
<script type="text/javascript" src="js/form.js"></script>

<!-- Bootstrap Css -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style type="text/css">
.marginTop14 {
	margin-top: 14px;
}

* {
	box-sizing: border-box;
}

.container {
	padding: 16px;
	background-color: white;
}

input[type=text] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus {
	outline: none;
	background-color: #ddd;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

form {
	margin-left: 170px;
	margin-right: 170px;
}
</style>
</head>
<body>
	<h2 align="center" class="text-primary">AngularJS MySql JDBC
		Example</h2>
	<div ng-app="myApp">
		<form ng-controller="EmployeeController" ng-submit="getData()">
			<p>
				<button id="formBtn" type="submit"
					class="btn btn-primary center-block marginTop14">Get
					Employee List</button>
			</p>
			<div id="empTblContainer" class="container" ng-show="empList.length">
				<table id="empTbl" class="table table-bordered marginTop14">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Email</th>
							<th>Gender</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="detail in empList">
							<td><span id="emp-id">{{detail.map.empId}}</span></td>
							<td><span id="emp-name">{{detail.map.empName}}</span></td>
							<td><span id="empEmail">{{detail.map.empEmail}}</span></td>
							<td><span id="emp-gender">{{detail.map.empGender}}</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div id="errorTxt" ng-show="noEmpRecord.length"
				class="text-center text-danger marginTop14">
				<h5>No record found in the database!</h5>
			</div>
		</form>
		<div class="container">
			<form ng-controller="AddEmployeeController" ng-submit="postData()">
				<p>
					<button id="addempformBtn" type="submit"
						class="btn btn-primary center-block marginTop14">Add
						Employee</button>
				</p>
				<p>Please Enter The Employee Details</p>
				<hr>

				<div align="center">
					<p>
						<label><b>Employee name:</b></label> <input id="emp_name"
							type="text" ng-model="ename" placeholder="User Name"
							onblur="this.placeholder = 'Enter Employee Name'"
							onfocus="this.placeholder = ''" />
					</p>
					<p>
						<label><b>Email:</b></label> <input id="emp_email" type="text"
							ng-model="email" placeholder="Email"
							onblur="this.placeholder = 'Enter Employee Email'"
							onfocus="this.placeholder = ''" />
					</p>
					<p>
						<label><b>Gender:</b></label> <input type="radio" id="emp_gender"
							ng-model="gender" name="gender" value="male"> <label
							for="male">Male</label> <input type="radio" id="emp_gender"
							ng-model="gender" name="gender" value="female"> <label
							for="female">Female</label> <input type="radio" id="emp_gender"
							ng-model="gender" name="gender" value="other"> <label
							for="other">Other</label>

					</p>
					<p>
						<span id="welcomeText" class="cssStyling">{{msgFromServlet}}</span>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>