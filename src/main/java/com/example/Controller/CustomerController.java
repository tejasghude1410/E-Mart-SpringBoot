package com.example.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Entity.Auth;
import com.example.Entity.Customer;
import com.example.managers.CustomerManager;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin()
public class CustomerController {
	
	@Autowired
	private CustomerManager customerManager;
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers()
	{
		return new ResponseEntity<>(customerManager.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/{CustomerId}")
	public ResponseEntity<?> getCustomerById(@PathVariable int CustomerId )
	{
		return new ResponseEntity<>(customerManager.getCustomerById(CustomerId),HttpStatus.OK);
	}
	
	@GetMapping("/byEmail/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Optional<Customer> customer = customerManager.getCustomerByEmail(email);
        
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@GetMapping("/prime")
    public ResponseEntity<List<Customer>> getPrimeCustomers() {
        List<Customer> primeCustomers = customerManager.getPrimeCustomers();
        return new ResponseEntity<>(primeCustomers,HttpStatus.OK);
    }
	
	
	@PostMapping
	public  ResponseEntity<?>AddCustomer(@RequestBody Customer c)
	{
		return new ResponseEntity<>(customerManager.saveCustomer(c),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Customerid}")
	public ResponseEntity<?> EditCustomer(@RequestBody Customer c,@PathVariable int id )
	{
		return new ResponseEntity<>(customerManager.update(c, id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Customerid}")
	public void deleteCustomer(@PathVariable int id)
	{
		customerManager.deleteCustomer(id);
	}
	
	@PostMapping("/check")
	public int checkCust(@RequestBody Auth a) {
		return customerManager.checkCust(a.getCustEmail(), a.getCustPassword());
	}
	
	@GetMapping("/isCardHolder/{cid}")
    public boolean checkCardHolder(@PathVariable int cid) {
        
        return customerManager.checkCardHolder(cid);
    }
	
	@GetMapping("/points/{cid}")
    public int getPointsByID(@PathVariable int cid) {
        
        return customerManager.getPointsByID(cid);
    }
	
	@PutMapping("/points/{cid}")
	public ResponseEntity<?> updateCustomerPoints(@PathVariable int cid, @RequestBody String points) {
	    try {
	        
	        int parsedPoints = Integer.parseInt(points);
	        
	        customerManager.updatePoints(cid, parsedPoints);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NumberFormatException e) {	        
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	

}