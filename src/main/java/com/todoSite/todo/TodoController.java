package com.todoSite.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    // this is for 1st page
    @GetMapping
    //Model is the type of container that helps us to
    // pass data from the controller to the view
    public String getTasks(Model model) {
        //List type is that because its file will return that kind of obj hence to store it
        List<Todo> tasks = todoService.getAllTasks();

        // "tasks" is the attribute name you’ll use in your template
        // tasks is the actual data (List<>).
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    // this is for the 2nd page
    @GetMapping("/doneTasks")
    public String getCompletedTasks(Model model) {
        List<Todo> tasks = todoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "doneTasks";
    }

    @PostMapping
    // the name of the string in @ReqParam must match the name of the input in html file
    public String createTask(@RequestParam String taskTitle) {
        todoService.createTask(taskTitle);
        return "redirect:/";
    }

    @GetMapping ("{id}/delete")
    public String deleteTask(@PathVariable int id) {
        todoService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping ("{id}/deleteDoneTask")
    public String deleteDoneTask(@PathVariable int id) {
        todoService.deleteTask(id);
        return "redirect:/doneTasks";
    }

    @GetMapping ("{id}/done")
    public String doneTask(@PathVariable int id) {
        todoService.mark(id);
        return "redirect:/";
    }
}
