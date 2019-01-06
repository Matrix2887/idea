app.controller('searchController', function ($scope, $location, searchService) {

    // 定义搜索对象的结构
    $scope.searchMap={'keywords':'', 'category':'', 'brand':'', 'price':'', 'pageNo':1, 'pageSize':40, 'sort':'', 'sortField':'', 'spec':{}};


    // 搜索
    $scope.search=function () {
        $scope.searchMap.pageNo = parseInt($scope.searchMap.pageNo);
        searchService.search($scope.searchMap).success(
            function (response) {
                $scope.resultMap=response;
                buildPageLabel();//构建分页栏
            }
        );
    }

    // 添加条件
    $scope.addSearchItem=function (key, value) {
        if('category' == key || 'brand' == key || 'price' == key){ // 分类与品牌是死的
            $scope.searchMap[key] = value;
        }else {
            $scope.searchMap.spec[key]=value; // 规格是或活的,每个分类都有不同的商品
        }
        $scope.search(); // 查询
    }

    // 删除条件
    $scope.removeSearchItem=function (key) {
        if('category' == key || 'brand' == key || 'price' == key){ // 分类与品牌是死的
            $scope.searchMap[key] = '';
        }else {
            delete $scope.searchMap.spec[key]; // 规格是或活的,每个分类都有不同的商品
        }
        $scope.search(); // 查询
    }
    
    //  构建分页栏
    buildPageLabel=function () {
        var firstPage = 1; // 开始页码
        var lastPage = $scope.resultMap.totalPages; // 截止页码
        $scope.firstDot = false; // 前面的点
        $scope.lastDot = false; // 后面的点
        // $scope.searchMap.pageNo --> 当前页码
        // $scope.resultMap.totalPages --> 总页码

        if($scope.resultMap.totalPages > 5){ // 如果总页码大于5
            if($scope.searchMap.pageNo <= 3){ // 开始的页码
                lastPage = 5;
                $scope.lastDot = true;
            }else if($scope.searchMap.pageNo >= $scope.resultMap.totalPages - 2){ // 结束的页码
                firstPage = $scope.resultMap.totalPages - 4;
                $scope.firstDot = true;
            }else{ // 普通中间的页码
                firstPage = $scope.searchMap.pageNo - 2;
                lastPage = $scope.searchMap.pageNo + 2;
                $scope.firstDot = true;
                $scope.lastDot = true;
            }
        }
        $scope.pageLabel=[];
        // 构建页码
        for(var i=firstPage; i <= lastPage; i++){
            $scope.pageLabel.push(i);
        }
    };

    $scope.queryByPage = function (pageNo) {
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.search(); // 查询
    }

    // 判断当前是否是第一页
    $scope.isTopPage=function () {
        if($scope.searchMap.pageNo == 1){
            return true;
        }else {
            return false;
        }
    }

    // 判断当前是否是最后一页
    $scope.isEndPage=function () {
        if($scope.searchMap.pageNo == $scope.resultMap.totalPages){
            return true;
        }else {
            return false;
        }
    }

    // 排序查询
    $scope.sortSearch=function (sortField, sort) {
        $scope.searchMap.sortField = sortField;
        $scope.searchMap.sort = sort;
        $scope.search();
    }

    // 判断关键字是否是品牌
    $scope.keywordsIsBrand=function () {
        for(var i = 0; i < $scope.resultMap.brandList.length; i++){
            if($scope.searchMap.keywords.indexOf($scope.resultMap.brandList[i].text) >= 0){
                return true;
            }
        }
        return false;
    }

    // 加载关键字
    $scope.loadkeywords=function () {
        $scope.searchMap.keywords = $location.search()['keywords'];
        $scope.search();
    }
});