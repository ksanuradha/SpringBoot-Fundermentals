package com.springbootacademy.batch6POS.service.impl;

import com.springbootacademy.batch6POS.dto.CustomerDTO;
import com.springbootacademy.batch6POS.dto.request.RequestUpdateCustomerDto;
import com.springbootacademy.batch6POS.entity.Customer;
import com.springbootacademy.batch6POS.repo.CustomerRepo;
import com.springbootacademy.batch6POS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAdress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getCustomerNic(),
                customerDTO.getContactNumber(),
                customerDTO.isActiveState()
        );
        if (customerRepo.existsById(customer.getCustomerId())) {
            throw new DuplicateKeyException("Customer Allready exist");
        } else {
            customerRepo.save(customer);
            return customer.toString();
        }
    }

    @Override
    public String updateCustomer(RequestUpdateCustomerDto customerDTO) {
        int updateCustomer = customerRepo.updateCustomer(customerDTO.getCustomerId(), customerDTO.getCustomerName(), customerDTO.getCustomerAdress(), customerDTO.getCustomerSalary());
        return updateCustomer+"";
    }

    @Override
    public String updateCustomerInSpring(RequestUpdateCustomerDto customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());
            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAdress(customerDTO.getCustomerAdress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customerRepo.save(customer);
            return "Saved " + customerDTO.getCustomerId() + " " + customerDTO.getCustomerName();
        } else {
            throw new RuntimeException("Customer Not In Database");

        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customerRepo.getById(customerId);
        if (customer!=null) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAdress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Customer Not In Database");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer>getCustomer = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getCustomer) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAdress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
       if (customerRepo.existsById(customerId)) {
           customerRepo.deleteById(customerId);
           return "delete sucess";
       } else {
           return "No Customer Found By ID";
       }
    }

    @Override
    public CustomerDTO getCustomerByNic(String nic) {
        Optional<Customer> customer = customerRepo.findByCustomerNicEquals(nic);
        if (customer.isPresent()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAdress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getCustomerNic(),
                    customer.get().getContactNumber(),
                    customer.get().isActiveState()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByState(boolean status) {
        List<Customer>getCustomer = customerRepo.findAllByActiveStateEquals(status);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getCustomer) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAdress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public List<CustomerDTO> getAllCustomersByStateAndName(String name) {
        List<Customer>getCustomer = customerRepo.findAllByCustomerNameEqualsAndActiveStateEquals(name,true);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : getCustomer) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAdress(),
                    customer.getCustomerSalary(),
                    customer.getCustomerNic(),
                    customer.getContactNumber(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
