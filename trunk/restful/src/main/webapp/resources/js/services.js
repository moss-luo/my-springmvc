'use strict';

angular.module("PhoneCatServices",["ngResource"]).
	factory("Phone",function($resource){
		return $resource("phone/:phoneId",{},{
			query:{method:"GET",params:{phoneId:"phones"},isArray:true}
		});
	});