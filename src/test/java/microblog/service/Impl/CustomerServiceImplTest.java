package microblog.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import microblog.model.Customer;
import microblog.repo.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

  @Autowired
  private CustomerRepository customerRepository;

  @Test
  public void getCustomerList() throws Exception {

    customerRepository.deleteAll();
    customerRepository.save(new Customer("Alice", "Smith"));
    customerRepository.save(new Customer("Bob", "Smith"));


    for(Customer customer : this.customerRepository.findByLastName("Smith")) {
      System.out.println(customer);
    }
  }

}