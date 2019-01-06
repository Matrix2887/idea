app.controller('baseController', function ($scope) {

    // 刷新列表
    $scope.reloadList=function () {
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    // 分页控制器
    $scope.paginationConf={
        currentPage: 1, // 当前页
        totalItems: 10, // 总记录数
        itemsPerPage: 10, // 每页记录数
        perPageOption: [10, 20, 30, 40, 50], // 分页选项,修改每页显示多少数据
        onChange: function () { // 但页码变更后自动触发的方法
            $scope.reloadList();
        }
    };

    // 分页控制
    $scope.findPage=function (page, size) {
        brandService.findPage(page, size).success(
            function (response) {
                $scope.list=response.rows; // 显示当前页的数据
                $scope.paginationConf.totalItems=response.total; // 更新总记录数
            }
        );
    };

    $scope.selectIds=[]; // 用户勾选的ID集合
    $scope.updateSelection=function ($event, id) {
        if($event.target.checked){
            $scope.selectIds.push(id); // 向集合添加元素
        }else{
            var index = $scope.selectIds.indexOf(id); // 查找值的位置
            $scope.selectIds.splice(index, 1); // 移除的位置, 移除的个数
        }
    };

    // json转字符
    /**
     * 转成的对象是一个List<Map>集合, 在每个集合中有一个map根据map的key --> text 取出数据
     * @param jsonString
     * @param key
     * @returns {string}
     */
    $scope.jsonToString=function(jsonString,key){

        var json= JSON.parse(jsonString);
        var value="";

        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=",";
            }
            value +=json[i][key];
        }

        return value;
    };

    $scope.searchObjectByKey=function(list,key,keyValue){
        for(var i=0;i<list.length;i++){
            if(list[i][key]==keyValue){
                return list[i];
            }
        }
        return null;
    }

});