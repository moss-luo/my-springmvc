"use strict";
function PhoneListCtrl($scope,Phone){
	$scope.phones=Phone.query();
	$scope.orderProp="age";
}
//PhoneListCtrl.$inject = ['$scope', 'Phone'];

function PhoneDetailCtrl($scope,$routeParams,Phone){
	$scope.phone=Phone.get({phoneId:$routeParams.phoneId,name:"123"},function(phone){
		$scope.mainImageUrl = phone.images[0];
	});
	
	$scope.setImage=function(imageUrl){
		$scope.mainImageUrl=imageUrl
	}
}
//PhoneDetailCtrl.$inject = ['$scope', '$routeParams', 'Phone'];