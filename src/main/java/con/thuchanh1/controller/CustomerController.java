package con.thuchanh1.controller;

import con.thuchanh1.model.Customer;
import con.thuchanh1.sevice.CustomerService;
import con.thuchanh1.sevice.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    public final ICustomerService customerService=new CustomerService();
    @GetMapping("")
    public String index(Model model){
        List<Customer> customersList=customerService.findAll();
        model.addAttribute("customers",customersList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer){
        customer.setId((int) (Math.random()*100));
        customerService.save(customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Customer customer){
        customerService.update(customer.getId(),customer);
        return "redirect:/customer";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addAttribute("success","removed customer");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "/view";
    }

}
