package com.tongji.springbootdemo.dao;

import com.tongji.springbootdemo.pojo.Department;
import com.tongji.springbootdemo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees=new HashMap<Integer, Employee>();
        employees.put(101,new Employee(1001,"A","1@qq.com",1,new Department(101,"市场部")));
        employees.put(102,new Employee(1002,"B","2@qq.com",0,new Department(101,"市场部")));
        employees.put(103,new Employee(1003,"C","3@qq.com",1,new Department(101,"市场部")));
        employees.put(104,new Employee(1004,"D","4@qq.com",0,new Department(101,"市场部")));
        employees.put(105,new Employee(1005,"E","5@qq.com",1,new Department(101,"市场部")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getEmployee(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
