var myApp = angular.module("myApp", [ 'ngRoute', 'ngAnimate', 'ngMaterial',
		'ngMessages', 'ngStorage' ]);

myApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'web-main/pages/main.html',
		controller : 'mainCon'
	})

	.when('/phones', {
		templateUrl : 'web-main/pages/phones.html',
		controller : 'phonesCon'
	})

	.when('/tablets', {
		templateUrl : 'web-main/pages/tablets.html',
		controller : 'tabletsCon'
	})

	.when('/accessories', {
		templateUrl : 'web-main/pages/accessories.html',
		controller : 'accessoriesCon'
	})

	.when('/laptops', {
		templateUrl : 'web-main/pages/laptops.html',
		controller : 'laptopsCon'
	})

	.when('/cart', {
		templateUrl : 'web-main/pages/cart.html',
		controller : 'secCon'
	})

	.when('/termsofuse', {
		templateUrl : 'web-main/pages/termsofuse.html',
		controller : 'termsofuseCon'
	})

	.when('/privacypolicy', {
		templateUrl : 'web-main/pages/privacypolicy.html',
		controller : 'privacyCon'
	})

	.when('/login', {
		templateUrl : 'web-main/pages/login.html',
		controller : 'loginCon'
	})

	.when('/security', {
		templateUrl : 'web-main/pages/security.html',
		controller : 'securityCon'
	})

	.when('/about', {
		templateUrl : 'web-main/pages/about.html',
		controller : 'aboutCon'
	})

	.when('/shipping', {
		templateUrl : 'web-main/pages/shipping.html',
		controller : 'shippingCon'
	})

	.when('/contact', {
		templateUrl : 'web-main/pages/contact.html',
		controller : 'contactCon'
	})

	.when('/faq', {
		templateUrl : 'web-main/pages/faq.html',
		controller : 'faqCon'
	})

	.when('/success', {
		templateUrl : 'web-main/pages/success.html',
		controller : 'sucCon'
	}).when('/checkout', {
		templateUrl : 'web-main/pages/checkout.html',
		controller : 'checkoutCon'
	})

	.otherwise({
		redirectTo : '/'
	});
});

myApp.controller('phonesCon', [ '$scope', '$location', '$log',
		function($scope, $location, $log) {
			$log.info("phonesCon");
		} ]);
myApp.controller('checkoutCon', [ '$scope', '$location', '$log',
                        		function($scope, $location, $log) {
                        			$log.info("checkoutCon");
                        		} ]);
myApp.controller('faqCon', [ '$scope', '$location', '$log',
                        		function($scope, $location, $log) {
                        			$log.info("faqCon");
                        		} ]);
myApp.controller('sucCon', [ '$scope', '$location', '$log',
                        		function($scope, $location, $log) {
                        			$log.info("sucCon");
                        		} ]);
myApp.controller('tabletsCon', [ '$scope', '$location', '$log',
		function($scope, $location, $log) {
			$log.info("tabletsCon");
		} ]);
myApp.controller('accessoriesCon', [ '$scope', '$location', '$log',
		function($scope, $location, $log) {
			$log.info("accessoriesCon");
		} ]);
myApp.controller('laptopsCon', [ '$scope', '$location', '$log',
		function($scope, $location, $log) {
			$log.info("laptopsCon");
		} ]);
myApp.controller('mainCon', [ '$scope', '$location', '$log',
		function($scope, $location, $log) {
			$log.info("asdsd");
		} ]);

