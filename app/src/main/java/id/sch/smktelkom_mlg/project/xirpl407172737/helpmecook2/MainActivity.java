package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView iv;
    ArrayAdapter<String> adapter;
    DatabaseReference db;
    ResepHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iv = (ListView) findViewById(R.id.lv);
        db = FirebaseDatabase.getInstance().getReference();
        helper = new ResepHelper(db);

        //ADAPTER
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,helper.retrieve());
        iv.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
                    }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void displayInputDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Tambah Resep");
        d.setContentView(R.layout.cobaresep);

        final EditText nama = (EditText) d.findViewById(R.id.editTextNamaResep);
        final EditText bahan = (EditText) d.findViewById(R.id.editTextBahan);
        final EditText cara = (EditText) d.findViewById(R.id.editTextCaraMembuat);
        Button saveBtn = (Button) d.findViewById(R.id.buttonSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET DATA
                String name = nama.getText().toString();
                String ingredients =  bahan.getText().toString();
                String howto = cara.getText().toString();

                //SET DATA
                Resep s = new Resep();
                s.setName(name);
                s.setBahan(ingredients);
                s.setCara(howto);

                //VALIDATE
                if(name.length()>0 && name != null && ingredients.length()>0 && ingredients != null
                       && howto.length()>0 && howto != null)
                {
                    if(helper.save(s))
                    {
                        nama.setText("");
                        bahan.setText("");
                        cara.setText("");
                        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,helper.retrieve());
                        iv.setAdapter(adapter);

                    }
                }else
                {
                    Toast.makeText(MainActivity.this, "Name or address cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setAndroidContext(){
        Firebase.setAndroidContext(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

