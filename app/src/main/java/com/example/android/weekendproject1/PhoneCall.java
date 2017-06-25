package com.example.android.weekendproject1;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.jar.Manifest;

public class PhoneCall extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String number = "";
    private TextView textView;
    private static final String DEFAULT_NAME = "";

    private CharSequence msg ="";//copy
    private ListView listView;//copy
    private DrawerLayout drawerLayout;//copy
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        textView =(TextView) findViewById(R.id.tvNumbers);
        drawerLayout = (DrawerLayout) findViewById(R.id.loDrawerLayout);//copy
        listView =(ListView) findViewById(R.id.lvMenus);//copy
        listView.setOnItemClickListener(this);//copy
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);//copy
        setSupportActionBar(myToolbar);//copy
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void pressCall(View view) {
        Uri num = Uri.parse("tel" + textView.getText().toString());
        Intent phpneInente = new Intent(Intent.ACTION_CALL);
        phpneInente.setData(num);
        if (ActivityCompat.checkSelfPermission(PhoneCall.this,
                android.Manifest.permission.CALL_PHONE) != getPackageManager().PERMISSION_GRANTED) {
            return;
        }
        startActivity(phpneInente);
    }

    public void pressBack(View view) {
        number = number.substring(0,number.length()-1);
        textView.setText(number);
    }

    public void pressClr(View view) {
        number ="";
        textView.setText(number);
    }

    public void press(View view) {
        switch (view.getId()){
            case R.id.btnOne:
                number +=1;
                break;
            case R.id.btnTwo:
                number+=2;
                break;
            case R.id.btnThree:
                number+=3;
                break;
            case R.id.btnFour:
                number+=4;
                break;
            case R.id.btnFive:
                number+=5;
                break;
            case R.id.btnSix:
                number+=6;
                break;
            case R.id.btnSeven:
                number+=7;
                break;
            case R.id.btnEight:
                number+=8;
                break;
            case R.id.btnNine:
                number+=9;
                break;
            case R.id.btnZero:
                number+=0;
                break;
        }
        textView.setText(number);
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
                    Intent goingToMenuIntent = new Intent(PhoneCall.this,Menu.class);
                    startActivity(goingToMenuIntent);
                    break;
                case 1://phone
                    //msg = "Going to Phone";
                    msg = "You are already There";
                    //Intent goingToPhoneIntent = new Intent(PhoneCall.this,PhoneCall.class);
                    //startActivity(goingToPhoneIntent);
                    break;
                case 2://camera
                    msg = "Going to Camera";
                    //msg = "You are already There";
                    Intent goingToCameraIntent = new Intent(PhoneCall.this,Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case 3://gallery
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(PhoneCall.this,Gallery.class);
                    startActivity(goingToGalleryIntent);
                    break;
                case 4://internet
                    msg = "Going to Internet";
                    //msg = "You are already There";
                    Intent goingToInternetIntent = new Intent(PhoneCall.this,Internet.class);
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
                    Intent goingToCameraIntent = new Intent(PhoneCall.this, Camera.class);
                    startActivity(goingToCameraIntent);
                    break;
                case R.id.actionGalery:
                    msg = "Going to Gallery";
                    //msg = "You are already There";
                    Intent goingToGalleryIntent = new Intent(PhoneCall.this, Gallery.class);
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