package com.edu.uce.pw.api.repository.modelo;


import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
    @Column(name = "estu_id")
    private Integer id;

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name = "estu_genero")
    private String genero;

    @OneToMany(mappedBy = "estudiante")
    private List<Materia> materias;

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
                + fechaNacimiento + ", genero=" + genero + "]";
    }

}
