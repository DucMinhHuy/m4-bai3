package con.thuchanh1.sevice;

import con.thuchanh1.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
     private static final Map<Integer, Customer>customers;
     static {
         customers=new HashMap<>();
         customers.put(1,new Customer("huy",1,"ducminhhuy@gmail.com","thai binh"));
         customers.put(2,new Customer("chủ tịch núi rừng hùng",2,"nguyenduyhung@gmail.com","yen bai"));
         customers.put(3,new Customer("giám đốc khai thác thanp phong",3,"@gmail.com","bãi than"));
         customers.put(4,new Customer("kĩ sư thiên tài lương",4,"vuhienluong@gmail.com","quan họ"));
         customers.put(5,new Customer("bông hồng bên đèn",5,"linhtup@gmail.com","hà nội"));
         customers.put(6,new Customer("chủ tịch rì sọt trung",6,"trung@gmail.com","thai binh"));

     }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
         customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
     return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
         customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
         customers.remove(id);
    }
}
