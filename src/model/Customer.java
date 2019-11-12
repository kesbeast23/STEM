
package model;

import java.sql.Date;

/**
 *
 * @author Kesego
 */
public class Customer extends Person {
    
    private int customerNumber;
    private Date date;

    public Customer(int customerNumber, Date date, String firstname, String lastname) {
        super(firstname, lastname);
        this.customerNumber = customerNumber;
        this.date = date;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
