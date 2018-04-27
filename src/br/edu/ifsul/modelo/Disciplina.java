package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Márcio
 */
@Entity
@Table(name = "disciplina")
@Inheritance(strategy = InheritanceType.JOINED)
public class Disciplina implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 40, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;
    @Min(value = 0, message = "A carga horária não pode ser negativa")
    @NotNull(message = "A carga horária deve ser informada")
    @Column(name = "cargaHoraria", nullable = false, columnDefinition = "decimal(10,2)")
    private Double cargaHoraria;
    @NotNull(message = "Conhecimentos minimos não pode ser nula")
    @NotBlank(message = "Conhecimentos minimos não pode ser em branco")
    @Column(name = "conhecimentosMinimos", nullable = false)
    private String conhecimentosMinimos;
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "disciplinas",
            joinColumns
            = @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false))
    private List<Aluno> disciplinas = new ArrayList<>();
    @NotNull(message = "O curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_disciplina_curso")
    private Curso curso;

    public Disciplina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Aluno> getFazem() {
        return disciplinas;
    }

    public void setFazem(List<Aluno> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
