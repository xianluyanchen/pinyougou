app.controller("indexController",function(loginService,$scope,$http,$controller){
	// 读取当前登录人
 $scope.getLoginName = function(){
	 loginService.getLoginName().success(
	function(response){
		$scope.loginName = response.loginName;
	}		 
	 );
 }
	})