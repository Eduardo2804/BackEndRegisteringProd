package com.newSpa.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.newSpa.demo.model.ProductModel;
import com.newSpa.demo.model.ResponseModel;
import com.newSpa.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    public ResponseModel rm;

    //public method list all products
    public Iterable <ProductModel> list(){

    return pr.findAll();

    }

    

    //public method register or alter product
    public ResponseEntity<?>registerAlter (ProductModel pm, String action) {
        
        //validations if the name or brand are blank or not
        if(pm.getName().equals("")){
            
            rm.setMessage("Enter a name");

            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        else if(pm.getBrand().equals("")){

            rm.setMessage("enter a brand");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        else {
            if (action.equals("register")){
            return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.CREATED);
        }

        else {
             return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.OK);
        
        }

    }


    
    
    }
    //delete method
    public ResponseEntity<ResponseModel> delete(int id) {

        pr.deleteById(id);

        rm.setMessage("Item has been deleted");

        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
        

        }


    }

