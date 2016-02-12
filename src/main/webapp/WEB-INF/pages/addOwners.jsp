<!doctype html>
<html ng-app>
<head>
	<title>Organization Rest</title>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	<script>
		function Rest($scope, $http) {
			var data = {
				"owners" : ["BitWise", "Tera Mines", "Delta group"]
			};
			$http.put('./company/QWE/owners', data).
					success(function(res) {
						$scope.response = res;
					});
		}
	</script>
</head>

<body>
<h2>Organization-REST</h2>
<div ng-controller="Rest">
	<p>Adding Owners {"owners":["BitWise", "Tera Mines", "Delta group"]}</p>
	<ul>
		<li>Response : {{response.status}}</li>
	</ul>
</div>
<a href="javascript: history.go(-1);">Back</a>
</body>
</html>