myApp
		.controller(
				'indexCon',
				[
						'$scope',
						'$location',
						'$log',
						'$window',
						'$http',
						'$localStorage', 
						function($scope, $location, $log, $window, $http, $localStorage) {
							$log.info("second");
							$scope.cart = [];
							$scope.wish = [];
							$scope.names = [];
							$scope.Wnames = [];
							$scope.nms = [ "Phones", "Tablets", "Accessories",
									"Laptops" ];

							// Implementing Accessories
							$scope.accessories = [];
							$scope.acBrands = [];
							$scope.acTypes = [];
							
							$scope.loadAccessories = function() {
								$http
										.get('rest/getAccessories')
										.then(
												function(response) {
													console
															.log("working fine:: Accessories");
													console.log(response);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		$scope.accessories
																				.push(valueObj);
																	});
												});
							};
							$scope.loadAccessories();
							
							$scope.loadAcBrands = function() {
								$http.get('rest/getAcBrands')
										.then(function(response) {
													console.log("working fine:: Accessories Brands");
													console.log(response.data.resultData);
													angular.forEach(response.data.resultData,
																	function(valueObj) {
																		console.log(valueObj);
																		$scope.acBrands.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadAcBrands();
							
							$scope.loadAcTypes = function() {
								$http.get('rest/getAcTypes')
										.then(function(response) {
													console.log("working fine:: Accessory Types");
													console.log(response.data.resultData);
													angular.forEach(response.data.resultData,
																	function(valueObj) {
																		console.log(valueObj);
																		$scope.acTypes.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadAcTypes();


							// Implementing Laptop
							$scope.laptops = [];
							$scope.lBrands = [];
							$scope.lColor = [];
							$scope.lOpsys = [];

							$scope.loadLaptops = function() {
								$http
										.get('rest/getLaptops')
										.then(
												function(response) {
													console
															.log("working fine:: Laptops");
													console.log(response);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		$scope.laptops
																				.push(valueObj);
																	});
												});
							};
							$scope.loadLaptops();
							
							$scope.loadLBrands = function() {
								$http
										.get('rest/getLBrands')
										.then(
												function(response) {
													console
															.log("working fine:: Laptop Brands");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.lBrands
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadLBrands();
							
							$scope.loadLColor = function() {
								$http
										.get('rest/getLColor')
										.then(
												function(response) {
													console
															.log("working fine:: Laptop Color");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.lColor
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadLColor();
							
							$scope.loadLOpsys = function() {
								$http
										.get('rest/getLOpsys')
										.then(
												function(response) {
													console
															.log("working fine:: Laptop Opsys");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.lOpsys
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadLOpsys();

							// Implementing Mobile
							$scope.mobiles = [];
							$scope.phBrands = [];
							$scope.phOps = [];
							$scope.phColors = [];

							$scope.loadMobiles = function() {
								$http
										.get('rest/getPhones')
										.then(
												function(response) {
													console
															.log("working fine:: Mobiles");
													console.log(response);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		$scope.mobiles
																				.push(valueObj);
																	});
												});
							};
							$scope.loadMobiles();

							$scope.loadMobBrands = function() {
								$http
										.get('rest/getPhBrands')
										.then(
												function(response) {
													console
															.log("working fine:: Mobile Brands");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.phBrands
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadMobBrands();
						
							$scope.loadMobOps = function() {
								$http.get('rest/getPhOps')
										.then(function(response) {
													console.log("working fine:: Mobile Ops");
													console.log(response.data.resultData);
													angular.forEach(response.data.resultData,
																	function(valueObj) {
																		console.log(valueObj)
																		$scope.phOps.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadMobOps();

							$scope.loadMobColors = function() {
								$http.get('rest/getPhColors')
										.then(function(response) {
													console.log("working fine:: Mobile Colors");
													console.log(response.data.resultData);
													angular.forEach(response.data.resultData,
																	function(valueObj) {
																		console.log(valueObj)
																		$scope.phColors.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadMobColors();

							// Implementing Tablets
							$scope.tabs = [];
							$scope.tBrands = [];
							$scope.tColor = [];
							$scope.tOpsys = [];

							$scope.loadTablets = function() {
								$http
										.get('rest/getTablets')
										.then(
												function(response) {
													console
															.log("working fine:: Tablets");
													console.log(response);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		$scope.tabs
																				.push(valueObj);
																	});
												});
							};
							$scope.loadTablets();
							
							$scope.loadTBrands = function() {
								$http
										.get('rest/getTBrands')
										.then(
												function(response) {
													console
															.log("working fine:: Tablet Brands");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.tBrands
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadTBrands();
							
							$scope.loadTColor = function() {
								$http
										.get('rest/getTColor')
										.then(
												function(response) {
													console
															.log("working fine:: Tablet Color");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.tColor
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadTColor();
							
							$scope.loadTOpsys = function() {
								$http
										.get('rest/getTOpsys')
										.then(
												function(response) {
													console
															.log("working fine:: Tablet Opsys");
													console
															.log(response.data.resultData);
													angular
															.forEach(
																	response.data.resultData,
																	function(
																			valueObj) {
																		console
																				.log(valueObj)
																		/* $scope.phBrands.push(valueObj); */
																		$scope.tOpsys
																				.push({
																					text : valueObj,
																					done : false
																				});
																	});
												});
							};
							$scope.loadTOpsys();

							// FUNCTION TO ADD A SUBSTANCE INTO THE CART
							$scope.addCart = function(i,nm, offc, qty,stk, img) {

								var obj = {
									id : i,
									name : nm,
									price : offc,
									quantity : qty,
									stock : stk,
									frontimage : img
								};
								if(qty<=obj.stock)
								{
										if ($scope.names.indexOf(nm) === -1) {
										$scope.names.push(nm);
										$scope.cart.push(obj);
										$localStorage.cart =$scope.cart;
										$window.alert('Item ' + nm
												+ ' is added to your Cart');
									} else {
										$window
												.alert('this Item is already in your cart!');
									}
								}
								else
								{
									if(obj.stock==0)
									{
										$window.alert('Sorry! Out of Stock');
									}
									else
									{
										$window.alert('Sorry! Only '+obj.stock+' items left.');
									}
								}
								
							};

							// FUNCTION TO ADD AN ITEM INTO WISHLIST
							$scope.addWish = function(i,Name, ofcct, quan, imag) {
								var l = {
									id: i,
									name : Name,
									price : ofcct,
									quantity : quan,
									stock : stk,
									frontimage : imag
								};
								if ($scope.Wnames.indexOf(Name) === -1) {
									$scope.Wnames.push(Name);
									$scope.wish.push(l);
									$window.alert('Item ' + Name
											+ ' is added to your WishList');
								} else {
									$window
											.alert('this Item is already in your Wishlist!');
								}
							};

							// FUNCTION TO REMOVE AN ITEM FROM WISHLIST
							$scope.removeWish = function($index) {
								$scope.wish.splice($index, 1);
								$scope.Wnames.splice($index, 1);
							};

							// FUNCTION TO REMOVE AN ITEM FROM CART
							$scope.removeCart = function($index) {
								$scope.cart.splice($index, 1);
								$scope.names.splice($index, 1);
							};

							// FUNCTION TO ADD WISHLIST ITEM INTO CART
							$scope.wishtocart = function(i,celname, ofc, qty,stk,
									img, $index) {
								var obj = {
									id : i,
									name : celname,
									price : ofc,
									quantity : qty,
									stock : stk,
									frontimage : img
								};
								if(qty<=obj.stock)
								{
									if ($scope.names.indexOf(celname) === -1) {
										$scope.names.push(celname);
										$scope.cart.push(obj);
										$window.alert('Item ' + celname
												+ ' is added to your Cart');
										$scope.wish.splice($index, 1);
									} else {
										$window
												.alert('this Item is already in your cart!');
									}
								}
								else
								{
									if(obj.stock==0)
									{
										$window.alert('Sorry! Out of Stock');
									}
									else
									{
										$window.alert('Sorry! Only '+obj.stock+' items left.');
									}
								}
								
							};

							// FUNCTION TO CALCULATE THE TOTAL OF THE ALL
							// MOBILES
							$scope.total = function(cart) {
								var ofct = 0;
								for ( var i = 0; i < cart.length; i++) {
									var z = cart[i].quantity * cart[i].price;

									ofct = ofct + z;
								}
								;
								return ofct;
							};

							$scope.funcMob = function(ab) {
								$scope.id=ab.id;
								$scope.name = ab.name;
								$scope.image = ab.image;
								$scope.image1 = ab.image1;
								$scope.image2 = ab.image2;
								$scope.image3 = ab.image3;
								$scope.starrating = ab.starrating;
								$scope.frontimage = ab.frontimage;
								$scope.price = ab.price;
								$scope.l1 = ab.l1;
								$scope.l2 = ab.l2;
								$scope.l3 = ab.l3;
								$scope.l4 = ab.l4;
								$scope.stock = ab.stock;
								$scope.color = ab.color;
							};
							
							   
					            $scope.getCart = function () {
					               $scope.cart=$localStorage.cart;
							   };
							   $scope.getCart();

							$scope.run = function() {
								$scope.co=[];
								console.log("running..");
								angular.forEach($scope.cart,function(val){
									$scope.c={};
									$scope.c.id=val.id;
									$scope.c.qty=val.quantity;
									console.log($scope.c);
									$scope.co.push($scope.c);
									console.log($scope.co);
								});
								$http.post('rest/updateStock',$scope.co)
								.then(function(response){
									console.log("working fine:: update stock");
									console.log(response);
								});
								$scope.cart = [];
								$window.location.href='#/success';
							};

							var imgSlider = new SimpleSlider(document
									.getElementById('myslider'));
						} 
						]);

						//Sending cart


//Filters for phones

myApp.filter('myfilterb', function() {
	return function(mobiles, brands) {
		var filtered = [];
		var count = 0;
		angular.forEach(brands, function(brand) {

			if (brand.done == true) {
				angular.forEach(mobiles, function(mob) {
					if (mob.brand == brand.text)
						filtered.push(mob);

				});
			} else {
				count++;
			}
		});

		if (brands.length == count) {
			filtered = mobiles;
		}
		return filtered;
	};
});
myApp.filter('myfiltero', function() {
	return function(mobiles, ops) {
		var filtered = [];
		var count = 0;
		angular.forEach(ops, function(os) {

			if (os.done == true) {
				angular.forEach(mobiles, function(mob) {
					if (mob.opSys == os.text)
						filtered.push(mob);

				});
			} else {
				count++;
			}
		});

		if (ops.length == count) {
			filtered = mobiles;
		}

		return filtered;
	};
});
myApp.filter('myfilterc', function() {
	return function(mobiles, colors) {
		var filtered = [];
		var count = 0;
		angular.forEach(colors, function(cl) {

			if (cl.done == true) {
				angular.forEach(mobiles, function(mob) {
					if (mob.color == cl.text)
						filtered.push(mob);

				});
			} else {
				count++;
			}
		});

		if (colors.length == count) {
			filtered = mobiles;
		}
		
		return filtered;
	};
});


// Filters for laptops

myApp.filter('lafilterb', function() {
	return function(laptops, brands) {
		var filtered = [];
		var count = 0;
		angular.forEach(brands, function(brand) {

			if (brand.done == true) {
				angular.forEach(laptops, function(lap) {
					if (lap.brand == brand.text)
						filtered.push(lap);

				});
			}
			else {
				count++;
			}
		});

		if(brands.length==count) {
			filtered=laptops;
		}
		return filtered;
	};
});
myApp.filter('lafiltero', function() {
	return function(laptops, ops) {
		var filtered = [];
		var count = 0;
		angular.forEach(ops, function(op) {

			if (op.done == true) {
				angular.forEach(laptops, function(lap) {
					if (lap.opSys == op.text)
						filtered.push(lap);

				});
			}
			else {
				count++;
			}
		});

		if(ops.length==count) {
			filtered=laptops;
		}
		return filtered;
	};
});

myApp.filter('lafilterc', function() {
	return function(laptops, colors) {
		var filtered = [];
		var count = 0;
		angular.forEach(colors, function(color) {

			if (color.done == true) {
				angular.forEach(laptops, function(lap) {
					if (lap.color == color.text)
						filtered.push(lap);

				});
			}
			else {
				count++;
			}
		});

		if(colors.length==count) {
			filtered=laptops;
		}
		return filtered;
	};
});

//Filters for tablets

myApp.filter('tafilterb', function() {
	return function(tabs, brands) {
		var filtered = [];
		var count = 0;
		angular.forEach(brands, function(brand) {

			if (brand.done == true) {
				angular.forEach(tabs, function(t) {
					if (t.brand == brand.text)
						filtered.push(t);

				});
			}
			else {
				count++;
			}
		});

		if(brands.length==count) {
			filtered=tabs;
		}
		return filtered;
	};
});
myApp.filter('tafiltero', function() {
	return function(tabs, ops) {
		var filtered = [];
		var count = 0;
		angular.forEach(ops, function(op) {

			if (op.done == true) {
				angular.forEach(tabs, function(t) {
					if (t.opSys == op.text)
						filtered.push(t);

				});
			}
			else {
				count++;
			}
		});

		if(ops.length==count) {
			filtered=tabs;
		}
		return filtered;
	};
});

myApp.filter('tafilterc', function() {
	return function(tabs, colors) {
		var filtered = [];
		var count = 0;
		angular.forEach(colors, function(color) {

			if (color.done == true) {
				angular.forEach(tabs, function(t) {
					if (t.color == color.text)
						filtered.push(t);

				});
			}
			else {
				count++;
			}
		});

		if(colors.length==count) {
			filtered=tabs;
		}
		return filtered;
	};
});

//Filters for accessories

myApp.filter('acfiltert', function() {
	return function(accessories, types) {
		var filtered = [];
		var count = 0;
		angular.forEach(types, function(typ) {

			if (typ.done == true) {
				angular.forEach(accessories, function(mob) {
					if (mob.item_type == typ.text)
						filtered.push(mob);

				});
			} else {
				count++;
			}
		});

		if (types.length == count) {
			filtered = accessories;
		}
		return filtered;
	};
});

myApp.filter('acfilterb', function() {
	return function(accessories, brands) {
		var filtered = [];
		var count = 0;
		angular.forEach(brands, function(br) {

			if (br.done == true) {
				angular.forEach(accessories, function(mob) {
					if (mob.brand == br.text)
						filtered.push(mob);

				});
			} else {
				count++;
			}
		});

		if (brands.length == count) {
			filtered = accessories;
		}
		return filtered;
	};
});


myApp.filter('myfilterp', function() {
	return function(items, types) {
		var filtered = [];
		angular.forEach(items, function(item) {

			if (types == 1) {
				filtered.push(item);
			}
			if (item.price <= types) {
				filtered.push(item);
			}
		});
		return filtered;
	};
});

myApp.controller('contactCon', [ '$scope', '$location', '$anchorScroll',
		'$log', function($scope, $location, $anchorScroll, $log) {
			$scope.gotoBottom = function() {
				// set the location.hash to the id of
				// the element you wish to scroll to.
				$log.info("here");
				$location.hash('about');

				// call $anchorScroll()
				$anchorScroll();
			};
		} ]);
