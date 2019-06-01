package br.edu.fapi.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etNomeDisciplina;
    private EditText etNota;

    private SQLiteDatabase escola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCod=(EditText)findViewById(R.id.etCod);
        etNomeDisciplina=(EditText)findViewById(R.id.etNomeDisciplina);
        etNota=(EditText)findViewById(R.id.etNota);

        escola = this.openOrCreateDatabase("escola", Context.MODE_PRIVATE,null);
        escola.execSQL("CREATE TABLE IF NOT EXISTS boletim(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+"nome_disciplina TEXT NOT NULL,nota DECIMAL NOT NULL)");
    }

    public void btIncluirOnClick(View v){

        ContentValues registro = new ContentValues();

        etCod.clearFocus();

        registro.put("nome_disciplina",etNomeDisciplina.getText().toString());
        registro.put("nota",Double.parseDouble(etNota.getText().toString()));

        escola.insert("boletim",null,registro);

        Toast.makeText(getApplicationContext(),"Incluido com sucesso!",Toast.LENGTH_LONG).show();
    }
}
