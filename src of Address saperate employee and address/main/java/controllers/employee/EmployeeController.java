package controllers.employee;     
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.employee.Employee;
import dao.EmployeeDAO;   


@Controller
@RequestMapping("/employeePortal")
public class EmployeeController {    
    //will inject dao from XML file    
        
    /*It displays a form to input data, here "command" is a reserved request attribute  
     *which is used to display object data into form  
     */    
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Employee());
        return "employee/empform";   
    }    
    /*It saves object into database. The @ModelAttribute puts request data  
     *  into model object. You need to mention RequestMethod.POST method   
     *  because default request is GET*/    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Employee employee){
    	System.out.println(employee);
        EmployeeDAO.setEmployee(employee);    
        return "redirect:/employeePortal/employee/viewemp";//will redirect to viewemp request mapping    
    }    
    /* It provides list of employees in model object */    
    @RequestMapping("/employee/viewemp")    
    public String viewemp(Model m){    
        List<Employee> list=EmployeeDAO.getEmployee();    
        m.addAttribute("list",list);  
        return "/employee/viewemp";    
    }    
    /* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/    
    /*@RequestMapping(value="/editemp/{id}")    
    public String edit(@PathVariable int id, Model m){    
    	Employee employee=EmployeeDAO.getEmpById(id);    
        m.addAttribute("command",employee);  
        return "empeditform";    
    }    
     It updates model object.     
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Employee employee){    
        dao.update(employee);    
        return "redirect:/viewemp";    
    }    
     It deletes record for the given id in URL and redirects to /viewemp     
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewemp";    
    }     */
}  