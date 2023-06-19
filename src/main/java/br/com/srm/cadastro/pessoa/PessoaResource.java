package br.com.srm.cadastro.pessoa;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createPessoa(@RequestBody @Valid final PessoaDTO pessoaDTO) {
        pessoaService.create(pessoaDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
