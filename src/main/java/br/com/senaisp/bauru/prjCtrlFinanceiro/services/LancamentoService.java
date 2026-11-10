package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;

@Service
public class LancamentoService {
    private final LancamentoRepository repository;

    public LancamentoService(LancamentoRepository repository) {
        this.repository = repository;
    }

    public List<Lancamento> listar() {
        return repository.findAll();
    }

    public Lancamento salvar(Lancamento Lancamento) {
        return repository.save(Lancamento);
    }
    
    public Lancamento buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public Lancamento atualizar(Long id, Lancamento Lancamento) {
        Lancamento LancamentoBanco = repository.findById(id).orElse(null);
        if (LancamentoBanco == null) {
            return null;
        }
        LancamentoBanco.setDescricao(Lancamento.getDescricao());
        LancamentoBanco.setCategoria(Lancamento.getCategoria());
        LancamentoBanco.setValor(Lancamento.getValor());
        LancamentoBanco.setDataLancamento(Lancamento.getDataLancamento());
        LancamentoBanco.setObservacao(Lancamento.getObservacao());
        LancamentoBanco.setUsuario(Lancamento.getUsuario());
        return repository.save(LancamentoBanco);
    }

    public boolean excluir(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

