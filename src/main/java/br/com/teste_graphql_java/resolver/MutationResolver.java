package br.com.teste_graphql_java.resolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import br.com.teste_graphql_java.controller.LivroController;

/**
 * Mutation Resolver
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
@RequestScoped
public class MutationResolver implements GraphQLMutationResolver {

    @Inject
    LivroController livroController;

}