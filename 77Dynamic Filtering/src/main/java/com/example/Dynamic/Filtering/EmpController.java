package com.example.Dynamic.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public MappingJacksonValue getId(@PathVariable int id){

        Emp emp=lst.get(id);
        //create filter
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("id","age");
        //create filter provider
        FilterProvider filters=new SimpleFilterProvider().addFilter("filteredForEmp", filter);
        //Create mapping jackson abject to serialize and set/apply filters to user bean
        MappingJacksonValue mapping= new MappingJacksonValue(emp);
        mapping.setFilters(filters);
        return mapping;

    }

    @GetMapping("/filter1")
    public MappingJacksonValue getFilterData1() {

        Fields ff = new Fields("11", "22", "33");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("field-filter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(ff);
        mapping.setFilters(filters);
        return mapping;
    }

}
