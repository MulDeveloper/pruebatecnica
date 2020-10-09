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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "grupo_amigos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrupoAmigos.findAll", query = "SELECT g FROM GrupoAmigos g"),
    @NamedQuery(name = "GrupoAmigos.findByIdGrupo", query = "SELECT g FROM GrupoAmigos g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "GrupoAmigos.findByDescripcionGrupo", query = "SELECT g FROM GrupoAmigos g WHERE g.descripcionGrupo = :descripcionGrupo")})
public class GrupoAmigos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Size(max = 255)
    @Column(name = "descripcion_grupo")
    private String descripcionGrupo;
    @ManyToMany(cascade = {
        CascadeType.PERSIST,
        CascadeType.MERGE
    },
            fetch = FetchType.EAGER)
    @JoinTable(name = "lista_personas",
        joinColumns = @JoinColumn(name = "id_grupo"),
        inverseJoinColumns = @JoinColumn(name = "id_persona")
    )
    private List<Persona> personaList;

    @OneToMany(mappedBy = "idGrupoFk")
    private List<GastosGrupo> gastosGrupoList;

    public GrupoAmigos() {
    }

    public GrupoAmigos(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
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
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAmigos)) {
            return false;
        }
        GrupoAmigos other = (GrupoAmigos) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebatecnica.domain.GrupoAmigos[ idGrupo=" + idGrupo + " ]";
    }
    
}
