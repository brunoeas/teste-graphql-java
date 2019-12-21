package br.com.teste_graphql_java.converter;

import javax.enterprise.context.RequestScoped;

import br.com.teste_graphql_java.dto.LivroDTO;
import br.com.teste_graphql_java.orm.Livro;

/**
 * Converter de Livro
 * 
 * @author Bruno Eduardo
 **/
@RequestScoped
public class LivroConverter extends AbstractConverter<Livro, LivroDTO> {

    /**
     * Converte um DTO para ORM
     */
    @Override
    public Livro dtoToOrm(final LivroDTO dto, final Livro orm) {

        orm.setIdLivro(dto.getIdLivro());
        orm.setNmLivro(dto.getNmLivro());
        orm.setDsLivro(dto.getDsLivro());

        return orm;
    }

    /**
     * Converte um ORM para DTO
     */
    @Override
    public LivroDTO ormToDto(final Livro orm, final LivroDTO dto) {

        dto.setIdLivro(orm.getIdLivro());
        dto.setNmLivro(orm.getNmLivro());
        dto.setDsLivro(orm.getDsLivro());

        return dto;
    }

    /**
     * Retorna uma nova instância do ORM
     */
    @Override
    public Livro getOrmNewInstance() {
        return new Livro();
    }

    /**
     * Retorna uma nova instância do DTO
     */
    @Override
    public LivroDTO getDtoNewInstance() {
        return new LivroDTO();
    }

}