package br.com.senaisp.bauru.prjCtrlFinanceiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {}
