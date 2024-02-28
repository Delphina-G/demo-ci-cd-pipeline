package com.example.paginationandsorting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepo;
	
	@GetMapping("/fetchAll")
	public List<Customer> fetchAll(){
		return (List<Customer>) customerRepo.findAll();
	}
	
	
	@GetMapping("/findCustomerByPagination")
	public Page<Customer> findCustomerByPagination(@RequestParam("offSet")Integer offSet,@RequestParam("size")Integer size) {
		return customerRepo.findAll(PageRequest.of(offSet, size));
	}
	
}
