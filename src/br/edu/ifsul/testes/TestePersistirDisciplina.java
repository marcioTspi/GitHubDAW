package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirDisciplina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Disciplina d = new Disciplina();
        d.setNome("Matemática");
        d.setDescricao("Estudo dos números");
        d.setCargaHoraria(100.00);
        d.setConhecimentosMinimos("Ser formado em Linguagens e afins");
        d.setCurso(em.find(Curso.class, 5));
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    }
}
