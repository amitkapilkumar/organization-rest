<!doctype html>
<html ng-app>
<head>
	<title>Organization Rest</title>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	<script>
		function Rest($scope, $http) {
			$http.get('./company/QWERTY').
					success(function(data) {
						$scope.company = data;
					});
		}
	</script>
</head>

<body>
<h2>Organization-REST</h2>
<div ng-controller="Rest">
	<p>Company Details</p>
	<ul>
		<li>{{company.name}}</li>
		<li>{{company.address}}</li>
		<li>{{company.city}}</li>
		<li>{{company.country}}</li>
		<li>{{company.email}}</li>
		<li>{{company.phone}}</li>
	</ul>
</div>
<a href="javascript: history.go(-1);">Back</a>
</body>
</html>