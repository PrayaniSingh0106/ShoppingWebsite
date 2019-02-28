angular.module('productApp', []).controller(
		'ProductController',
		function($scope, $http) {
			$scope.accessories = [];

			$scope.loadAccessories = function() {
				$http.get('rest/getAccessories').then(
						function(response) {
							console.log("working fine");
							console.log(response);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			$scope.loadAccessories();

			$scope.loadBrandAc = function() {
				$http.post('rest/getBrandAccessories',$scope.gbreq).then(
						function(response) {
							console.log("brand working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadColorAc = function() {
				console.log($scope.gbreq.reqData);
				$http.post('rest/getColorAccessories',$scope.gbreq).then(
						function(response) {
							console.log("color working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadAcBetwnPrice = function() {
				$http.post('rest/getAcBetweenPrice',$scope.gbreq).then(
						function(response) {
							console.log("between price working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadAcAbovePrice = function() {
				$http.post('rest/getAcAbovePrice',$scope.gbreq).then(
						function(response) {
							console.log("above price working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadAcType = function() {
				$http.post('rest/getTypeAccessories',$scope.gbreq).then(
						function(response) {
							console.log("ac type working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadAcStock = function() {
				$http.get('rest/getStockedAccessories').then(
						function(response) {
							console.log("ac stock working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadAcTypeStock = function() {
				$http.post('rest/getStockedAcType',$scope.gbreq).then(
						function(response) {
							console.log("ac type stock working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadSortedAc = function() {
				$scope.gbreq.acList=$scope.accessories;
				$http.post('rest/sortAccessories',$scope.gbreq).then(
						function(response) {
							console.log("ac sort working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadSortDesAc = function() {
				$scope.gbreq.acList=$scope.accessories;
				$http.post('rest/sortDescAc',$scope.gbreq).then(
						function(response) {
							console.log("ac sort desc working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
			
			$scope.loadSortDesAc = function() {
				$scope.gbreq.acList=$scope.accessories;
				$http.post('rest/sortDescAc',$scope.gbreq).then(
						function(response) {
							console.log("ac sort desc working fine");
							console.log(response);
							$scope.accessories.splice(0);
							angular.forEach(response.data.resultData, function(
									valueObj) {
								$scope.accessories.push(valueObj);
							});
						});
			};
		});
