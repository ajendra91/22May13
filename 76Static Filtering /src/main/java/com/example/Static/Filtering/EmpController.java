package com.example.Static.Filtering;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    public List<Emp> lst=new ArrayList<Emp>(Arrays.asList(
            new Emp(1,"java","10"),new Emp(2,"php","10"),new Emp(3,"dot","10")
    ));

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Emp> getAll(){
        return lst;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(@RequestBody Emp emp){
        lst.add(emp);
    }

   @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Emp getId(@PathVariable int id){
        return lst.get(id);
    }
}
