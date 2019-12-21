package br.com.teste_graphql_java.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * ORM de Livro
 * 
 * @author Bruno Eduardo
 */
@Entity
@Table(name = "livro")
public class Livro extends PanacheEntityBase {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Integer idLivro;

    /**
     * Nome
     */
    @Column(name = "nm_livro", nullable = false, length = 100)
    private String nmLivro;

    /**
     * Descrição
     */
    @Column(name = "ds_livro", nullable = true)
    private String dsLivro;

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(final Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNmLivro() {
        return nmLivro;
    }

    public void setNmLivro(final String nmLivro) {
        this.nmLivro = nmLivro;
    }

    public String getDsLivro() {
        return dsLivro;
    }

    public void setDsLivro(final String dsLivro) {
        this.dsLivro = dsLivro;
    }

}