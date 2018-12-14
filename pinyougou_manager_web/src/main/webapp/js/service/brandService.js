app.service("brandService",function($http){
	
	//查询所有
	this.findAll = function(){
		return $http.get('../brand/findAll.do');
	}
	//分页查询
	this.findByPage = function(currentPage,pageSize){
		return $http.get(
				'../brand/findByPage.do?currentPage=' + currentPage
				+ '&pageSize=' + pageSize)
	}
	this.findById = function(id){
		return $http.get('../brand/findById.do?id=' + id)
	}
	
	this.delete = function(selectedIds){
		return $http.get('../brand/delete.do?ids='+selectedIds)
	}
	this.update = function(entity){
		return $http.post('../brand/update.do',entity)
	}
	this.add = function(entity){
		return $http.post('../brand/add.do',entity)
	}
})