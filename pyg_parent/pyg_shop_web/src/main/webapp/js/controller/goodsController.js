 //控制层 
app.controller('goodsController' ,function($scope,$controller   ,goodsService, itemCatService,typeTemplateService,uploadService,$location){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){
		//alert($location.search()['id']);
		id = $location.search()['id'];
		if(id==null){
			return 
		}
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				
				//向富文本编辑器添加商品介绍
                editor.html($scope.entity.goodsDesc.introduction);
                //显示图片列表
                $scope.entity.goodsDesc.itemImages = JSON.parse($scope.entity.goodsDesc.itemImages);
                //显示扩展属性
                $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.entity.goodsDesc.customAttributeItems);
                //读取规格
                $scope.entity.goodsDesc.specificationItems= JSON.parse($scope.entity.goodsDesc.specificationItems);
                //准备SKU信息
                for( var i=0;i<$scope.entity.itemList.length;i++ ){
                    $scope.entity.itemList[i].spec = JSON.parse( $scope.entity.itemList[i].spec);
                }
			}
		);			
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  	
		$scope.entity.goodsDesc.introduction = editor.html();
		
		if($scope.entity.goods.id!=null){//如果entity中spu有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	//$scope.reloadList();//重新加载
					alert(response.message);
					$scope.entity = {}; //清空对象
					editor.html(''); //清空富文本编辑器
					
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
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
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
	//查询顶级分类列表
	$scope.selectItemCat1List = function(){
		itemCatService.findByParentId(0).success(
				function(response){
					$scope.itemCat1List = response;
				}
		)
	}
	
	//当entity.goods.category1Id值发生变化 //查看1级分类选择
	$scope.$watch('entity.goods.category1Id',function(newValue,oldValue){
		itemCatService.findByParentId(newValue).success(
				function(response){
					$scope.itemCat2List = response;
				}
		)
	})
	
	//查看二级分类选择
	$scope.$watch('entity.goods.category2Id',function(newValue,oldValue){
		itemCatService.findByParentId(newValue).success(
				function(response){
					$scope.itemCat3List = response;
				}
		)
	})
	
	//查看三级分类选择 ，选择之后只有分类ID,根据分类id获取分类对象
	$scope.$watch('entity.goods.category3Id',function(newValue,oldValue){
		itemCatService.findOne(newValue).success(
				function(response){
					$scope.entity.goods.typeTemplateId = response.typeId;
				}
		)
	})
	
	//查看模版id是否已赋值，根据赋值的id进行数据库查询
	$scope.$watch('entity.goods.typeTemplateId',function(newValue,oldValue){
		typeTemplateService.findOne(newValue).success(
				function(response){
					$scope.typeTemplate = response;
					//字符串转json对象
					$scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds);
					if($location.search()['id']==null){  //追加新增才需要转换
						$scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
					}
				}
		)
		
		//请求规格&规格选项的所有数据根据模版id
		typeTemplateService.findSpecList(newValue).success(
				function(response){
					$scope.specList = response;
				}
		)
	})
	
	$scope.init = function(){
		$scope.selectItemCat1List();
		$scope.entity = {goodsDesc:{itemImages:[],specificationItems:[]},itemList:[]};
		$scope.itemCatList = [];
		findItemCatList();
		$scope.status = ['未审核','已审核','审核未通过','关闭'];
		
	}
	
	$scope.uploadFile = function(){
		uploadService.uploadFile().success(
				function(response){
					$scope.image_entity.url = response.message; //给图片对象赋值图片对象包括url和color属性
				}
		)
	}
	
	//将图片信息新增到对象中的图片列表中
	$scope.addImage = function(){
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
	}
	
	//移除list中的图片对象
	$scope.deleImage = function($index){
		$scope.entity.goodsDesc.itemImages.splice($index,1);
	}
	
	//勾选后更新后选择的规格 ,参数1控件  2规格名  3规格选项
	$scope.updateSpecAttribute = function($event, name, value) {
		var object = searchObjectByKey($scope.entity.goodsDesc.specificationItems,'attributeName',name);
		if(object == null){ //当前保存的规格中无该规格的名称对象
			$scope.entity.goodsDesc.specificationItems.push({'attributeName':name,'attributeValue':[value]})
		}else{ //找到该规格选项集合对象
			if($event.target.checked){ //继续判断传入的勾选框是否选中，选中是新增，未选中是删除
				object.attributeValue.push(value); //给$scope.entity.goodsDesc.specificationItems.attributeValue规格选项的集合直接push规格选项
			}else{
				object.attributeValue.splice(object.attributeValue.indexOf(value),1); //移除该选项从$scope.entity.goodsDesc.specificationItems.attributeValue
				//如果规格选项都没了，移除掉当前规格对象从$scope.entity.goodsDesc.specificationItems
				if(object.attributeValue.length < 1){
					var objectIndex = $scope.entity.goodsDesc.specificationItems.indexOf(object);
					$scope.entity.goodsDesc.specificationItems.splice(objectIndex,1);
				}
			}
		}
	}
	
	//1.传入的集合，验证集合里是否有该key对应的value
	searchObjectByKey=function(list,key,value){
		for (var i = 0; i < list.length; i++) {
			if(list[i][key]==value){
				return list[i];
			}
		}
		return null;
	}
	
	//创建itemList集合
	$scope.createItemList = function(){
		//初始化
		$scope.entity.itemList = [ {spec : {},price : 0,num : 99999,status : '0',isDefault : '0'} ];// 初始
		//[{"attributeName":"网络","attributeValue":["移动3G","移动4G"]},{"attributeName":"机身内存","attributeValue":["16G"]}]
		var items = $scope.entity.goodsDesc.specificationItems;
		for (var i = 0; i < items.length; i++) {
			$scope.entity.itemList = addColumn($scope.entity.itemList, items[i].attributeName, items[i].attributeValue);
		}
	}
	
	//$scope.entity.itemList[], 规格的名称 , 规格选项的集合   
	addColumn = function(list, columnName, conlumnValues) {
		var newList = [];// 新的集合
		
		for (var i = 0; i < list.length; i++) {
			var oldRow = list[i];// {spec : {},price : 0,num : 99999,status : '0',isDefault : '0'} 
			for (var j = 0; j < conlumnValues.length; j++) {
				var newRow =  JSON.parse(JSON.stringify(oldRow)); //深克隆
				newRow.spec[columnName] = conlumnValues[j];
				newList.push(newRow);
			}
			
		}
		return newList;
	}
	
	
	//查询所有分类的信息并放入itemCatList
	findItemCatList = function() {
		itemCatService.findAll().success(
				function(response){
					for (var i = 0; i < response.length; i++) {
						$scope.itemCatList[response[i].id] = response[i].name;
					}
				}
		)
	}
});	
