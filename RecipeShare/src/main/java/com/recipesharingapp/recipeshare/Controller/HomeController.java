package com.recipesharingapp.recipeshare.Controller;
import com.recipesharingapp.recipeshare.Model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("")
    public    String HelloWorld(){
        return "String";
    }
}
