package com.kayan.instzaa.service;

import com.kayan.instzaa.controller.dto.EmpresaDto;
import com.kayan.instzaa.domain.model.Empresa;
import com.kayan.instzaa.domain.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository){
        this.repository = repository;
    }

    public EmpresaDto update(Long id, EmpresaDto empresaDto){
        Empresa empresa  = Optional.ofNullable(findById(id)).get();
        empresa.setNomeEmpresa(empresaDto.nomeEmpresa());
        empresa.setEnderecoEstabelecimento(empresaDto.enderecoEstabelecimento());
        empresa.setNumeroAtendimento(empresaDto.numeroAtendimento());
        empresa.setEmail(empresaDto.email());
        empresa.setPixKey(empresaDto.pixKey());
        empresa.setIdCont(empresaDto.idCont());
        repository.save(empresa);
        return empresaDto;
    }

    public Empresa findById(Long id){ return repository.findById(id).orElseThrow();}


}
