package com.example.android.weekendproject1;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CreateLogIn extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private EditText password;
    private EditText name;
    private static final String DEFAULT_NAME = "";

    private CharSequence msg ="";//copy
    private ListView listView;//copy
    private DrawerLayout drawerLayout;//copy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_log_in);
        password =(EditText) findViewById(R.id.etPassword);
        name = (EditText) findViewById(R.id.etName);
        drawerLayout = (DrawerLayout) findViewById(R.id.loDrawerLayout);//copy
        listView =(ListView) findViewById(R.id.lvMenus);//copy
        listView.setOnItemClickListener(this);//copy
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);//copy
        setSupportActionBar(myToolbar);//copy
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }


    public void CreateAccount(View view) {
        PrefsManager.SetName(name.getText().toString());
        PrefsManager.SetPassword(password.getText().toString());
        CharSequence msg = "Info Saved";
        int time = Toast.LENGTH_SHORT;
        Toast saveInfoMsg = Toast.makeText(this,msg,time);
        saveInfoMsg.show();
        finish();
    }

    @Override// copy
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(PrefsManager.GetLogedInName().equals(DEFAULT_NAME)){
            msg = "You must log in to use this feature";

        }else {
            switch (position) {

                case 0://menu
                    msg = "Going to Menu";
                    //msg = "You are already There";
                    Intent goingToMenuIntent = new Intent(CreateLogIn.this,Menu.class);
                    startActivity(goingToMenuIntent);
                    break;
                case 1://phone
                    msg = "Going to Phone";
                    //msg = "You are already There";
                    Intent goingToPhoneIntent = new Intent(CreateLogIn.this,PhoneCall.class);
                    startActivity(goingToPhoneIntent);
                    break;
                case 2://camera
                    msg = "Going to Camera";
                    //msg = "You are already There";
                    Intent goingToCameraIntent = new Intent(CreateLogIn.this,Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case 3://gallery
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(CreateLogIn.this,Gallery.class);
                    startActivity(goingToGalleryIntent);
                    break;
                case 4://internet
                    msg = "Going to Internet";
                    //msg = "You are already There";
                    Intent goingToInternetIntent = new Intent(CreateLogIn.this,Internet.class);
                    startActivity(goingToInternetIntent);
                    break;
                case 5://fun
                    msg = "Yay Fun";
                    break;
                default:
                    msg = "";

            }
        }
        Toast output = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        output.show();

    }

    @Override//copy
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.actionmenu,menu);
        return true;
    }

    @Override// coy
    public boolean onOptionsItemSelected(MenuItem item) {
        if(PrefsManager.GetLogedInName().equals(DEFAULT_NAME)) {
            msg = "You must log in to use this feature";
        }else{
            switch (item.getItemId()) {

                case R.id.action_settings:
                    msg = "There are no settings so deal with it.";
                case R.id.actionAbout:
                    msg = "This was made by...(data not found)";
                    break;
                case R.id.actionCamera:
                    msg = "Going to Camera";
                    //msg = "You are already There";
                    Intent goingToCameraIntent = new Intent(CreateLogIn.this, Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case R.id.actionGalery:
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(CreateLogIn.this, Gallery.class);
                    startActivity(goingToGalleryIntent);
                    break;
                case R.id.actiionDestruction:
                    msg = "Destruction will begin soon...";
                    break;

                default:
                    finish();
                    return super.onOptionsItemSelected(item);
            }

        }
        Toast actionOuput = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        actionOuput.show();
        return true;


    }
}