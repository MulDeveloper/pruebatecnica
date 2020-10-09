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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bunn3
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByApellidoPersona", query = "SELECT p FROM Persona p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Persona.findByNombrePersona", query = "SELECT p FROM Persona p WHERE p.nombrePersona = :nombrePersona")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 255)
    @Column(name = "apellido_persona")
    private String apellidoPersona;
    @Size(max = 255)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    
    @ManyToMany(mappedBy = "personaList")
    private List<GrupoAmigos> grupoAmigosList;
    
    @OneToMany(mappedBy = "idPersonaFk")
    private List<GastosGrupo> gastosGrupoList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    @XmlTransient
    public List<GrupoAmigos> getGrupoAmigosList() {
        return grupoAmigosList;
    }

    public void setGrupoAmigosList(List<GrupoAmigos> grupoAmigosList) {
        this.grupoAmigosList = grupoAmigosList;
    }

    @XmlTransient
    public List<GastosGrupo> getGastosGrupoList() {
        return gastosGrupoList;
    }

    public void setGastosGrupoList(List<GastosGrupo> gastosGrupoList) {
        this.gastosGrupoList = gastosGrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebatecnica.domain.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
