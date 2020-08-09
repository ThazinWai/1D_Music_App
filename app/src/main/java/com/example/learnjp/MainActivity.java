package com.example.learnjp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CardView cardView1,cardView2,cardView3;

    AlertDialog alertDialog;
    AlertDialog.Builder builder;


@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);


    toolbar=findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    //AlertDialog
    builder=new AlertDialog.Builder(MainActivity.this);


    builder.setMessage("New Music Video Out Now!!!");
    builder.setPositiveButton("Check in", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            System.out.println("Click Check in");
        }
    });

    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            System.out.println("Click Cancel");
        }
    });

    alertDialog=builder.create();
    alertDialog.show();



    //CardView

    cardView1=(CardView)findViewById(R.id.idCardView1);
    cardView2=findViewById(R.id.idCardView2);
    cardView3=findViewById(R.id.idCardView3);

    cardView1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intent);
        }
    });

    cardView2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    });

    cardView3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        }
    });



    //Navigation
    drawerLayout=findViewById(R.id.drawerLayout);
    navigationView=findViewById(R.id.navigation_view);

    ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
    drawerLayout.setDrawerListener(toogle);
    toogle.syncState();

    navigationView.setNavigationItemSelectedListener(this);


    GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);


}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        switch (itemId) {
            case R.id.idHome:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                break;

            case R.id.idSongs:
               // Toast.makeText(getApplicationContext(), "Starred", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                break;

            case R.id.idAlbums:
//                Toast.makeText(getApplicationContext(), "Sent", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent1);
                break;

            case R.id.idMusicVideo:
                Toast.makeText(getApplicationContext(), "Draft", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idWallpaper:
                Toast.makeText(getApplicationContext(), "All Mail", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idNews:
                Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_SHORT).show();
                break;

            case R.id.idAbout:
                Toast.makeText(getApplicationContext(), "Spam", Toast.LENGTH_SHORT).show();
                break;
        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
}
