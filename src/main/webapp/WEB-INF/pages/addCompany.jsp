<!doctype html>
<html ng-app>
<head>
	<title>Organization Rest</title>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	<script>
		function Rest($scope, $http) {
			var data = {
				"id": "IYTYTR",
				"name": "Oliver Bakers",
				"address": "SL11EP",
				"city": "Slough",
				"country": "UK",
				"email": "contact@ob.com",
				"phone": "+447348762255",
				"employees" : [
					{
						"id" : "E1232",
						"firstName" : "Amit",
						"lastName" : "Kumar"
					},
					{
						"id" : "E1243",
						"firstName" : "Chris",
						"lastName" : "Kuehen"

					}
				]
			};
			$http.put('./company', data).
					success(function(res) {
						$scope.response = res;
					});
		}
	</script>
</head>

<body>
<h2>Organization-REST</h2>
<div ng-controller="Rest">
	<p>Adding : {
		"id": "IYTYTR",
		"name": "Oliver Bakers",
		"address": "SL11EP",
		"city": "Slough",
		"country": "UK",
		"email": "contact@ob.com",
		"phone": "+447348762255",
		"employees" : [
		{
		"id" : "E1232",
		"firstName" : "Amit",
		"lastName" : "Kumar"
		},
		{
		"id" : "E1243",
		"firstName" : "Chris",
		"lastName" : "Kuehen"

		}
		]
		}
	</p>
	<ul>
		<li>Response : {{response.status}}</li>
	</ul>
</div>
<a href="javascript: history.go(-1);">Back</a>
</body>
</html>