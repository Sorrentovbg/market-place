angular.module('app').controller('productsController', function ($scope, $http, $localStorage) {
    const contextPath = 'http://localhost:5555';

    $scope.showProductsPage = function (pageIndex = 1) {
        $http({
            url: contextPath + '/getProduct',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null,
                p: pageIndex
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    // $scope.addToCart = function (productId) {
    //     $http.get(contextPath + '/api/v1/cart/add/' + productId)
    //         .then(function (response) {
    //         });
    // }

//    $scope.addToCartJS = function (productId) {
//        $http.get(contextPath + '/product/' + productId)
//            .then(function (response) {
//                $localStorage.happyCart.add(response.data);
//                console.log($localStorage.happyCart);
//            });
//    }

    $scope.createOrder = function () {
        $http.get(contextPath + '/marketplace/v1/orders/create')
            .then(function (response) {
            });
    }

    $scope.showProductsPage();
});