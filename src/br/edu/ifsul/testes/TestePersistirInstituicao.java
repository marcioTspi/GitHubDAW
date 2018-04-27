package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Instituicao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirInstituicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Trabalho-DAW1-ModelPU");
        EntityManager em = emf.createEntityManager();
        Instituicao i = new Instituicao();
        i.setNome("IFSUL");
        try{
        String data = "1990";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(data));
        i.setAnoFundacao(cal);
        }catch (ParseException e){
            e.printStackTrace();
        }        
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
    }
}
