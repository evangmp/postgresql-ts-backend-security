package com.example.jenpeupu.controller;

import com.example.jenpeupu.model.Task;
import com.example.jenpeupu.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class TasksController {

    private final TaskService taskService;


    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Fetches all the employees in the employee table
     * @return List of Employees
     */
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }


    /**
     * This method is called when a GET request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Fetches employee with the given id
     * @param id - employee id
     * @return Employee with the given id
     */
    @GetMapping("/clients/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    /**
     * This method is called when a POST request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Save an Employee entity
     * @param - Request body is an Employee entity
     * @return Saved Employee entity
     */
    @PostMapping("/clients")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.saveTask(task));
    }
    /*
    @RequestBody Task task
    ResponseEntity.ok().body(taskService.saveTask(task));

    ResponseEntity.ok().body(taskService.saveTask(name, discipline));
    @RequestParam(value="name", required = false) String name, @RequestParam(value="discipline", required = false) String discipline
     */

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/
     * Purpose: Update an Employee entity
     * @param - Employee entity to be updated
     * @return Updated Employee
     */
    @PutMapping("/clients/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok().body(taskService.updateTask(task));
    }

    /**
     * This method is called when a PUT request is made
     * URL: localhost:8080/employee/v1/1 (or any other id)
     * Purpose: Delete an Employee entity
     * @param id - employee's id to be deleted
     * @return a String message indicating employee record has been deleted successfully
     */
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Integer id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().body("deleted employee yes");
    }
}
