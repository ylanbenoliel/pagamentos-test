package br.com.ylanbenoliel.pagamentos.repository;

import br.com.ylanbenoliel.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
