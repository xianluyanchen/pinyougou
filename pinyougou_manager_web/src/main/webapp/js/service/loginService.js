app.service("loginService",function($http){
	
	//获取已经登录的用户名
	this.getLoginName = function(){
		return $http.get('../login/getName.do');
	}
})