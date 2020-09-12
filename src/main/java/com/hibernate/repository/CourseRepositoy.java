package com.hibernate.repository;/* 
@Author : Yogesh Deshmukh
*/

import com.hibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepositoy {

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        if(course.getId() == null)
            entityManager.persist(course);
        else
            entityManager.merge(course);

        return course;
    }

}
