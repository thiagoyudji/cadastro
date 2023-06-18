package br.com.srm.cadastro.pessoa;

import br.com.srm.cadastro.config.RestExceptionHandler;
import br.com.srm.cadastro.util.NotFoundException;
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

    public PessoaDTO get(final Long identificador) {
        return pessoaRepository.findById(identificador)
                .map(pessoa -> mapToDTO(pessoa, new PessoaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final PessoaDTO pessoaDTO) throws PessoaExceptionHandler {
        if (pessoaDTO.getIdentificador() != null){
            final Pessoa pessoa = new Pessoa(pessoaDTO.getIdentificador(), pessoaDTO.getNome());
        } else throw new PessoaExceptionHandler("");

        mapToEntity(pessoaDTO, pessoa);
        return pessoaRepository.save(pessoa).getIdentificador();
    }

    public void update(final Long identificador, final PessoaDTO pessoaDTO) {
        final Pessoa pessoa = pessoaRepository.findById(identificador)
                .orElseThrow(NotFoundException::new);
        mapToEntity(pessoaDTO, pessoa);
        pessoaRepository.save(pessoa);
    }

    public void delete(final Long identificador) {
        pessoaRepository.deleteById(identificador);
    }

    private PessoaDTO mapToDTO(final Pessoa pessoa, final PessoaDTO pessoaDTO) {
        pessoaDTO.setIdentificador(pessoa.getIdentificador());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setTipoIdentificador(pessoa.getTipoIdentificador());
        return pessoaDTO;
    }

    private Pessoa mapToEntity(final PessoaDTO pessoaDTO, final Pessoa pessoa) {
        pessoa.setIdentificador(pessoaDTO.getIdentificador());
        pessoa.setNome(pessoaDTO.getNome());
        return pessoa;
    }

}
