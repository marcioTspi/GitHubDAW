package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirEspecialidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Especialidade f = new Especialidade();
        f.setNome("Banco de Dados");
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
    }
}
