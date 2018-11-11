app.controller('searchController',function($scope,searchService){
	
	
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 10,
         perPageOptions: [10, 20, 30, 40, 50],
		// yws:这里的onchange是search函数
         onChange: function(){
        	 $scope.search();//重新加载
     	 }
	}; 
	
	$scope.init = function(){

		// yws:这里定义了我们整个的查询的map,我们就是通过维护这个map的entity来维护有什么查询条件
		$scope.searchMap = {keywords:'手机',
				category:'',
				brand:'',
				spec:{},
				price:'',
				sort:'ASC',
				page:1,
				pageSize:10};
		// yws:包括品牌规格价格啥的这几个查询条件,也包含分页的东西
		
		$scope.search();  //直接进行搜索
	}
	
	$scope.search = function(){
		$scope.searchMap.page = $scope.paginationConf.currentPage;   //设置页码
		$scope.searchMap.pageSize = $scope.paginationConf.itemsPerPage; //设置每页记录数
		
		searchService.search($scope.searchMap).success(
				function(response){
					$scope.list = response.rows;
					$scope.paginationConf.totalItems = response.total;
				}
		)
	}
	
	//增加搜索关键字的方法
	$scope.addFilterCondition = function(key,value){
		
		if(key=='category' || key=='brand' || key=='price'){
			// 分类，品牌，价格参数封装
			$scope.searchMap[key] = value;
			// yws:注意这里要用[]的方式不能用.,因为key是一个参数,变量
		}else{
			// 否则规格属性参数封装
			$scope.searchMap.spec[key] = value;
		}
		$scope.search();
	}
	
	//移除搜索条件
	$scope.removeSearchItem=function(key){
		if(key=='category' || key=='brand' || key=='price'){
			$scope.searchMap[key] = '';
		}else{
			delete $scope.searchMap.spec[key];//移除此属性,通过javaScirpt的delete方法移除掉map中的key
		}
		$scope.search();
	}
	
	//修改map中升降序的请求参数
	$scope.sortSearch=function(sort){
		$scope.searchMap.sort=sort;	
		$scope.search();
	}

	//yws:可以看到上面无论加属性还是减属性都会调用search方法.
})