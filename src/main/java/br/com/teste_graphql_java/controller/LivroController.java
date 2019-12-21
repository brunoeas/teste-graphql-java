package br.com.teste_graphql_java.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.teste_graphql_java.converter.LivroConverter;
import br.com.teste_graphql_java.dto.LivroDTO;
import br.com.teste_graphql_java.orm.Livro;

/**
 * Controller de Livro
 * 
 * @author Bruno Eduardo
 **/
@RequestScoped
public class LivroController {

    /**
     * Converter do Livro
     */
    @Inject
    LivroConverter livroConverter;

    /**
     * Retorna todos os livros
     * 
     * @return Uma lista com todos os Livros
     */
    public List<LivroDTO> findAllLivros() {

        final List<Livro> ormList = Livro.listAll();

        return livroConverter.ormListToDtoList(ormList);
    }

}