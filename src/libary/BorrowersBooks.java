/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "borrowers_books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BorrowersBooks.findAll", query = "SELECT b FROM BorrowersBooks b")
    , @NamedQuery(name = "BorrowersBooks.findByBookId", query = "SELECT b FROM BorrowersBooks b WHERE b.borrowersBooksPK.bookId = :bookId")
    , @NamedQuery(name = "BorrowersBooks.findByBorrowerId", query = "SELECT b FROM BorrowersBooks b WHERE b.borrowersBooksPK.borrowerId = :borrowerId")
    , @NamedQuery(name = "BorrowersBooks.findByBorrowDate", query = "SELECT b FROM BorrowersBooks b WHERE b.borrowDate = :borrowDate")
    })
public class BorrowersBooks implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BorrowersBooksPK borrowersBooksPK;
    @Column(name = "borrowDate")
    @Temporal(TemporalType.DATE)
    private Date borrowDate;
    @JoinColumn(name = "book_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "borrower_id", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Borrowers borrowers;

    public BorrowersBooks() {
        this.books=new Books();
        this.borrowers = new Borrowers();
    }

    public BorrowersBooks(BorrowersBooksPK borrowersBooksPK) {
        this.borrowersBooksPK = borrowersBooksPK;
    }

    public BorrowersBooks(int bookId, int borrowerId) {
        this.borrowersBooksPK = new BorrowersBooksPK(bookId, borrowerId);
    }

    public BorrowersBooksPK getBorrowersBooksPK() {
        return borrowersBooksPK;
    }

    public void setBorrowersBooksPK(BorrowersBooksPK borrowersBooksPK) {
        this.borrowersBooksPK = borrowersBooksPK;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Borrowers getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Borrowers borrowers) {
        this.borrowers = borrowers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowersBooksPK != null ? borrowersBooksPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowersBooks)) {
            return false;
        }
        BorrowersBooks other = (BorrowersBooks) object;
        if ((this.borrowersBooksPK == null && other.borrowersBooksPK != null) || (this.borrowersBooksPK != null && !this.borrowersBooksPK.equals(other.borrowersBooksPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libary.BorrowersBooks[ borrowersBooksPK=" + borrowersBooksPK + " ]";
    }
    
}
