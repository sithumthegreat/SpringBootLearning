package com.ijse.hello.service;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.hello.repository.ClassRepository;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired 
    private ClassRepository classRepository;

    @Override
    public List<Class> getAllClasses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClasses'");
    }

    @Override
    public Class createClass(Class classes) {
        // TODO Auto-generated method stub
        return classRepository.save(classes);
    }

    @Override
    public Class getClassById(Long classId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassById'");
    }


}
