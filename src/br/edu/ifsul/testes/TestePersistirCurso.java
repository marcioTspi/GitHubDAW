package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Instituicao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirCurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Curso c = new Curso();
        c.setNome("Física Motora");
        c.setSigla("FM");
        c.setDescricao("Física Motora");
        c.setAtivo(Boolean.FALSE);
        try{
        String data = "01/01/1989";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(data));
        c.setIniciaAtividades(cal);        
        c.setIntituicao(em.find(Instituicao.class, 4));
        }catch (ParseException e){
            e.printStackTrace();
        }        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
