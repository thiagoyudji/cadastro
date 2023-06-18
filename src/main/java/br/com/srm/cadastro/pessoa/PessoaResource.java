package br.com.srm.cadastro.pessoa;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PessoaResource {

    private final PessoaService pessoaService;

    public PessoaResource(final PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> getAllPessoas() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<PessoaDTO> getPessoa(
            @PathVariable(name = "identificador") final Long identificador) {
        return ResponseEntity.ok(pessoaService.get(identificador));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createPessoa(@RequestBody @Valid final PessoaDTO pessoaDTO) {
        final Long createdIdentificador = pessoaService.create(pessoaDTO);
        return new ResponseEntity<>(createdIdentificador, HttpStatus.CREATED);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<Void> updatePessoa(
            @PathVariable(name = "identificador") final Long identificador,
            @RequestBody @Valid final PessoaDTO pessoaDTO) {
        pessoaService.update(identificador, pessoaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{identificador}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deletePessoa(
            @PathVariable(name = "identificador") final Long identificador) {
        pessoaService.delete(identificador);
        return ResponseEntity.noContent().build();
    }

}
