/*
 * Copyright 2020 bunn3.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pruebatecnica.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "gastos_grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastosGrupo.findAll", query = "SELECT g FROM GastosGrupo g"),
    @NamedQuery(name = "GastosGrupo.findByIdPago", query = "SELECT g FROM GastosGrupo g WHERE g.idPago = :idPago"),
    @NamedQuery(name = "GastosGrupo.findByDescripcionPago", query = "SELECT g FROM GastosGrupo g WHERE g.descripcionPago = :descripcionPago"),
    @NamedQuery(name = "GastosGrupo.findByFechaPago", query = "SELECT g FROM GastosGrupo g WHERE g.fechaPago = :fechaPago"),
    @NamedQuery(name = "GastosGrupo.findByImporte", query = "SELECT g FROM GastosGrupo g WHERE g.importe = :importe"),
    @NamedQuery(name = "GastosGrupo.findByIdGrupo", query = "SELECT g FROM GastosGrupo g WHERE g.idGrupoFk.idGrupo = :idGrupo ORDER BY g.fechaPago DESC")})
public class GastosGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Size(max = 255)
    @Column(name = "descripcion_pago")
    private String descripcionPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe")
    private BigDecimal importe;
    @JoinColumn(name = "id_grupo_fk", referencedColumnName = "id_grupo")
    @ManyToOne
    private GrupoAmigos idGrupoFk;
    @JoinColumn(name = "id_persona_fk", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona idPersonaFk;

    public GastosGrupo() {
    }

    public GastosGrupo(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getDescripcionPago() {
        return descripcionPago;
    }

    public void setDescripcionPago(String descripcionPago) {
        this.descripcionPago = descripcionPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public GrupoAmigos getIdGrupoFk() {
        return idGrupoFk;
    }

    public void setIdGrupoFk(GrupoAmigos idGrupoFk) {
        this.idGrupoFk = idGrupoFk;
    }

    public Persona getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(Persona idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosGrupo)) {
            return false;
        }
        GastosGrupo other = (GastosGrupo) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebatecnica.domain.GastosGrupo[ idPago=" + idPago + " ]";
    }
    
}
