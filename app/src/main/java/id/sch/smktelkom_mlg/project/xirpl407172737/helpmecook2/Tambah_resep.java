package id.sch.smktelkom_mlg.project.xirpl407172737.helpmecook2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tambah_resep extends AppCompatActivity {

    final static String DB_URL = "https://help-me-cook.firebaseio.com/";
    Button saveBtn;
    EditText nameEdiText;
    EditText bahanEdiText, caraEdiText, urlEdiText;
    FireBaseClient fireBaseClient;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamba_resep);

        nameEdiText = (EditText) findViewById(R.id.editTextNamaResep);
        bahanEdiText = (EditText) findViewById(R.id.editTextBahan);
        caraEdiText = (EditText) findViewById(R.id.editTextCaraMembuat);
        urlEdiText = (EditText) findViewById(R.id.url);

        rv = (RecyclerView) findViewById(R.id.mRecycleID);
        fireBaseClient = new FireBaseClient(this, DB_URL, rv);

        saveBtn = (Button) findViewById(R.id.buttonSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fireBaseClient.saveOnCline(nameEdiText.getText().toString(),
                        bahanEdiText.getText().toString(),
                        caraEdiText.getText().toString()
                        , urlEdiText.getText().toString());
                nameEdiText.setText("");
                urlEdiText.setText("");
                bahanEdiText.setText("");
                caraEdiText.setText("");

            }
        });
    }

}