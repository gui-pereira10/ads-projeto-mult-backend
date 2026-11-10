package br.com.senaisp.bauru.prjCtrlFinanceiro.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.services.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin(origins = "*")
public class LancamentoController {

    private final LancamentoService service;

    public LancamentoController(LancamentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lancamento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Long id) {
        Lancamento Lancamento = service.buscarPorId(id);
        if (Lancamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Lancamento);
    }

    @PostMapping
    public ResponseEntity<Lancamento> cadastrar(@RequestBody Lancamento Lancamento) {
        Lancamento novaLancamento = service.salvar(Lancamento);
        return ResponseEntity.status(201).body(novaLancamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizar( @PathVariable Long id, 
                                                @RequestBody Lancamento Lancamento) {

        Lancamento LancamentoAtualizada =service.atualizar(id,Lancamento);
        if (LancamentoAtualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(LancamentoAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean excluida = service.excluir(id);
        if (!excluida) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

