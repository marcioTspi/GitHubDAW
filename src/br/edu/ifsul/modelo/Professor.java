package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Márcio
 */
@Entity
@Table(name = "professor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor extends Aluno implements Serializable {

    @NotNull(message = "A titulação não pode ser nula")
    @NotBlank(message = "A titulação não pode estar em branco")
    @Length(max = 50, message = "O campo não pode ter mais que {max} caracteres")
    @Column(name = "titulacao", length = 50, nullable = false)
    private String titulacao;
    @NotNull(message = "Tópicos não pode ser nulo")
    @NotBlank(message = "Tópico não pode estar em branco")
    @Column(name = "topicosInteresse", nullable = false)
    private String topicosInteresse;
    @NotNull(message = "A Especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_professor_especialidade")
    private Especialidade especialidade;

    public Professor() {
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}
