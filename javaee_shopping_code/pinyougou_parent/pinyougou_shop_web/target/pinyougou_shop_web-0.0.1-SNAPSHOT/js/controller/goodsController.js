 //控制层 
app.controller('goodsController' ,function($scope, $controller, $location, goodsService, uploadService, itemCatService, typeTemplateService){
	
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
	$scope.findOne=function(){
	    var id = $location.search()['id'];
	    if(id == null){
	        return;
        }
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;
				editor.html($scope.entity.tbGoodsDesc.introduction); // 商品介绍
                $scope.entity.tbGoodsDesc.itemImages = JSON.parse($scope.entity.tbGoodsDesc.itemImages); // 商品图片
                $scope.entity.tbGoodsDesc.customAttributeItems = JSON.parse($scope.entity.tbGoodsDesc.customAttributeItems); // 扩展属性
                $scope.entity.tbGoodsDesc.specificationItems= JSON.parse($scope.entity.tbGoodsDesc.specificationItems); // SKU属性

                for(var i = 0; i < $scope.entity.itemList.length; i++){
                    $scope.entity.itemList[i].spec = JSON.parse($scope.entity.itemList[i].spec);
                }

			}
		);				
	};
	
	//保存 
	$scope.save=function(){
        $scope.entity.tbGoodsDesc.introduction=editor.html();
		var serviceObject;//服务层对象  				
		if($scope.entity.tbGoods.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
                    //重新查询
                    alert("商品信息更新成功");
                    $scope.entity={};
                    editor.html("");// 清空富文本编辑器
                    location.href="goods.html";
				}else{
					alert(response.message);
				}
			}		
		);				
	}

    // 添加
    $scope.add=function(){
	    $scope.entity.tbGoodsDesc.introduction=editor.html();
        goodsService.add( $scope.entity).success(
            function(response){
                if(response.success){
                    //重新查询
                    alert("商品信息添加成功");
                    $scope.entity={};
                    editor.html("");// 清空富文本编辑器
                }else{
                    alert(response.message);
                }
            }
        );
    };
	
	 
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

	// 定义对象
    $scope.image_entity={};
	// 上传文件
	$scope.uploadFile=function () {
        uploadService.uploadFile().success(
            function (response) {
                if(response.success){
                        $scope.image_entity.url=response.message;
                }else{
                    alert(response.message);
                }
            }
        );
    }


    $scope.entity={ tbGoods:{}, tbGoodsDesc:{itemImages:[], specificationItems:[]}};
    $scope.add_image_entity=function () {
        if($scope.image_entity.url){
            $scope.entity.tbGoodsDesc.itemImages.push($scope.image_entity);
        }else {
          alert("请上传图片");
        }
    }
    $scope.remove_image_entity=function (index) {
        $scope.entity.tbGoodsDesc.itemImages.splice(index, 1)
    }

    // 第一级联
    $scope.selectItemCat1List=function () {

        itemCatService.findByParentId(0).success(
            function (response) {
                $scope.itemCat1List=response;
            }
        );
    }

    // 第二级联
    $scope.$watch('entity.tbGoods.category1Id', function (newValue, oldValue) {

            itemCatService.findByParentId(newValue).success(
                function (response) {
                    $scope.itemCat2List=response;
                }
            );
    })

    // 第三级联
    $scope.$watch('entity.tbGoods.category2Id', function (newValue, oldValue) {
            itemCatService.findByParentId(newValue).success(
                function (response) {
                    $scope.itemCat3List=response;
                }
            );
    })

    // 读取模板id
    $scope.$watch('entity.tbGoods.category3Id', function (newValue, oldValue) {
       itemCatService.findOne(newValue).success(
           function (response) {
               $scope.entity.tbGoods.typeTemplateId=response.typeId;
           }
       );
    });



    // 读取品牌列表
    $scope.$watch('entity.tbGoods.typeTemplateId', function (newValue, oldValue) {
        typeTemplateService.findOne(newValue).success(
            function (response) {
                $scope.typeTemplate=response;
                $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds); // 品牌列表类型转换
                if($location.search()['id'] == null){ // 如果是增加商品
                    $scope.entity.tbGoodsDesc.customAttributeItems = JSON.parse(response.customAttributeItems); // 扩展属性转换
                }
            }
        );
        typeTemplateService.findSpecList(newValue).success(
            function (response) {
                $scope.specList = response;
            }
        );
    });


    // 'attributeName' 与传入进来的name进行比对, 看是否有这对象
    $scope.updateSpecAttribute = function ($event, name, value) {
        var obj = $scope.searchObjectByKey($scope.entity.tbGoodsDesc.specificationItems, 'attributeName', name);
        if(obj != null){
            if($event.target.checked){
                obj.attributeValue.push(value);
            }else {
                // 移除选项 取消勾选
                obj.attributeValue.splice(obj.attributeValue.indexOf(value), 1);
                if(obj.attributeValue.length == 0){
                    // 移除整个表格
                    $scope.entity.tbGoodsDesc.specificationItems.splice($scope.entity.tbGoodsDesc.specificationItems.indexOf(obj), 1);
                }
            }
        }else{
            $scope.entity.tbGoodsDesc.specificationItems.push({'attributeName':name, 'attributeValue':[value]});
        }
    }
    
    $scope.createItemList = function () {
        // 初始化列表
        $scope.entity.itemList = [{spec:{}, price:0, num:9999, status:'0', isDefault:'0'}];
        var items = $scope.entity.tbGoodsDesc.specificationItems;
        for(var i = 0; i < items.length; i++){
            $scope.entity.itemList = addColumn($scope.entity.itemList, items[i].attributeName, items[i].attributeValue)
        }
    }

    /**
     * 创建集合对象
     * @param list 当前的集合
     * @param columnName 要添加或减少的列
     * @param columnValues 该列的所有的数据集合
     */
    addColumn = function (oldList, columnName, columnValues) {
        debugger;
        // 返回的是一个集合,创建一个新集合
        var newList = [];
        // 深克隆当前集合list
        for(var i = 0; i < oldList.length; i++){
            var oldRow = oldList[i];
            for(var j = 0; j < columnValues.length; j++){
                var  newRow = JSON.parse(JSON.stringify(oldRow)); // 深克隆
                newRow.spec[columnName] = columnValues[j];
                newList.push(newRow);
            }
        }
        return newList;
    }

    $scope.status = ['未审核', '已审核', '已驳回', '已关闭'];
    $scope.itemCatList=[];
    $scope.findItemCatList = function () {
        itemCatService.findAll().success(
            function (response) {
                for(var i = 0; i < response.length; i++){
                    $scope.itemCatList[response[i].id] = response[i].name;
                }
            }
        );
    };


    // 判断规格与规格选项是否应该被勾选
    $scope.checkAttributeValue = function (specName, optionName) {
        var items = $scope.entity.tbGoodsDesc.specificationItems; // 规格选项
        var obj = $scope.searchObjectByKey(items, 'attributeName', specName);
        if(obj != null){
            if(obj.attributeValue.indexOf(optionName) >= 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
});	
