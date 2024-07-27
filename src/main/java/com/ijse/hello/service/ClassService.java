package com.ijse.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ClassService {
    List<Class>  getAllClasses();
    Class createClass(Class classes);
    Class getClassById(Long classId);

}
