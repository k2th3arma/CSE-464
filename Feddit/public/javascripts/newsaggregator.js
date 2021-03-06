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
        .when('/article/deleteComment/:id/:commentid', {
            templateUrl: 'partials/comment-delete.html',
            controller: 'DeleteCommentCtrl'
        })
        .when('/article/upvote/:id', {
            templateUrl: 'partials/article-upvote.html',
            controller: 'UpvoteArticleCtrl'
        })
        .when('/article/comments/:id',{
            templateUrl: 'partials/comments.html',
            controller: 'CommentsCtrl'
        })
        .when('/add-comment/:id',{
            templateUrl: 'partials/comment-form.html',
            controller: 'AddCommentCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);

app.controller('HomeCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
        var Article = $resource('/api/articles/');
        Article.query(function(articles){
            $scope.articles = articles;
        })



        $scope.upvote = function(article){
            article.votes++;

            var Articles = $resource('/api/articles/'+article._id +'/'+article.votes, { id: '@_id' }, {
                update: { method: 'POST' }
            });

            Articles.update($scope.article, function(){
                $location.path('/');
            });

        }
        
        $scope.downvote = function(article){
            article.votes--;

            var Articles = $resource('/api/articles/'+article._id +'/'+article.votes, { id: '@_id' }, {
                update: { method: 'POST' }
            });

            Articles.update($scope.article, function(){
                $location.path('/');
            });
        }
        $scope.search= function(val) {
           console.log("hey")
        }
}]);


app.controller('CommentsCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
    var Articles = $resource('/api/articles/:id');

    Articles.get({ id: $routeParams.id }, function(article){
        $scope.article = article;
        $scope.comments = article.comments;
    })

        $scope.upvote = function(comment){
            comment.votes++;

            var Articles = $resource('/api/articles/comments/:id/'+comment.commentid+'/'+comment.votes, { id: '@_id' }, {
                update: { method: 'POST' }
            });

            Articles.update($scope.article, function(){
                $location.path('/');
            });

        }

        $scope.downvote = function(comment){
            comment.votes--;

            var Articles = $resource('/api/articles/comments/:id/'+comment.commentid+'/'+comment.votes, { id: '@_id' }, {
                update: { method: 'POST' }
            });

            Articles.update($scope.article, function(){
                $location.path('/');
            });
        }

}]);

app.controller('AddArticleCtrl', ['$scope', '$resource', '$location',
    function($scope, $resource, $location){
        $scope.save = function(){
            var Article = $resource('/api/articles/:id');
            Article.save($scope.article, function(){
                $location.path('/');
            });
        };
}]);

app.controller('AddCommentCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
        var Articles = $resource('/api/articles/:id', { id: '@_id' }, {
            update: { method: 'POST' }
        });

    Articles.get({ id: $routeParams.id }, function(article){
        $scope.article = article;
        $scope.comments = article.comments;
    })

    $scope.comment = function(){
        Articles.update($scope.article, function(){
            $location.path('/');
        });
    }
}]);

app.controller('DeleteArticleCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
        var Articles = $resource('/api/articles/:id');

        Articles.get({ id: $routeParams.id}, function(article){
            $scope.article = article;
        })

        $scope.delete = function(){
            Articles.delete({ id: $routeParams.id }, function(article){
                $location.path('/');
            });
        }
    }]);

app.controller('DeleteCommentCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
        var Articles = $resource('/api/articles/:id/:commentid');

        $scope.commentid = $routeParams.commentid;

        Articles.get({ id: $routeParams.id, commentid: $routeParams.commentid}, function(article){
            $scope.article = article;
            $scope.comments = article.comments;

        })

        $scope.delete = function(){
            Articles.delete({ id: $routeParams.id, commentid: $routeParams.commentid}, function(article){
                $location.path('/');
            });
        }
    }]);

app.controller('UpvoteArticleCtrl', ['$scope', '$resource', '$location', '$routeParams',
    function($scope, $resource, $location, $routeParams){
        var Articles = $resource('/api/articles/:id/up', { id: '@_id' }, {
            update: { method: 'POST' }
        });
        Articles.get({ id: $routeParams.id }, function(article){
            $scope.article = article;
        })

        $scope.upvote = function(){
            Articles.update($scope.article, function(){
                $location.path('/');
            });
        }
    }]);