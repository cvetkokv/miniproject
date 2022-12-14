package com.example.demo.domain.classes;

import com.example.demo.domain.student.Student;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "classes",indexes = @Index(
        columnList = "name",unique = true,name = "name_index"
))
public class Classes {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "taskSequence", sequenceName = "taskIdSequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "taskSequence")
    private Long id;
    @NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Classes(Classes klas)
    {
        this.name=klas.getName();
        this.students=new ArrayList<>();
    }

}
