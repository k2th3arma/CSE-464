var app = angular.module('NewsAggregator',['ngResource','ngRoute']);



app.config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'partials/home.html',
            controller: 'HomeCtrl'
        })
        .when('/add-article', {
            templateUrl: 'partials/article-form.html',
            controller: 'AddArticleCtrl'
        })
        .when('/article/delete/:id', {
            templateUrl: 'partials/article-delete.html',
            controller: 'DeleteArticleCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);

app.controller('HomeCtrl', ['$scope', '$resource', 
    function($scope,$resource){
        var Article = $resource('/api/articles');
        Article.query(function(articles){
            $scope.articles = articles;
        })
}]);

app.controller('AddArticleCtrl', ['$scope', '$resource', '$location',
    function($scope, $resource, $location){
        $scope.save = function(){
            var Article = $resource('/api/articles');
            Article.save($scope.article, function(){
                $location.path('/');
            });
        };
}]);

app.controller('DeleteArticleCtrl', ['$scope', '$resource', '$location', '$routeParams',
function($scope, $resource, $location, $routeParams){
    var Articles = $resource('/api/articles/:id');
    
    Articles.get({ id: $routeParams.id }, function(article){
        $scope.article = article;
    })

    $scope.delete = function(){
        Articles.delete({ id: $routeParams.id }, function(article){
            $location.path('/');
        });
    }
}]);


