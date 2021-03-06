/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id")
    , @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeDestino")
    private List<Rotapronta> rotaprontaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeOrigem")
    private List<Rotapronta> rotaprontaList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeFim")
    private List<Distanciacidades> distanciacidadesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadeInicio")
    private List<Distanciacidades> distanciacidadesList1;

    public Cidade() {
    }

    public Cidade(Integer id) {
        this.id = id;
    }

    public Cidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<Rotapronta> getRotaprontaList() {
        return rotaprontaList;
    }

    public void setRotaprontaList(List<Rotapronta> rotaprontaList) {
        this.rotaprontaList = rotaprontaList;
    }

    @XmlTransient
    public List<Rotapronta> getRotaprontaList1() {
        return rotaprontaList1;
    }

    public void setRotaprontaList1(List<Rotapronta> rotaprontaList1) {
        this.rotaprontaList1 = rotaprontaList1;
    }

    @XmlTransient
    public List<Distanciacidades> getDistanciacidadesList() {
        return distanciacidadesList;
    }

    public void setDistanciacidadesList(List<Distanciacidades> distanciacidadesList) {
        this.distanciacidadesList = distanciacidadesList;
    }

    @XmlTransient
    public List<Distanciacidades> getDistanciacidadesList1() {
        return distanciacidadesList1;
    }

    public void setDistanciacidadesList1(List<Distanciacidades> distanciacidadesList1) {
        this.distanciacidadesList1 = distanciacidadesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cidade[ id=" + id + " ]";
    }
    
}
