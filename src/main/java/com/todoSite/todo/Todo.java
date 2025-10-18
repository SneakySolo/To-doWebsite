package com.todoSite.todo;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data// (a part of Lombok due to which no need for getter, setters, etc.
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String task;
    public String status;
}
