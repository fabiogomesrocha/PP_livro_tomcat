/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import model.Livro;
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
    private ArrayList<Livro> livros;
    private Livro livro;

    public ArrayList<Livro> getLivros() {
        String mariadb = "jdbc:mariadb://localhost:3306/livro";
        String user = "root";
        String passwd = "";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(mariadb, user, passwd);
            Statement stm = con.createStatement();
            
            String consulta = "select * from livros";
            ResultSet rs = stm.executeQuery(consulta);
            while(rs.next()){
                livro = new Livro();
                livro.setTitulo(rs.getString("titulo"));
                livro.setEditora(rs.getString("editora"));
                livro.setCidadeEd(rs.getString("cidade"));
                livro.setDataPublicacao(rs.getString("dataPublicacao"));
                livros.add(livro);
         
            }
            rs.close();
            con.close();
            
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }

    
    
    public LivroBean() {
        livros = new ArrayList<Livro>();
    }
    public String cadastrar(){
        String mariadb = "jdbc:mariadb://localhost:3306/livro";
        String user = "root";
        String passwd = "";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(mariadb, user, passwd);
            String consulta = "INSERT INTO livros (titulo, autores, editora, cidade, dataPublicacao, resumo, observacao, localizacao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, titulo);
            pstm.setString(2, autores);
            pstm.setString(3, editora);
            pstm.setString(4, cidadeEd);
            pstm.setString(5, dataPublicacao);
            pstm.setString(6, resumo);
            pstm.setString(7, observacao);
            pstm.setString(8, localizacao);
            pstm.execute();
            con.close();
            
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LivroBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LivroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("PP_PU");
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
        */
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
