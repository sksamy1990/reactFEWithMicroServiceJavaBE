package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registration")
    public ResponseEntity<Registration> addCustomer(@RequestBody RegistrationPayload regis){

        //Registration // save the name for the first time
        Registration re = new Registration();
        re.setName(regis.getName());

        String email =regis.getEmail();
        if (email.contains("@") && email.contains("com")){
            System.out.println("yes email is correct");
        }
        else{
            throw new RuntimeException("invalid email address");
        }

        long phoneNumber = regis.getPhoneNumber();
        String ph = String.valueOf(phoneNumber);
        String regex = "^[1-9][0-9]{9}$";

      if (ph.matches(regex)){
            System.out.println("number contain 10 digit");
        }
        else{
            throw new RuntimeException("invalid phone number");
        }

        int savedID = service.addCustomer(re);

        //Customer info
        CustomerInfo info = new CustomerInfo();

        info.setId(savedID);
        info.setAddress(regis.getAddress());
        info.setBirthDate(regis.getBirthDate());
        info.setEmail(regis.getEmail());
        info.setPhoneNumber(regis.getPhoneNumber());

        service.addCustomer(info);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @PostMapping("/orderProduct")
    public ResponseEntity<CustomerOrder> addOrderProduct(@RequestBody CustomerOrderDTO customerOrderDTO){

        //get the name from the registration entity
        String getName = customerOrderDTO.getName();
        int savedID =  service.getIdByName(getName);
        System.out.println(savedID);

        CustomerOrder orderDetails = new CustomerOrder();
        orderDetails.setId(savedID);
        orderDetails.setProductName(customerOrderDTO.getProductName());
        orderDetails.setQuantity(customerOrderDTO.getQuantity());
        service.addProductDetails(orderDetails);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/userDetails")
    public List<CustomerInfo> getUserDetails(@RequestBody CustomerOrderDTO regis){
        return service.getUserDetails();
    }

    @GetMapping("/orderDetails")
    public List<CustomerOrder> getOrderDetails(){
        return service.getOrderDetails();
    }

    @PutMapping("/updateCustomerInfo")
    public void updateCustomerInfo(@RequestBody CustomerInfo customerInfo){
        service.updateCustomerInfo(customerInfo);
    }

}
