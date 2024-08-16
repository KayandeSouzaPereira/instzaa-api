package com.kayan.instzaa.domain.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="Pedido")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column
    private String CPF;

    @Column
    private String endereco;

    @CreationTimestamp
    @Column(updatable = false, name = "data")
    private Date data;

    @Column
    private String numeroContato;

    @Column
    private BigDecimal valor;

    @Column
    private String payId;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;


    @ManyToMany
    private Set<Cardapio> resumoPedido;




}
