
package sistema.pojos;

import java.util.Date;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class Dgastos {
    private int id;
    private String tipo_gasto;
    private Double total;
    private Date fecha;

    public Dgastos() {
    }

    public Dgastos(int id, String tipo_gasto, Double total, Date fecha) {
        this.id = id;
        this.tipo_gasto = tipo_gasto;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_gasto() {
        return tipo_gasto;
    }

    public void setTipo_gasto(String tipo_gasto) {
        this.tipo_gasto = tipo_gasto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
