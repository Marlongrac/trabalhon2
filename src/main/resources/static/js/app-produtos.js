

/**
 * Configuração das Rotas de Produtos
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		.when('/', {
			templateUrl: 'home.html'
		})
		
		.when('/produtos', {
			templateUrl: 'produtos-list.html',
			controller: 'ProdutoController',
			method: 'list'
		})
		
		.when('/produtos/new', {
			templateUrl: 'produtos-form.html',
			controller: 'ProdutoController',
			method: 'create'
		})
		
		.when('/produtos/:id', {
			templateUrl: 'produtos-show.html',
			controller: 'ProdutoController',
			method: 'show'
		})		
		
		.when('/produtos/:id/edit', {
			templateUrl: 'produtos-form.html',
			controller: 'ProdutoController',
			method: 'show'
		})		
	;
}]);


//ProdutoController
app.controller('ProdutoController', function($scope, $routeParams, $route, $location, 
		Upload, ProdutoService) {
	
	$scope.busca = "";

	//Aprovar
	$scope.aprovar = function() {
		ProdutoService.aprovar($scope.produto, function(produto) {
			//Atualiza o objeto produto na tela
			$scope.produto = produto;
		});	
	}
	
	//Busca
	$scope.buscar = function() {
		$scope.produtos = ProdutoService.query({texto:$scope.busca});	
	}
	
	//Lista
	$scope.list = function() {
		$scope.produtos = ProdutoService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.produto = {};
		$scope.carregarDados();
	}
	
	//Visualização
	$scope.show = function() {
		$scope.carregarDados();
		$scope.produto = ProdutoService.get({"id": $routeParams.id});
	}	
	
	//Salva
	$scope.save = function() {
		ProdutoService.save($scope.produto, function(produto){
			if(produto) {
				//Redireciona para a tela de visualizacao
				$location.path('/produtos/' + produto.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
		    	ProdutoService.remove($scope.produto, function(){
		    		$location.path('/produtos');
		    	});
		}
    }	
	
	$scope.upload = function(file) {
		Upload.upload({
		        url: '/api/produtos/' + $scope.produto.id + '/upload',
		        data: {file: file}
		}).then(function (resp) {
		    $scope.produto = resp.data;
		});		
	}
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});