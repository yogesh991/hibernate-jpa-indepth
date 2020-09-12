package com.hibernate.repository;

import com.hibernate.HibernateJpaDepthApplication;
import com.hibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/* 
@Author : Yogesh Deshmukh
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes= HibernateJpaDepthApplication.class)
class CourseRepositoyTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepositoy courseRepositoy;

    @Test
    public void findById_basicTest(){

        Course course = courseRepositoy.findById(10001L);
        assertEquals("Java",course.getName());

    }

    @Test
    //@DirtiesContext
    public void saveTest(){
        Course course = courseRepositoy.findById(10002L);
        if(course == null){
            course = new Course(10002L,"Hibernate - Updated");
        }
        assertEquals("Hibernate - Updated",courseRepositoy.save(course).getName());
        courseRepositoy.deleteById(10002L);
        assertNull(courseRepositoy.findById(10002L));
    }

    @Test
    //@DirtiesContext
    public void deleteByIdTest(){

        courseRepositoy.deleteById(2L);
        assertNull(courseRepositoy.findById(2L));

    }
}