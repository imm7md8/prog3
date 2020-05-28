/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libary;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author HP
 */
@Embeddable
public class BorrowersBooksPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @Column(name = "borrower_id")
    private int borrowerId;

    public BorrowersBooksPK() {
    }

    public BorrowersBooksPK(int bookId, int borrowerId) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bookId;
        hash += (int) borrowerId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowersBooksPK)) {
            return false;
        }
        BorrowersBooksPK other = (BorrowersBooksPK) object;
        if (this.bookId != other.bookId) {
            return false;
        }
        if (this.borrowerId != other.borrowerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libary.BorrowersBooksPK[ bookId=" + bookId + ", borrowerId=" + borrowerId + " ]";
    }
    
}
