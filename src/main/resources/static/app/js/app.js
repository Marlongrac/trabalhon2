var app = angular.module('app', ['ngResource', 'ngRoute', 'fxpicklist', 'ngFileUpload']);

//Interceptor de autenticação
app.factory('authInterceptorService', ['$q', function ($q){
    return {
        responseError: function (rejection) {
            if (rejection.status === 401) { //Acesso negado
            	//Redireciona para a tela de login
                location.href = "/";
            }
            return $q.reject(rejection);
        }
    };
}]);
app.config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('authInterceptorService');
}]);

/**
 * Configuração das Rotas Principais
 */
app.config(['$routeProvider', function($routerProvider){
	$routerProvider
		
		.when('/', {
			templateUrl: 'home.html'
		})
		
		//Categorias
		.when('/categorias', {
			templateUrl: 'categorias-list.html',
			controller: 'CategoriaController',
			method: 'list'
		})
		.when('/categorias/new', {
			templateUrl: 'categorias-form.html',
			controller: 'CategoriaController',
			method: 'create'
		})
		.when('/categorias/:id', {
			templateUrl: 'categorias-show.html',
			controller: 'CategoriaController',
			method: 'show'
		})		
		.when('/categorias/:id/edit', {
			templateUrl: 'categorias-form.html',
			controller: 'CategoriaController',
			method: 'show'
		})

		//Marcas
		.when('/marcas', {
			templateUrl: 'marcas-list.html',
			controller: 'MarcaController',
			method: 'list'
		})
		.when('/marcas/new', {
			templateUrl: 'marcas-form.html',
			controller: 'MarcaController',
			method: 'create'
		})
		.when('/marcas/:id', {
			templateUrl: 'marcas-show.html',
			controller: 'MarcaController',
			method: 'show'
		})		
		.when('/marcas/:id/edit', {
			templateUrl: 'marcas-form.html',
			controller: 'MarcaController',
			method: 'show'
		})
		
		//Produtos
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
		
		//Usuarios
		.when('/usuarios', {
			templateUrl: 'usuarios-list.html',
			controller: 'UsuarioController',
			method: 'list'
		})
		.when('/usuarios/new', {
			templateUrl: 'usuarios-form.html',
			controller: 'UsuarioController',
			method: 'create'
		})
		.when('/usuarios/:id', {
			templateUrl: 'usuarios-show.html',
			controller: 'UsuarioController',
			method: 'show'
		})		
		.when('/usuarios/:id/edit', {
			templateUrl: 'usuarios-form.html',
			controller: 'UsuarioController',
			method: 'show'
		})
		
		//Grupos
		.when('/grupos', {
			templateUrl: 'grupos-list.html',
			controller: 'GrupoController',
			method: 'list'
		})
		.when('/grupos/new', {
			templateUrl: 'grupos-form.html',
			controller: 'GrupoController',
			method: 'create'
		})
		.when('/grupos/:id', {
			templateUrl: 'grupos-show.html',
			controller: 'GrupoController',
			method: 'show'
		})		
		.when('/grupos/:id/edit', {
			templateUrl: 'grupos-form.html',
			controller: 'GrupoController',
			method: 'show'
		})
		
		//Clientes
		.when('/clientes', {
			templateUrl: 'clientes-list.html',
			controller: 'ClienteController',
			method: 'list'
		})
		.when('/clientes/new', {
			templateUrl: 'clientes-form.html',
			controller: 'ClienteController',
			method: 'create'
		})
		.when('/clientes/:id', {
			templateUrl: 'clientes-show.html',
			controller: 'ClienteController',
			method: 'show'
		})		
		.when('/clientes/:id/edit', {
			templateUrl: 'clientes-form.html',
			controller: 'ClienteController',
			method: 'show'
		})

}]);



//CategoriaService
app.factory('CategoriaService', function($resource) {
	return $resource('/api/categorias/:id', {}, {});
});

//MarcaService
app.factory('MarcaService', function($resource) {
	return $resource('/api/marcas/:id', {}, {});
});

//ProdutoService
app.factory('ProdutoService', function($resource) {
	return $resource('/api/produtos/:id', {}, {});
});

//UsuarioService
app.factory('UsuarioService', function($resource) {
	return $resource('/api/usuarios/:id', {}, {});
});

//GrupoService
app.factory('GrupoService', function($resource) {
	return $resource('/api/grupos/:id', {}, {});
});

