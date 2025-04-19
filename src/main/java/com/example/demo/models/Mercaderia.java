package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "mercaderias")
public class Mercaderia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Long idMercaderia;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @Column(name = "id_tipo_impuesto")
    private Integer idTipoImpuesto;

    @Column(name = "id_procedencia")
    private Integer idProcedencia;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "afecta_existencia")
    private Boolean afectaExistencia;

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "precio_venta")
    private Double precioVenta;

    // Constructores
    public Mercaderia() {}

    // Getters y Setters
    public Long getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(Long idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Integer getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public void setIdTipoImpuesto(Integer idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    public Integer getIdProcedencia() {
        return idProcedencia;
    }

    public void setIdProcedencia(Integer idProcedencia) {
        this.idProcedencia = idProcedencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getAfectaExistencia() {
        return afectaExistencia;
    }

    public void setAfectaExistencia(Boolean afectaExistencia) {
        this.afectaExistencia = afectaExistencia;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
