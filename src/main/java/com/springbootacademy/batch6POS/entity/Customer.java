package com.springbootacademy.batch6POS.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "customer")
@TypeDefs(
        @TypeDef(name = "json", typeClass = JsonType.class)
)
public class Customer {
    @Id
    @Column(name = "customer_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100 , nullable = false)
    private String customerName;

    @Column(name = "customer_adress")
    private String customerAdress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "customer_nic")
    private String customerNic;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="customers")
    private Set<Order> orders;

    public Customer() { }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isActiveState() {
        return activeState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAdress='" + customerAdress + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerNic='" + customerNic + '\'' +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    public Customer(int customerId, String customerName, String customerAdress, double customerSalary, String customerNic, ArrayList contactNumber, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
        this.customerNic = customerNic;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

    public Customer(String customerName, String customerAdress, double customerSalary, String customerNic, ArrayList contactNumber, boolean activeState) {
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
        this.customerNic = customerNic;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }
}
