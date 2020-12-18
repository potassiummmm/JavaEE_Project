package com.tongji.springbootdemo.dao;

import com.tongji.springbootdemo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> department=null;
    static{
        department=new HashMap<Integer, Department>();
        department.put(101,new Department(101,"教学"));
        department.put(102,new Department(102,"市场"));
        department.put(103,new Department(103,"教研"));
        department.put(104,new Department(104,"运营"));
        department.put(105,new Department(105,"后勤"));
    }

    public Collection<Department> getDepartments(){
        return department.values();
    }

    public Department getDepartmentById(Integer id){
        return department.get(id);
    }
}
