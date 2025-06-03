package com.example.app.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.R;
import com.example.app.controller.CursoController;
import com.example.app.controller.PessoaController;
import com.example.app.model.Curso;
import com.example.app.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Curso curso;
    private Button btnSalvar, btnLimpar, btnFinalizar;
    private EditText etNome, etSobrenome, etCurso, etTelefone;
    private PessoaController pessoaController;
    private CursoController cursoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);

        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etCurso =findViewById(R.id.etCurso);
        etTelefone = findViewById(R.id.etTelefone);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNome.setText("");
                etCurso.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa = new Pessoa();
                curso = new Curso(String.valueOf(etCurso.getText()));

                pessoa.setNome(String.valueOf(etNome.getText()));
                pessoa.setSobrenome(String.valueOf(etSobrenome.getText()));
                pessoa.setCurso(String.valueOf(etCurso.getText()));
                pessoa.setTelefone(String.valueOf(etTelefone.getText()));

                pessoa.addPessoa(pessoa);
                pessoa.printList();

                etNome.setText("");
                etCurso.setText("");
                etSobrenome.setText("");
                etTelefone.setText("");
            }
        });
    }

}






































































































































































































































































































