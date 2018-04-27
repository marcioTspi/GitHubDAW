package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Márcio
 */
@Entity
@Table(name = "nota")
public class Nota implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Min(value = 0, message = "A nota01 não pode ser negativa")
    @NotNull(message = "A nota01 deve ser informado")
    @Column(name = "nota01", nullable = false, columnDefinition = "decimal(10,2)")
    private Double nota01;
    @Min(value = 0, message = "A nota02 não pode ser negativa")
    @NotNull(message = "A nota02 deve ser informado")
    @Column(name = "nota02", nullable = false, columnDefinition = "decimal(10,2)")
    private Double nota02;
    @Column(name = "media", nullable = false, columnDefinition = "decimal(10,2)")
    private Double media;
    @NotNull(message = "O Aluno deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_nota_aluno")
    private Aluno aluno;
    @NotNull(message = "A disciplina deve ser informada")
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_nota_disciplina")
    private Disciplina disciplina;

    public Nota() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nota other = (Nota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
