package br.com.teste_graphql_java.resolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.teste_graphql_java.controller.LivroController;
import br.com.teste_graphql_java.dto.LivroDTO;

/**
 * Query Resolver
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@RequestScoped
public class QueryResolver implements GraphQLQueryResolver {

    /**
     * Controller do Livro
     */
    @Inject
    LivroController livroController;

    /**
     * Retorna todos os livros
     * 
     * @return Uma lista com todos os Livros
     */
    public LivroDTO[] findAllLivros() {
        return livroController.findAllLivros().toArray(new LivroDTO[] {});
    }

}