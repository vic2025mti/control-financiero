package com.example.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    // Relación uno-a-muchos con Mercaderia
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mercaderia> mercaderias;

    // Constructores
    public Marca() {}

    public Marca(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Mercaderia> getMercaderias() {
        return mercaderias;
    }

    public void setMercaderias(List<Mercaderia> mercaderias) {
        this.mercaderias = mercaderias;
    }

	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNombre(Object nombre) {
		// TODO Auto-generated method stub
		
	}
}
