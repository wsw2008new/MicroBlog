package microblog.service.Impl;

import microblog.model.Customer;
import microblog.repo.CustomerRepository;
import microblog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;


  @Override
  public List<Customer> getCustomerList() {
    return this.customerRepository.findAll();
  }
}
