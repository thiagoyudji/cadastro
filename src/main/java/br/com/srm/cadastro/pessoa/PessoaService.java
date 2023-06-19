package br.com.srm.cadastro.pessoa;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(final PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaDTO> findAll() {
        final List<Pessoa> pessoas = pessoaRepository.findAll(Sort.by("identificador"));
        return pessoas.stream()
                .map(pessoa -> mapToDTO(pessoa, new PessoaDTO()))
                .toList();
    }

    public void create(final PessoaDTO pessoaDTO) {
        final Pessoa pessoa = new Pessoa(pessoaDTO.getIdentificador(), pessoaDTO.getNome());
        if (pessoa.getTipoIdentificador() == null)
            throw new RuntimeException("O identificador deve ter 11 ou 14 caracteres");
        pessoaRepository.save(pessoa);
    }

    private PessoaDTO mapToDTO(final Pessoa pessoa, final PessoaDTO pessoaDTO) {
        pessoaDTO.setIdentificador(pessoa.getIdentificador());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setTipoIdentificador(pessoa.getTipoIdentificador());
        return pessoaDTO;
    }
}
