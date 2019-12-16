package hu.me.lev.BookExample.controller;

import hu.me.lev.BookExample.persist.AuthorerEntity;
import hu.me.lev.BookExample.service.AuthorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorerController {
    private AuthorerService authorerService;

    @Autowired
    public AuthorerController(AuthorerService authorerService){
        this.authorerService = authorerService;
    }
    @PostMapping("addMan")
    @ResponseBody
    public void addAuthorer(@Valid @RequestBody AuthorerEntity authorerEntity, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
        }
        authorerService.addAuthorer(authorerEntity);
    }
    @GetMapping("getAllMan")
    @ResponseBody
    public List<AuthorerEntity> authorerEntities(){
        return authorerService.getAuthorers();
    }
}
