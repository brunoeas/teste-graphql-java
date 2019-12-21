package br.com.teste_graphql_java.dto;

import java.io.Serializable;

/**
 * DTO do Livro
 *
 * @author Bruno Eduardo <bruno.soares@kepha.com.br>
 */
public class LivroDTO implements Serializable {

    /**
    *
    */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer idLivro;

    /**
     * Nome
     */
    private String nmLivro;

    /**
     * Descrição
     */
    private String dsLivro;

    public Integer getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(final Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNmLivro() {
        return this.nmLivro;
    }

    public void setNmLivro(final String nmLivro) {
        this.nmLivro = nmLivro;
    }

    public String getDsLivro() {
        return this.dsLivro;
    }

    public void setDsLivro(final String dsLivro) {
        this.dsLivro = dsLivro;
    }

}