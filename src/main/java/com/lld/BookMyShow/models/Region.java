package com.lld.BookMyShow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity //makes sure table is created for this class
//in this case it will take class name as table name, else we can do @Entity(name="tablename");
public class Region extends BaseModel{

    private String name;

    @OneToMany
    private List<Theatre> theatre;
}
