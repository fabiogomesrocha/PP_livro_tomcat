/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 10361
 */
@Entity
@Table(name = "livros")
@NamedQueries({
    @NamedQuery(name = "Livros.findAll", query = "SELECT l FROM Livros l"),
    @NamedQuery(name = "Livros.findById", query = "SELECT l FROM Livros l WHERE l.id = :id"),
    @NamedQuery(name = "Livros.findByTitulo", query = "SELECT l FROM Livros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livros.findByAutores", query = "SELECT l FROM Livros l WHERE l.autores = :autores"),
    @NamedQuery(name = "Livros.findByEditora", query = "SELECT l FROM Livros l WHERE l.editora = :editora"),
    @NamedQuery(name = "Livros.findByCidade", query = "SELECT l FROM Livros l WHERE l.cidade = :cidade"),
    @NamedQuery(name = "Livros.findByDataPublicacao", query = "SELECT l FROM Livros l WHERE l.dataPublicacao = :dataPublicacao"),
    @NamedQuery(name = "Livros.findByLocalizacao", query = "SELECT l FROM Livros l WHERE l.localizacao = :localizacao")})
public class Livros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "autores")
    private String autores;
    @Basic(optional = false)
    @Column(name = "editora")
    private String editora;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "dataPublicacao")
    private String dataPublicacao;
    @Basic(optional = false)
    @Lob
    @Column(name = "resumo")
    private String resumo;
    @Basic(optional = false)
    @Lob
    @Column(name = "observacao")
    private String observacao;
    @Basic(optional = false)
    @Column(name = "localizacao")
    private String localizacao;

    public Livros() {
    }

    public Livros(Integer id) {
        this.id = id;
    }

    public Livros(Integer id, String titulo, String autores, String editora, String cidade, String dataPublicacao, String resumo, String observacao, String localizacao) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.cidade = cidade;
        this.dataPublicacao = dataPublicacao;
        this.resumo = resumo;
        this.observacao = observacao;
        this.localizacao = localizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livros)) {
            return false;
        }
        Livros other = (Livros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Livros[ id=" + id + " ]";
    }
    
}
