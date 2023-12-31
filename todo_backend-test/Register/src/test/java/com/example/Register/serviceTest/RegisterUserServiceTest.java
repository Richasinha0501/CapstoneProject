package com.example.Register.serviceTest;

import com.example.exception.UserAlreadyExistException;
import com.example.model.Task;
import com.example.model.User;
import com.example.repo.RegisterRepo;
import com.example.service.RegisterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterUserServiceTest {

    @Mock
    private RegisterRepo registerRepo;

    @InjectMocks
    private RegisterServiceImpl registerService;

    private User user;
    private Task task;
    Task task1;

    @BeforeEach
    public void setup(){
        task=new Task(1,"T1","Basic java","","work", LocalDate.now(),"low","red");
        task1=new Task(2,"T1","Python","","work",LocalDate.now(),"low","Yellow");
        List<Task> newTaskList=new ArrayList();
        newTaskList.add(task);
        newTaskList.add(task1);
        user=new User("mahajanasmita7@gmail.com","asmita","","8552453620","AsmitaMahajan", newTaskList);
    }

    @Test
    public void registerUser() throws UserAlreadyExistException {
        when(registerRepo.save(ArgumentMatchers.<User>any())).thenReturn(user);
        assertEquals(user,registerService.registerUser1(user));
    }
}
