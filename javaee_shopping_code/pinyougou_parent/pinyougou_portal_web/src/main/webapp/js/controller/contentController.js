app.controller('contentController', function ($scope, contentService) {

    $scope.contentList=[]; // 广告列表
    $scope.findByCategoryId = function (categoryId) {
        contentService.findByCategoryId(categoryId).success(
            function (response) {
                $scope.contentList[categoryId]=response;
            }
        );
    };

    // 搜索传递参数
    // 搜索框联动跨域
    $scope.search=function () {
        location.href="http://localhost:9104/search.html#?keywords="+$scope.keywords;
    }

});