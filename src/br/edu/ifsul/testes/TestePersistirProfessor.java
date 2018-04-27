package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirProfessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Professor p = new Professor();
        p.setTitulacao("Doutor");
        p.setTopicosInteresse("Programação distribuida, Robótica, Cirquitos Eletrônicos");
        p.setNome("João da Silva");
        p.setEmail("joao@hotmail.com");
        p.setNascimento(Calendar.getInstance());
        p.setEspecialidade(em.find(Especialidade.class, 4));
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
