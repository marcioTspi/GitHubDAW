package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirNota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Nota n = new Nota();
        Double n1 = 5.0;
        Double n2 = 7.3;
        n.setNota01(n1);
        n.setNota02(n2);
        Double m = (n1+n2)/2;
        n.setMedia(m);
        n.setAluno(em.find(Aluno.class, 4));
        n.setDisciplina(em.find(Disciplina.class, 7));
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
    }
}
