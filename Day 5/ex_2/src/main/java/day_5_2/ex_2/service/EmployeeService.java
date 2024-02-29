package day_5_2.ex_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day_5_2.ex_2.model.Employee;
import day_5_2.ex_2.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo ;
    public boolean postEmployee(Employee employee)
    {
        try {
            employeeRepo.save(employee);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public Employee getEmployee(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
    public boolean putEmployee(int id , Employee employee)
    {
        if(this.getEmployee(id) == null)
        {
            return false;
        }
        try {
            employeeRepo.save(employee);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployee(id) == null)
        {
            return false;
        }
        try {
            employeeRepo.deleteById(id);
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        return true;
    }

}
