package com.kayan.instzaa.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name="COMENTARIO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer idComentario;

    @CreationTimestamp
    @Column(updatable = false)
    private Date dataComentario;

    @Column(nullable = false)
    private String nomeComentario;

    @Column(nullable = false)
    private String comentario;

    @Column(nullable = false)
    private Integer nota;

    @Column(nullable = false)
    private Integer idCardapio;
}
