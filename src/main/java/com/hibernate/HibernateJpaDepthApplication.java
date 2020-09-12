package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.repository.CourseRepositoy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateJpaDepthApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepositoy courseRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(" Find By id method -> {}",courseRepositoy.findById(10001L));
		//courseRepositoy.deleteById(10001L);
		courseRepositoy.save(new Course(10002L,"Hibernate"));

	}
}
