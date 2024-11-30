package br.com.ylanbenoliel.pagamentos.service;

import br.com.ylanbenoliel.pagamentos.dto.PagamentoDto;
import br.com.ylanbenoliel.pagamentos.model.Pagamento;
import br.com.ylanbenoliel.pagamentos.model.Status;
import br.com.ylanbenoliel.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PagamentoService {

    public final PagamentoRepository repository;
    public final ModelMapper modelMapper;

    public PagamentoService(PagamentoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<PagamentoDto> buscarTodos(){
        return repository
                .findAll()
                .stream()
                .map(p->modelMapper.map(p, PagamentoDto.class))
                .collect(Collectors.toList());
    }

    public PagamentoDto buscarPorId(Long id){
        Optional<Pagamento> optPagamento = repository.findById(id);
        Pagamento pagamento = optPagamento.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto){
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto){
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void excluirPagamento(Long id){
        repository.deleteById(id);
    }
}
