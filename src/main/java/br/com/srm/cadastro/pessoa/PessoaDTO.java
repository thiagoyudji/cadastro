package br.com.srm.cadastro.pessoa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PessoaDTO {

    @Size(min = 11, max = 14)
    @NotNull
    @
    private Long identificador;

    @NotNull
    @Size(max = 255)
    private String nome;

    @NotNull
    private TipoIdentificador tipoIdentificador;

}
