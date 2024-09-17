package cl.negenko.Proyecto.Ventas.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tipo_vivienda")
public class TipoVivienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_vivienda")
    private int idTipoVivienda;
    @Column(name = "nombre_tipo", nullable = false, length = 20)
    private String nombreTipo;
}
