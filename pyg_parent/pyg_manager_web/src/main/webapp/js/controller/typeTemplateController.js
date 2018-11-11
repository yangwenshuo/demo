 //控制层 
app.controller('typeTemplateController' ,function($scope,$controller ,specificationService, brandService ,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		typeTemplateService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		typeTemplateService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体
	$scope.findOne=function(id){
		typeTemplateService.findOne(id).success(
			function(response){
				$scope.entity= response;
				//alert(JSON.stringify($scope.entity)); 查看json对象

				//这里要把字符串转成json对象才能进行数据绑定
				//这里要转成json对象才能绑定
				$scope.entity.brandIds = JSON.parse($scope.entity.brandIds); //字符串转json对象
				$scope.entity.specIds = JSON.parse($scope.entity.specIds);
				$scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems);
			}
		);
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=typeTemplateService.update( $scope.entity ); //修改  
		}else{
			serviceObject=typeTemplateService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		typeTemplateService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
	//查询品牌列表
	$scope.findBrandList = function(){
		brandService.selectOptionList().success(
				function(response){

					//注意人家的select2要的就是d
					$scope.brandList = {data:response};
				}
		)
	}
	
	//查询规格列表
	$scope.findSpecList = function(){
		specificationService.selectOptionList().success(
				function(response){
					$scope.specList = {data:response};
				}
		)
	}
	
	$scope.init = function(){
		$scope.findBrandList();
		$scope.findSpecList();
		$scope.entity = {customAttributeItems:[]};
	}
	
	//添加自定义属性
	$scope.addTableRow = function(){
		$scope.entity.customAttributeItems.push({});
	}
	
	//删除自定义属性
	$scope.deleTableRow = function($index){
		$scope.entity.customAttributeItems.splice($index,1);
	}
	
	$scope.jsonToString=function(jsonString,key){
		var jsons = JSON.parse(jsonString);
		var value = "";
		for (var i = 0; i < jsons.length; i++) {
			if(i>0){
				value+=",";
			}
			value += jsons[i][key]
		}
		return value;
	}
});	
