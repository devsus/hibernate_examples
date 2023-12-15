package com.manytomany;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "projects_many_to_many")
public class Project {

 private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "project_id")
    @GeneratedValue
    private Long projectId;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "projects", cascade = { CascadeType.ALL })
    private Set<Employeem> employees = new HashSet<Employeem>();
    
    public Project() {
        super();
    }

    public Project(String title) {
        this.title = title;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employeem> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employeem> employees) {
        this.employees = employees;
    }
}
