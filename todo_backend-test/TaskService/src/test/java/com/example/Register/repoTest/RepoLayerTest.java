package com.example.Register.repoTest;

import com.example.model.Task;
import com.example.model.User;
import com.example.repo.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class RepoLayerTest {

    @Autowired
    private TaskRepo taskRepo;

    private User user;
    private Task task;
    Task task1;

    @BeforeEach
    public void setup(){
        task=new Task(1,"T1","Basic java","work","", LocalDate.now(),"low","red");
        task1=new Task(2,"T1","Python","work","", LocalDate.now(),"low","Yellow");
        List<Task> newTaskList=new ArrayList();
        newTaskList.add(task);
        newTaskList.add(task1);
        user=new User("mahajanasmita7@gmail.com","asmita","","8552453620","AsmitaMahajan", newTaskList);
    }

    @Test
    public void registerUser(){
        taskRepo.save(user);
        User user1=taskRepo.findByEmail(user.getEmail());
        assertNotNull(user1);
        assertEquals(user.getEmail(),user1.getEmail());
    }
}
