package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.OrdemDeServico;
import com.greatpretender.api.projetoapijaia.repository.OrdemDeServicoRepository;

@Service
public class OrdemdeServicoService implements IOrdemDeServicoService {
    @Autowired
    private OrdemDeServicoRepository ordemRepo;

    public OrdemDeServico buscarPorId(Long id){
        Optional<OrdemDeServico> ordemDeServicoOp = ordemRepo.findById(id);
        if(ordemDeServicoOp.isPresent()){
            return ordemDeServicoOp.get();
        }
    throw new IllegalArgumentException("ID inválido");
    }

    public OrdemDeServico novaOrdemDeServico(OrdemDeServico ordem){
        if(ordem == null ||
            ordem.getDescricao() == null ||
            ordem.getStatusOrdem() == null ||
            ordem.getStatus_aprovacao() == null ||
            //ordem.getUsuario() == null ||
            ordem.getSetor() == null ||
            ordem.getCliente() == null ||
            ordem.getData_inicio() == null ||
            ordem.getData_fim() == null
        )
        {
        throw new IllegalArgumentException("Dados Inválidos!" +ordem.getData_inicio() + ordem.getData_fim());
        }
        return ordemRepo.save(ordem);
    }

    // Listar Todas Ordens de Serviço
    public List<OrdemDeServico> buscarTodasOrdensDeServico(){
        return(List<OrdemDeServico>) ordemRepo.findAll();
    }

    public OrdemDeServico deletarPorId(Long id){
        Optional<OrdemDeServico> ordemDeServicoOp = ordemRepo.findById(id);
        if(ordemDeServicoOp.isPresent()){
            
            ordemRepo.deleteById(id);
            return ordemDeServicoOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }
}
