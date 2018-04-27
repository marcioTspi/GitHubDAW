package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Aluno a = new Aluno();
        a.setNome("Manuela");
        a.setEmail("dani-calza@gmail.com");
        try{
        String data = "19/04/1989";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(data));
        a.setNascimento(cal);
        }catch (ParseException e){
            e.printStackTrace();
        }        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
}
