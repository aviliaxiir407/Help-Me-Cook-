package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class Tambah_resep extends AppCompatActivity {
    private EditText editTextNamaResep;
    private EditText editTextBahan;
    private TextView textViewPersons;
    private EditText editTextCaraMembuat;
    private Button buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamba_resep);
        Firebase.setAndroidContext(this);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextNamaResep = (EditText) findViewById(R.id.editTextNamaResep);
        editTextBahan = (EditText) findViewById(R.id.editTextBahan);
        textViewPersons = (TextView) findViewById(R.id.textViewResep);
        editTextCaraMembuat = (EditText) findViewById(R.id.editTextCaraMembuat);

        //Click Listener for button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                Firebase ref = new Firebase(config.FIREBASE_URL);

                //Getting values to store
                String namaresep = editTextNamaResep.getText().toString().trim();
                String bahan = editTextBahan.getText().toString().trim();
                String caramembuat = editTextCaraMembuat.getText().toString().trim();

                //Creating Resep object
                final Resep resep = new Resep();

                //Adding values
                resep.setName(namaresep);
                resep.setBahan(bahan);
                resep.setCara(caramembuat);

                //Storing values to firebase

                ref.child("Resep").push().setValue(resep);

            }
        });
    }
}
