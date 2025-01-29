package com.springbootacademy.batch6POS.dto.request;

public class RequestUpdateCustomerDto {
    private int customerId;
    private String customerName;
    private String customerAdress;
    private double customerSalary;

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

    public RequestUpdateCustomerDto(int customerId, String customerName, String customerAdress, double customerSalary) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAdress = customerAdress;
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "RequestUpdateCustomerDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAdress='" + customerAdress + '\'' +
                ", customerSalary=" + customerSalary +
                '}';
    }

    public RequestUpdateCustomerDto() {}
}
