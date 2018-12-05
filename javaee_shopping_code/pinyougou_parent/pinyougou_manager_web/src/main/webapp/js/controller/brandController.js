app.controller('brandController', function($scope, $http,  $controller, brandService){

    $controller('baseController', {$scope:$scope});

    // 分页控制
    $scope.findPage=function (page, size) {
        brandService.findPage(page, size).success(
            function (response) {
                $scope.list=response.rows; // 显示当前页的数据
                $scope.paginationConf.totalItems=response.total; // 更新总记录数
            }
        );
    };

    $scope.findAll=function(){
        // 查询品牌列表
        brandService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    };

    $scope.searchEntity={};
    // 根据条件查询
    $scope.search=function (page, size) {
        brandService.search(page, size, $scope.searchEntity).success(
            function (response) {
                $scope.list=response.rows; // 显示当前页的数据
                $scope.paginationConf.totalItems=response.total; // 更新总记录数
            }
        );
    };

    // 保存/修改数据
    $scope.save=function () {
        var obj = null;
        if($scope.entity.id != null){
            obj = brandService.update($scope.entity);
        }else {
            obj = brandService.add($scope.entity);
        }
        obj.success(
            function (response) {
                if(response.success){
                    $scope.reloadList(); // 刷新
                }else {
                    alert(response.message);
                }
            }
        );
    };

    // 根据id查询单个数据
    $scope.findOne=function (id) {
        brandService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        );
    };

    // 删除
    $scope.deleteById=function () {
        if(confirm('确定要删除吗？')) {
            brandService.deleteById().success(
                function (response) {
                    if (response.success) {
                        $scope.reloadList(); // 刷新
                    } else {
                        alert(response.message);
                    }
                }
            );
        }
    };

});