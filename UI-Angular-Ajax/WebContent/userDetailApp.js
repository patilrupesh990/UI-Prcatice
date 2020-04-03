var user=angular.module('userApp',[]);
user.controller('usercontroller',
		function($scope,$http) {
			var file="user.json";
			$http.get(file).success(function(response){
				$scope.users=response;
			});
		}
		
);