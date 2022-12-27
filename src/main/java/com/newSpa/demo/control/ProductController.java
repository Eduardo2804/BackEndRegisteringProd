package com.newSpa.demo.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newSpa.demo.model.ProductModel;
import com.newSpa.demo.model.ResponseModel;
import com.newSpa.demo.service.ProductService;

@RestController
@CrossOrigin(origins =  {"*"}, maxAge = 4800, allowCredentials = "false") //solving the cors problem ...with this notation the api is unable for all ports
public class ProductController {


    @Autowired
    private ProductService ps;

    @GetMapping("/list")
    public Iterable<ProductModel>list(){

       return ps.list();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ProductModel pm){

        return ps.registerAlter(pm, "register");
        
    }

    @PutMapping("/alter")
    public ResponseEntity<?> alter(@RequestBody ProductModel pm){

        return ps.registerAlter(pm, "register");
        
    }

    @GetMapping("/")
    public String routes(){

        return "API IS WORKING";
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> delete(@PathVariable int id) {

        return ps.delete(id);
    }
    
}
