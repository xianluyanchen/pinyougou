	//读取列表数据绑定到表单中
	app.controller('brandController', function($scope, $http,brandService,$controller) {
		//继承baseController
		$controller('baseController',{$scope:$scope})
		//查询所有，不分页
 		$scope.findAll = function() {
			brandService.findAll().success(function(response) {
				$scope.list = response;
			});
		} 

		 //品牌增加 or update
		$scope.save = function() {
			//服务层对象
			var serviceObject;
			//因为修改和增加在一个页面中，所以需要判断是否传入了id值，修改需要传id值进行回显
			if ($scope.entity.id != null) {
				serviceObject = brandService.update($scope.entity)
			}else{
				serviceObject = brandService.add($scope.entity)
			}
			serviceObject.success(
				function(response){
					if(response.success){
						$scope.reloadList();
					}else{
						alert(response.message);
					}
				}
			);
		}

		//根据id查询单个品牌信息
		$scope.findById = function(id) {
			brandService.findById(id).success(
					function(response) {
						$scope.entity = response;
					})
		}
		
		 $scope.delete = function(){
		 
		 if(confirm('确定删除？')){
		 	brandService.delete($scope.selectIds).success(
		 		function(response){
		 			if(response.success){
		 			$scope.reloadList();
		 			}else{
		 			alert(response.message);
		 			}
		 		}
		 	);
		 }
		 }
		 
		 //定义搜索对象
		 $scope.searchEntity={};
		 
		 //条件查询
		 $scope.search = function(currentPage,pageSize){
		 	 $http.post('../brand/search.do?currentPage='+currentPage+"&pageSize="+pageSize, $scope.searchEntity).success(
		 	 
		 	 function(response){
		 	 	$scope.paginationConf.totalItems=response.total;//总记录数  
    			$scope.list=response.rows;//给列表变量赋值 
		 	 }
		 	 
		 	 )
		 	 
		 	
		 }
	});