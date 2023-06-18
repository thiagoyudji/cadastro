package br.com.srm.cadastro.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