//ClienteService
app.factory('ClienteService', function($resource) {
	return $resource('/api/clientes/:id', {}, {});
});


//CategoriaController
app.controller('CategoriaController', function($scope, $routeParams, $route, $location, CategoriaService) {
	
	//Lista
	$scope.list = function() {
		$scope.categorias = CategoriaService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.categoria = {};
	}
	
	//Visualização
	$scope.show = function() {
		$scope.categoria = CategoriaService.get({"id": $routeParams.id});
	}	
		
	//Salva
	$scope.save = function() {
		CategoriaService.save($scope.categoria, function(categoria){
			if(categoria) {
				$location.path('/categorias/' + categoria.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
			CategoriaService.remove($scope.categoria, function(){
	    		$location.path('/categorias');
	    	});
		}
    }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});


//MarcaController
app.controller('MarcaController', function($scope, $routeParams, $route, $location, MarcaService) {
	
	//Lista
	$scope.list = function() {
		$scope.marcas = MarcaService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.marca = {};
	}
	
	//Visualização
	$scope.show = function() {
		$scope.marca = MarcaService.get({"id": $routeParams.id});
	}	
	
	//Salva
	$scope.save = function() {
		MarcaService.save($scope.marca, function(marca){
			if(marca) {
				$location.path('/marcas/' + marca.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
			MarcaService.remove($scope.marca, function(){
	    		$location.path('/marcas');
	    	});
		}
  }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});

//ProdutoController
app.controller('ProdutoController', function($scope, $routeParams, $route, $location, ProdutoService, CategoriaService, MarcaService, Upload) {
	
	$scope.busca= "";
	
	//Busca
	$scope.buscar = function(){
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
	
		
	//Carrega as Categorias e Marcas
	$scope.carregarDados = function(){
		$scope.categorias = CategoriaService.query();
		$scope.marcas = MarcaService.query();
	}
	
	//Salva
	$scope.save = function() {
		ProdutoService.save($scope.produto, function(produto){
			if(produto) {
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

//UsuarioController
app.controller('UsuarioController', function($scope, $routeParams, $route, $location, UsuarioService, GrupoService) {
	
	//Lista
	$scope.list = function() {
		$scope.usuarios = UsuarioService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.usuario = {};
		$scope.carregarDados();
	}
	
	//Visualização
	$scope.show = function() {
		$scope.carregarDados();
		$scope.usuario = UsuarioService.get({"id": $routeParams.id});
	}
	
	//Carrega as Categorias e Marcas
	$scope.carregarDados = function(){
		$scope.grupos = GrupoService.query();
	}
		
	//Salva
	$scope.save = function() {
		UsuarioService.save($scope.usuario, function(usuario){
			if(usuario) {
				$location.path('/usuarios/' + usuario.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
			UsuarioService.remove($scope.usuario, function(){
	    		$location.path('/usuarios');
	    	});
		}
    }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});

//GrupoController
app.controller('GrupoController', function($scope, $routeParams, $route, $location, GrupoService) {
	
	//Lista
	$scope.list = function() {
		$scope.grupos = GrupoService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.grupo = {};
	}
	
	//Visualização
	$scope.show = function() {
		$scope.grupo = GrupoService.get({"id": $routeParams.id});
	}	
		
	//Salva
	$scope.save = function() {
		GrupoService.save($scope.grupo, function(grupo){
			if(grupo) {
				$location.path('/grupos/' + grupo.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
			GrupoService.remove($scope.grupo, function(){
	    		$location.path('/grupos');
	    	});
		}
    }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});

//ClienteController
app.controller('ClienteController', function($scope, $routeParams, $route, $location, ClienteService) {
	
	//Lista
	$scope.list = function() {
		$scope.clientes = ClienteService.query();	
	}
	//Novo
	$scope.create = function() {
		$scope.cliente = {};
	}
	
	//Visualização
	$scope.show = function() {
		$scope.cliente = ClienteService.get({"id": $routeParams.id});
	}	
		
	//Salva
	$scope.save = function() {
		ClienteService.save($scope.cliente, function(cliente){
			if(cliente) {
				$location.path('/clientes/' + cliente.id);
			}
		});
	}
	
	$scope.remove = function() {
		if(confirm('Confirma a Exclusão?')) {
			ClienteService.remove($scope.cliente, function(){
	    		$location.path('/clientes');
	    	});
		}
    }	
	
	//Chama o método definido na rota
	if($route.current.method){ 
		$scope[$route.current.method]();
	}
});
