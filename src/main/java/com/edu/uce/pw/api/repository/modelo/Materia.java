package com.edu.uce.pw.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Materia")
public class Materia {

    @Id
    @GeneratedValue(generator = "seq_materia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_materia", sequenceName = "seq_materia", allocationSize = 1)
    @Column(name = "materia_id")
    private Integer id;

    @Column(name = "materia_nombre")
    private String nombre;

    @Column(name = "materia_creditos")
    private Integer creditos;

    @Column(name = "materia_ced_profesor")
    private String ced_profesor;

    @Column(name = "materia_nivel")
    private Integer nivel;
}
