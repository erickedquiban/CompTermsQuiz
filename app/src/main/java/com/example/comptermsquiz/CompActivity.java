package com.example.comptermsquiz;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CompActivity  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private AdapterViewFlipper adapterViewFlipper;
    private Button btnPrevious, btnNext;

    private long backPressedTime;
    Dialog myDialog;
    String uriString;

    private static final String[] TEXT = {"Artificial intelligence." +
            "The modern definition of artificial intelligence (or AI) is \"the study and design " +
            "of intelligent agents.",

            "Data science is an ever-evolving industry." +
                    " Ask any prominent data scientist or an industry expert and he or she would say that an analytics " +
                    "aspirant needs to stay constantly updated about the industry.",

            "Machine Learning definition is that it is a core sub-area of Artificial Intelligence (AI). " +
                    " ML applications learn from experience (well data) like humans without direct programming. ",
            "Go, also known as Golang, is a statically typed," +
                    " compiled programming language designed at Google by Robert Griesemer, Rob Pike, and Ken Thompson.",
    "CCNA Exploration is designed for students with advanced problem solving and analytical skills."};
    private static final int[] IMAGES = {R.drawable.compart, R.drawable.comphap, R.drawable.compmon,
            R.drawable.goprog, R.drawable.cisco2};


    private int mPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp);
        myDialog = new Dialog(this);


        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.idAdapterViewFlipper);
        FlipperAdapter adapter = new FlipperAdapter(this, TEXT, IMAGES);
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.setAutoStart(true);


    Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar
                , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MenuFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_menu);}

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case  R.id.nav_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MenuFragment()).commit();
                break;
            case  R.id.nav_categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CategoriesFragment()).commit();

                break;
            case  R.id.nav_his:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistoryFragment()).commit();
                break;
            case  R.id.nav_parts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PartsFragment()).commit();
                break;
          


            case  R.id.nav_les4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson4()).commit();
                break;

            case  R.id.nav_les5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson5()).commit();
                break;

            case  R.id.nav_les6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson6()).commit();
                break;

            case  R.id.nav_les7:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson7()).commit();
                break;
            case  R.id.nav_les8:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson8()).commit();
                break;

            case  R.id.nav_les9:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson9()).commit();
                break;

            case  R.id.nav_les10:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FragmentLesson10()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void finishDrawer(){

        Intent resultIntent = new Intent();
        setResult(RESULT_OK, resultIntent);

        finish();
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            finishDrawer();

        }else{
            Toast.makeText(this, "Are you sure do you want to exit?", Toast.LENGTH_SHORT).show();
        }

        backPressedTime = System.currentTimeMillis();

    }

    public void ShowPopup(View v) {
        TextView txtclose;
        Button btn;
        myDialog.setContentView(R.layout.custompopup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btn = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void btnshare(View w){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        uriString = "https://www.facebook.com/Mother-Words-Application-119477846110059/";
        sharingIntent.putExtra(Intent.EXTRA_TEXT,uriString);
        sharingIntent.setPackage("com.facebook.katana");
        startActivity(sharingIntent);
    }

    public void btnfed(View w){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mail"));
        String[] s={"motherwords2019@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        i.putExtra(Intent.EXTRA_TEXT,"");
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i, "Luncher Email");
        startActivity(chooser); //ito ginamit
    }


    public void ShowPopupdev(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.compdev);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }


    public void ShowPopupsetting(View v) {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.compsetting);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void btnClick1(View w){
        String url = "https://www.nasa.gov";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void btnClick2(View w){
        Intent int1 = new Intent(CompActivity.this, featuresnasa.class);
        startActivity(int1);
    }


    public void ShowPopuptutorial(View v) {
        TextView txtclose;
        Button btnFollow;

        myDialog.setContentView(R.layout.comptutorial);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}

    class FlipperAdapter extends BaseAdapter {
        Context ctx;
        int[] images;
        String[] text;
        LayoutInflater inflater;

        public FlipperAdapter (Context context, String[] myText, int[] myImages){
            this.ctx = context;
            this.images = myImages;
            this.text = myText;
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount(){
            return text.length;
        }

        @Override
        public Object getItem (int i){
            return null;
        }

        @Override
        public long getItemId (int i){
            return 0;
        }

        @Override
        public View getView (int i, View view, ViewGroup viewGroup){
            view = inflater.inflate(R.layout.flipper_item, null);
            TextView txtName = (TextView) view.findViewById(R.id.idTextView);
            ImageView txtImage = (ImageView) view.findViewById(R.id.idImageView);
            txtName.setText(text[i]);
            txtImage.setImageResource(images[i]);
            return view;
        }


    }


