package br.com.senaisp.bauru.prjCtrlFinanceiro.models;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.enums.TipoLancamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;
    
    @Column(nullable = false)
    private Boolean ativa;

    //Constructors
    public Categoria() {}
    
    public Categoria(String descricao, TipoLancamento tipo, Boolean ativa) {
            this.descricao = descricao;
            this.tipo = tipo;
            this.ativa = ativa;
    }
    //Getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Long getId() {
        return id;
    }
}