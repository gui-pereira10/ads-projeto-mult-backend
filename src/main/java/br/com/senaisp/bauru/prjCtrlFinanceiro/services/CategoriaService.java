package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Categoria;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }
    
    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public Categoria atualizar(Long id, Categoria categoria) {
        Categoria categoriaBanco = repository.findById(id).orElse(null);
        if (categoriaBanco == null) {
            return null;
        }
        categoriaBanco.setDescricao(categoria.getDescricao());
        categoriaBanco.setTipo(categoria.getTipo());
        categoriaBanco.setAtiva(categoria.getAtiva());
        return repository.save(categoriaBanco);
    }

    public boolean excluir(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

