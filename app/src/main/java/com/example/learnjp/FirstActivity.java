package com.example.learnjp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {


    AlertDialog dialog;
    AlertDialog.Builder builder;
    String result="";



    RecyclerView recyclerView;
    Toolbar toolbar;

    String[] name={

            "Drag Me Down",
            "End of the Day",
            "Hey Angel",
            "History",
            "If I could Fly",
            "Infinity",
            "Long Way Down",
            "Never Enough",
            "Olivia",
            "Perfect",
            "Temporary Fix"
    };

    String[]desc={

            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)",
            "Made in the A.M. (2015)"

    };


    int image[]={


            R.drawable.louis,
            R.drawable.niall,
            R.drawable.zayn,
            R.drawable.liam,
            R.drawable.harry,
            R.drawable.louis,
            R.drawable.liam,
            R.drawable.harry,
            R.drawable.niall,
            R.drawable.zayn,
            R.drawable.louis

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_id);

        List<User> sampleuser=new ArrayList<>();

        for(int i=0; i<name.length; i++){

            User users=new User();

            users.username=name[i];
            users.UserDesc=desc[i];
            users.UserImage=image[i];

            sampleuser.add(users);


        }

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
       // recyclerView.setLayoutManager(gridLayoutManager);


        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(getBaseContext(),sampleuser));







        //ConfirmationDialog
        builder=new AlertDialog.Builder(FirstActivity.this);


        builder.setTitle("Choose Song Type!!");

        builder.setSingleChoiceItems(name, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                 result=name[i];
            }
        });

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Result"+result);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("Click Cancel");
            }
        });

        dialog=builder.create();
        dialog.show();
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
