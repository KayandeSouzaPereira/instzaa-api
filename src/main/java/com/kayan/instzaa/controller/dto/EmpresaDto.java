package com.kayan.instzaa.controller.dto;

import com.kayan.instzaa.domain.model.Empresa;

public record EmpresaDto(
        String nomeEmpresa,
        String enderecoEstabelecimento,
        String numeroAtendimento,
        String email,
        String pixKey,
        String idCont
) {

    public Empresa toDomain() { return new Empresa(nomeEmpresa, enderecoEstabelecimento, numeroAtendimento, email, pixKey, idCont);}

    public static EmpresaDto fromDomain(Empresa empresa){
        return new EmpresaDto(empresa.getNomeEmpresa(), empresa.getEnderecoEstabelecimento(), empresa.getNumeroAtendimento(), empresa.getEmail(), empresa.getPixKey(), empresa.getIdCont());
    }


}
