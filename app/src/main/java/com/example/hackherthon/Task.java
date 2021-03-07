package com.example.hackherthon;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Task {

    private String type;
    private String address;
    private String comments;
    private Integer id;
    private String IsolatedUserId;

    public Task(Integer id,String IsolatedUserId, String type, String address, String comments){
        this.id = id;
        this.IsolatedUserId = IsolatedUserId;
        this.type = type;
        this.address = address;
        this.comments = comments;
    }

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("server/saving-data/fireblog");

    DatabaseReference tasksRef = ref.child("Tasks");

    Map<String, Object> tasks = new HashMap<String, Object>();
    Task task = new Task(1,"1","Grocery Pick Up", "HOme","");
    tasks.put("Entry", task);
    tasksRef.setValueAsync(tasks);


    }
