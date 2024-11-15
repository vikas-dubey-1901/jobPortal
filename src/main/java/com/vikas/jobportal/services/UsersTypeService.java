package com.vikas.jobportal.services;

import com.vikas.jobportal.entity.UsersType;
import com.vikas.jobportal.repository.UsersTyperepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

    private final UsersTyperepository usersTyperepository;


    public UsersTypeService(UsersTyperepository usersTyperepository) {
        this.usersTyperepository = usersTyperepository;
    }

    public List<UsersType> getAll(){
        return usersTyperepository.findAll();
    }
}
