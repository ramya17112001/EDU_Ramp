package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.Course;
import com.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	// Create
	@PostMapping("/add")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.save(course));
	}

	// Read All
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllCourses() {
		return ResponseEntity.ok(courseService.getAllCourses());
	}

	// Read by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
		return ResponseEntity.ok(courseService.updateCourse(id, courseDetails));
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
		return ResponseEntity.ok("Course deleted successfully");
	}
}
