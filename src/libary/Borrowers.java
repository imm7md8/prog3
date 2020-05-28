/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "borrowers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrowers.findAll", query = "SELECT b FROM Borrowers b")
    , @NamedQuery(name = "Borrowers.findById", query = "SELECT b FROM Borrowers b WHERE b.id = :id")
    , @NamedQuery(name = "Borrowers.findByFn", query = "SELECT b FROM Borrowers b WHERE b.fn = :fn")
    , @NamedQuery(name = "Borrowers.findByLn", query = "SELECT b FROM Borrowers b WHERE b.ln = :ln")
    , @NamedQuery(name = "Borrowers.findByMobile", query = "SELECT b FROM Borrowers b WHERE b.mobile = :mobile")
    , @NamedQuery(name = "Borrowers.findByEmail", query = "SELECT b FROM Borrowers b WHERE b.email = :email")
    , @NamedQuery(name = "Borrowers.findByAddress", query = "SELECT b FROM Borrowers b WHERE b.address = :address")})
public class Borrowers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FN")
    private String fn;
    @Column(name = "LN")
    private String ln;
    @Column(name = "mobile")
    private Integer mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowers")
    private Collection<BorrowersBooks> borrowersBooksCollection;

    public Borrowers() {
    }

    public Borrowers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlTransient
    public Collection<BorrowersBooks> getBorrowersBooksCollection() {
        return borrowersBooksCollection;
    }

    public void setBorrowersBooksCollection(Collection<BorrowersBooks> borrowersBooksCollection) {
        this.borrowersBooksCollection = borrowersBooksCollection;
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
        if (!(object instanceof Borrowers)) {
            return false;
        }
        Borrowers other = (Borrowers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libary.Borrowers[ id=" + id + " ]";
    }
    
}
