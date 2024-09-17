package cl.negenko.Proyecto.Ventas.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private int idDireccion;

    @Column(nullable = false, length = 255)
    private String calle;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column
    private String detalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comuna", nullable = false)
    private Comuna comuna;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_vivienda", nullable = false)
    private TipoVivienda tipoVivienda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;
}
