package com.example.Dynamic.Filtering;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonFilter("filteredForEmp")
public class Emp {

    public int id;
    public String name;
    public String age;
}
