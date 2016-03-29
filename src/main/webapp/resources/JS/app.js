var app = angular.module('monApp', []);

app.controller("menuController", ['$scope','$http', function($scope, $http){
        
        $scope.chargeContenu = function(route){
            
            $scope.contentRoute = route;
        }
        
        $scope.contentRoute = "film/lister";
}]);