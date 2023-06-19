package br.com.srm.cadastro.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Pessoa {

    @Id
    @Column(nullable = false)
    private Long identificador;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoIdentificador tipoIdentificador;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    public Pessoa() {}

    public Pessoa(Long identificador, String nome) {
        this.identificador = identificador;
        this.nome = nome;
        this.tipoIdentificador = defineTipoIdentificador();
    }
    private TipoIdentificador defineTipoIdentificador() {
        if (identificadorLength(this.identificador) == 11)
            return TipoIdentificador.CPF;
        if (identificadorLength(this.identificador) == 14)
            return TipoIdentificador.CNPJ;
        return null;
    }

    private int identificadorLength(Long number){
        return String.valueOf(number).length();
    }
}
