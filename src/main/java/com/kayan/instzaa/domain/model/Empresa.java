package com.kayan.instzaa.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="EMPRESA")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String nomeEmpresa;

    @Column
    private String enderecoEstabelecimento;

    @Column
    private String numeroAtendimento;

    @Column
    private String email;

    @Column
    private String pixKey;

    @Column
    private String idCont;


    public Empresa(String nomeEmpresa,String enderecoEstabelecimento, String numeroAtendimento, String email, String pixKey, String idCont) {
    }
}
