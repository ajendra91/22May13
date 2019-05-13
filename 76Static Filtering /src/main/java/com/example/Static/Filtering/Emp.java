package com.example.Static.Filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value= {"id","age"})
public class Emp {

    public int id;
    public String name;
    //@JsonIgnore
    public String age;
}
