app.controller("baseController",function($scope){
	 //分页控件配置
	$scope.paginationConf = {
		currentPage : 1,//当前页码
		totalItems : 10,//总条数
		itemsPerPage : 5,//每页的条数
		perPageOptions : [ 10, 20, 30, 40, 50 ],//页码选项
		//更改页面时，触发的事件
		onChange : function() {
			$scope.reloadList();
		}
	} 
	//重新加载列表  数据
	$scope.reloadList = function() {
		//切换页码
		$scope.search($scope.paginationConf.currentPage,
				$scope.paginationConf.itemsPerPage);
	} 
	
	//分页查询
	$scope.findByPage = function(currentPage, pageSize) {

		brandService.findByPage(currentPage,pageSize).success(
				function(response) {
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;//更新总记录数
				});
	} 
	
	 //定义选中的id集合
	 $scope.selectedIds=[];
	 
	 //genxin更新复选框
	 $scope.updateSelected = function($event,id){
	 	if($event.target.checked){
	 		$scope.selectedIds.push(id);
	 	}else{
	 		var idx = $scope.selectedIds.indexOf(id);
	 		$scope.selectedIds.splice(idx,1);
	 	}
	 }
})