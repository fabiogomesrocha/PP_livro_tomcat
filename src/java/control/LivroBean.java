/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Livros;

/**
 *
 * @author 10361
 */
@ManagedBean
@SessionScoped
public class LivroBean implements Serializable {

    /**
     * Creates a new instance of LivroBean
     */
    private String titulo;
    private String autores;
    private String editora;
    private String cidadeEd;
    private String dataPublicacao;
    private String resumo;
    private String observacao;
    private String localizacao;
    public LivroBean() {
    }
    public String cadastrar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PP_PU");
        EntityManager em = emf.createEntityManager();
        Livros livros = new Livros();
        livros.setTitulo(titulo);
        livros.setAutores(autores);
        livros.setEditora(editora);
        livros.setDataPublicacao(dataPublicacao);
        livros.setLocalizacao(localizacao);
        livros.setObservacao(observacao);
        livros.setResumo(resumo);
        em.persist(livros);
        em.close();
        emf.close();
        return "exibirLivro";
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

    public String getCidadeEd() {
        return cidadeEd;
    }

    public void setCidadeEd(String cidadeEd) {
        this.cidadeEd = cidadeEd;
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
    
}
