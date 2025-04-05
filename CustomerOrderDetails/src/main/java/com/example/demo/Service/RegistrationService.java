package com.example.demo.Service;

import com.example.demo.Model.CustomerInfo;
import com.example.demo.Model.CustomerOrder;
import com.example.demo.Model.Registration;
import com.example.demo.Repository.CustomerInfoRepo;
import com.example.demo.Repository.CustomerOrderRepo;
import com.example.demo.Repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
  private RegistrationRepo registrationRepo;

    @Autowired
    private CustomerInfoRepo customerInfoRepo;

    @Autowired
    private CustomerOrderRepo customerOrderRepo;


    public int addCustomer(Registration register) {
        if (register.getRegistrationDate() == null){
            register.setRegistrationDate(LocalDateTime.now());
        }
       Registration retnVal = registrationRepo.save(register);
       return retnVal.getId();
    }

    public void addCustomer(CustomerInfo info) {
        customerInfoRepo.save(info);
    }


    //order product with name and same id

    public int getIdByName(String getName) {
        Registration returned =  registrationRepo.findIdByName(getName);
        return returned.getId();
    }

    public void addProductDetails(CustomerOrder orderDetails) {
        if (orderDetails.getOrderDate()==null){
            orderDetails.setOrderDate(LocalDateTime.now());

        }
        customerOrderRepo.save(orderDetails);

    }

    //get userDetails

    public List<CustomerInfo> getUserDetails() {
        return customerInfoRepo.findAll();
    }

    //get orderDetails
    public List<CustomerOrder> getOrderDetails() {
        return customerOrderRepo.findAll();
    }


    public void updateCustomerInfo(CustomerInfo customerInfo) {
        customerInfoRepo.save(customerInfo);
    }}
