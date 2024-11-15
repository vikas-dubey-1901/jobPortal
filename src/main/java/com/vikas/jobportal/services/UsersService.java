package com.vikas.jobportal.services;

import com.vikas.jobportal.entity.JobSeekerprofile;
import com.vikas.jobportal.entity.RecruiterProfile;
import com.vikas.jobportal.entity.Users;
import com.vikas.jobportal.repository.JobSeekerProfileRepository;
import com.vikas.jobportal.repository.RecruiterProfileRepository;
import com.vikas.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private JobSeekerProfileRepository jobSeekerProfileRepository;
    private RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository , JobSeekerProfileRepository jobSeekerProfileRepository,
                        RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        Users savedUsers = usersRepository.save(users);
        int userTypeID = users.getUserTypeId().getUserTypeId();
        if(userTypeID == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerprofile(savedUsers));
        }
        return savedUsers;
    }

    public Optional<Users> findByEmail(String email){
       return usersRepository.findByEmail(email);
    }
}
