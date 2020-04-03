var ajaxApp = angular.module("myApp", []);
ajaxApp.controller("EmployeeController", [ '$scope', '$http', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.getData = function() {
		$http({
			url : 'employeeServlet',
			method : "GET",			
		}).then(function(response) {
			if(response.data.myArrayList.length == 0) {
				$scope.noEmpRecord = "Yes";
			} else {
				$scope.empList = response.data.myArrayList;
				alert('Total Employees Are:'+response.data.myArrayList.length);
			}
		}, function(response) {
			alert('Failer Total Employees Are:'+response.data.myArrayList.length);
			$scope.empList = response.data.myArrayList;
		});
	};
} ]);

//////////////////
ajaxApp.controller("AddEmployeeController", [ '$scope', '$http', function($scope, $http) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.postData = function() {
		$http({
			url : 'addEmployeeServlet',
			method : "POST",
			data : {
                'empName' : $scope.ename,
                'empEmail': $scope.email,
                'empGender':$scope.gender
            }
		}).then(function(response) {
			 /**** Success Case ****/
			alert('Employee Added Successfully:'+response.data);
            console.log("Success -> " + response.data);
            $scope.msgFromServlet = response.data;
        }, function(response) {
            /**** Failure Case ****/
        	alert('Error in Add Employee:'+response.data);
            console.log("Failure -> " + response.data);
            $scope.msgFromServlet = response.data;
        });
	};
} ]);

