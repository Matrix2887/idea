// 定义模块:
var app = angular.module("pinyougou",[]);
// 定义过滤器 一个过滤器只做一件事情
app.filter('trustHtml', ['$sce', function ($sce) {
    return function (data) { // 传入的参数是被过滤的内容
        return $sce.trustAsHtml(data); // 返回过滤后的内容
    }
}]);