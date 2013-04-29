'use strict';

/*App module*/

angular.module("phonecat",["PhoneCatServices"]).
	config(["$routeProvider",function($routeProvider){
		$routeProvider.
			when("/phones",{templateUrl:"pages/phone-list.html",controller:PhoneListCtrl}).
			when("/phones/:phoneId",{templateUrl:"pages/phone-detail.html",controller:PhoneDetailCtrl}).
			otherwise({redirectTo:"/phones"});
	}]);