package com.student_management_system.Controller;
import com.student_management_system.Model.Student;
import com.student_management_system.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

     @GetMapping("/")
    public String home()
    {
        return "students";
    }

    @GetMapping("/students")
    public String getAllStudents( Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model)
    {
        Student student = new Student();
        model.addAttribute("students",student);

        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("students") Student student)

            
    {
            studentService.saveStudent(student);
            return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id , Model model){
       model.addAttribute("student",studentService.getById(id));
         return "edit-student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id , @ModelAttribute("student") Student student)
    {
        Student existingStudent = studentService.getById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id)
    {
        studentService.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/students/details/{id}")
    public String detailsById(@PathVariable int id ,Model model)
    {
        model.addAttribute("student",studentService.getById(id));
        return "students-details";
    }
}

