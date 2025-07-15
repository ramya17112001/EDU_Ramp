package com.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.Course;
import com.course.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	public Optional<Course> getCourseById(Long id) {
		return courseRepository.findById(id);
	}

	public Course updateCourse(Long id, Course courseDetails) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course not found with id " + id));
		course.setName(courseDetails.getName());
		return courseRepository.save(course);
	}

	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}
}
