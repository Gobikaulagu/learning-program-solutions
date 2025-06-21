 // DependencyInjectionExample.java

// Repository Interface
interface CustomerRepository {
    String findCustomerById(String id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        // Simulate fetching from a database
        if (id.equals("C001")) {
            return "Customer: Alice";
        } else if (id.equals("C002")) {
            return "Customer: Bob";
        } else {
            return "Customer not found";
        }
    }
}

// Service Class
class CustomerService {
    private CustomerRepository repository;
    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    public void displayCustomer(String id) {
        String customer = repository.findCustomerById(id);
        System.out.println(customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.displayCustomer("C001");
        service.displayCustomer("C002");
        service.displayCustomer("C999");
    }
}
