package br.com.ylanbenoliel.pagamentos.controller;

import br.com.ylanbenoliel.pagamentos.dto.PagamentoDto;
import br.com.ylanbenoliel.pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    public final PagamentoService service;

    public PagamentoController(PagamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PagamentoDto> listar(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> buscarPorId(@PathVariable @NotNull Long id){
        PagamentoDto dto = service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto,
                                                  UriComponentsBuilder uriBuilder){
        PagamentoDto novoPagamento = service.criarPagamento(dto);
        var uri = uriBuilder.path("/pagamentos/{id}").buildAndExpand(novoPagamento.getId()).toUri();
        return ResponseEntity.created(uri).body(novoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id,
                                                  @RequestBody @Valid PagamentoDto dto){
        PagamentoDto pagamentoAtualizado = service.atualizarPagamento(id, dto);
        return ResponseEntity.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDto> excluir(@PathVariable @NotNull Long id){
        service.excluirPagamento(id);
        return ResponseEntity.notFound().build();
    }
}
