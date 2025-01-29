package com.springbootacademy.batch6POS.dto;

import java.util.ArrayList;

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAdress;
    private double customerSalary;
    private String customerNic;
    private ArrayList contactNumber;
    private boolean activeState;

    public CustomerDTO(int customerId, String customerName, String customerAdress, double customerSalary, String customerNic, ArrayList contactNumber, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
        this.customerNic = customerNic;
        this.contactNumber = contactNumber;
        this.activeState = activeState;
    }

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

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAdress='" + customerAdress + '\'' +
                ", customerSalary=" + customerSalary +
                ", customerNic='" + customerNic + '\'' +
                ", contactNumber=" + contactNumber +
                ", activeState=" + activeState +
                '}';
    }

    public CustomerDTO() {
    }
}
