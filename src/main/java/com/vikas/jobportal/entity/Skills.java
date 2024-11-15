package com.vikas.jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String experiencelevel;
    private String yearsOfExperience;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_seeker_profile")
    private JobSeekerprofile jobSeekerprofile;

    public Skills() {
    }

    public Skills(int id, String name, String experiencelevel, String yearsOfExperience, JobSeekerprofile jobSeekerprofile) {
        this.id = id;
        this.name = name;
        this.experiencelevel = experiencelevel;
        this.yearsOfExperience = yearsOfExperience;
        this.jobSeekerprofile = jobSeekerprofile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperiencelevel() {
        return experiencelevel;
    }

    public void setExperiencelevel(String experiencelevel) {
        this.experiencelevel = experiencelevel;
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public JobSeekerprofile getJobSeekerprofile() {
        return jobSeekerprofile;
    }

    public void setJobSeekerprofile(JobSeekerprofile jobSeekerprofile) {
        this.jobSeekerprofile = jobSeekerprofile;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experiencelevel='" + experiencelevel + '\'' +
                ", yearsOfExperience='" + yearsOfExperience + '\'' +
                ", jobSeekerprofile=" + jobSeekerprofile +
                '}';
    }
}
