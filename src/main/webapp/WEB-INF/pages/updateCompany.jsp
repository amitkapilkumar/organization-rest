<!doctype html>
<html ng-app>
<head>
	<title>Organization Rest</title>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	<script>
		function Rest($scope, $http) {
			var data = {
				"id": "PCVYT",
				"name": "Syne Group",
				"address": "SL14DX",
				"city": "Slough",
				"country": "UK",
				"email": "contact@ob.com",
				"phone": "+447348762255",
				"employees" : [
					{
						"id" : "E1232",
						"firstName" : "Shia",
						"lastName" : "Xin"
					},
					{
						"id" : "E1243",
						"firstName" : "Matt",
						"lastName" : "Giles"

					}
				]
			};
			$http.post('./company', data).
					success(function(res) {
						$scope.response = res;
					});
		}
	</script>
</head>

<body>
<h2>Organization-REST</h2>
<div ng-controller="Rest">
	<p>Updating : {
			"id": "PCVYT",
			"name": "Syne Group",
			"address": "SL14DX",
			"city": "Slough",
			"country": "UK",
			"email": "contact@ob.com",
			"phone": "+447348762255",
			"employees" : [
				{
					"id" : "E1232",
					"firstName" : "Shia",
					"lastName" : "Xin"
				},
				{
					"id" : "E1243",
					"firstName" : "Matt",
					"lastName" : "Giles"
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