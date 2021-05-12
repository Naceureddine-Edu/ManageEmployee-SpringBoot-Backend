package ma.emsiedu.employeemanager.services;

import ma.emsiedu.employeemanager.exceptions.UserNotFoundException;
import ma.emsiedu.employeemanager.models.Employee;
import ma.emsiedu.employeemanager.repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> employeesList()
    {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> findEmployeeById1(Long id)
    {
        return employeeRepository.findById(id);
    }

    public Employee findEmployeeById2(Long id)
    {
        return employeeRepository.findEmployeeById(id)
                                 .orElseThrow(() ->
                                  new UserNotFoundException("User With id :"+id+" Was Not Found"));
    }
}
