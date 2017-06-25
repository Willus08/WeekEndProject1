package com.example.android.weekendproject1;

import android.content.Intent;
import android.graphics.Picture;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button camera;
    private Button gallery;
    private Button internet;
    private Button phone;
    private Button logIn;
    private Button createAccount;

    private TextView welcome;
    private TextView notice;
    private static final String DEFAULT_NAME = "";

    private CharSequence msg ="";//copy
    private ListView listView;//copy
    private DrawerLayout drawerLayout;//copy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        camera =(Button) findViewById(R.id.btnCamera);
        gallery =(Button) findViewById(R.id.btnGalery);
        internet  =(Button) findViewById(R.id.btnInternet);
        phone  =(Button) findViewById(R.id.btnPhone);
        logIn  =(Button) findViewById(R.id.btnLogIn);
        createAccount  =(Button) findViewById(R.id.btnCreateLogIn);
        welcome = (TextView) findViewById(R.id.tvWelcome);
        notice = (TextView) findViewById(R.id.tvLogInNote);


        if(PrefsManager.GetLogedInName().equals(DEFAULT_NAME)) {
            welcome.setText("Welcome: " + PrefsManager.GetLogedInName());
            camera.setVisibility(View.GONE);
            gallery.setVisibility(View.GONE);
            internet.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            notice.setVisibility(View.VISIBLE);
            logIn.setVisibility(View.VISIBLE);
            createAccount .setVisibility(View.VISIBLE);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.loDrawerLayout);//copy
        listView =(ListView) findViewById(R.id.lvMenus);//copy
        listView.setOnItemClickListener(this);//copy
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);//copy
        setSupportActionBar(myToolbar);//copy
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        if(!PrefsManager.GetLogedInName().equals(DEFAULT_NAME)) {
            welcome.setText("Welcome: " + PrefsManager.GetLogedInName());
            camera.setVisibility(View.VISIBLE);
            gallery.setVisibility(View.VISIBLE);
            internet.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            notice.setVisibility(View.GONE);
            logIn.setVisibility(View.GONE);
            createAccount .setVisibility(View.GONE);

        }
    }

    public void DoThings(View view) {
        switch (view.getId()){
            case R.id.btnCamera:
                Intent toCameraIntent=  new Intent(Menu.this, Camera.class);
                startActivity(toCameraIntent);
                break;
            case R.id.btnGalery:
                Intent toGalleryIntent = new Intent(Menu.this,Gallery.class);
                startActivity(toGalleryIntent);
                break;
            case R.id.btnInternet:
                Intent toInternetIntent = new Intent(Menu.this, Internet.class);
                startActivity(toInternetIntent);
                break;
            case R.id.btnPhone:
                Intent makeCallIntent = new Intent(Menu.this,PhoneCall.class);
                startActivity(makeCallIntent);
                break;
            case R.id.btnLogIn:
                Intent logIInntent = new Intent(Menu.this,LogIn.class);
                startActivity(logIInntent);
                break;
            case R.id.btnCreateLogIn:
                Intent createAccountIntent = new Intent(Menu.this,CreateLogIn.class);
                startActivity(createAccountIntent);
                break;
        }
    }

    @Override// copy
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(PrefsManager.GetLogedInName().equals(DEFAULT_NAME)){
            msg = "You must log in to use this feature";

        }else {
            switch (position) {

                case 0://menu
                    // msg = "Going to Menu";
                    msg = "You are already There";
                //  Intent goingToMenuIntent = new Intent(.this,Menu.class);
                    break;
                case 1://phone
                    msg = "Going to Phone";
                    //msg = "You are already There";
                    Intent goingToPhoneIntent = new Intent(Menu.this,PhoneCall.class);
                    startActivity(goingToPhoneIntent);
                    break;
                case 2://camera
                    msg = "Going to Camera";
                    //msg = "You are already There";
                    Intent goingToCameraIntent = new Intent(Menu.this,Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case 3://gallery
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(Menu.this,Gallery.class);
                    startActivity(goingToGalleryIntent);
                    break;
                case 4://internet
                    msg = "Going to Internet";
                    //msg = "You are already There";
                    Intent goingToInternetIntent = new Intent(Menu.this,Internet.class);
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
                    Intent goingToCameraIntent = new Intent(Menu.this, Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case R.id.actionGalery:
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(Menu.this, Gallery.class);
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
