package com.example.app.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.DB.DB;
import com.example.app.R;
import com.example.app.controller.DBController;
import com.example.app.controller.PessoaController;
import com.example.app.controller.CursoController;
import com.example.app.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    int posicao = 0;
    Spinner etCurso;
    Button btnSalvar, btnLimpar, btnFinalizar;
    EditText etNome, etSobrenome, etTelefone;
    PessoaController pessoaController;
    CursoController cursoController;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etCurso = findViewById(R.id.etCurso);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cursos_items,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etCurso.setAdapter(adapter);

        cursoController = new CursoController(this);
        pessoaController = new PessoaController(this);

        btnSalvar = findViewById(R.id.btn_salvar);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFinalizar = findViewById(R.id.btn_finalizar);


        etNome = findViewById(R.id.etNome);
        etSobrenome = findViewById(R.id.etSobrenome);
        etCurso = findViewById(R.id.etCurso);
        etTelefone = findViewById(R.id.etTelefone);

        btnSalvar.setOnClickListener(v -> {
            DBController db = new DBController(this);
            String dbResultado;

            Pessoa pessoa = new Pessoa(
                    etNome.getText().toString(),
                    etSobrenome.getText().toString(),
                    null,
                    etTelefone.getText().toString()
            );

            if (pessoaController.confirmarPessoa(pessoa) == -1) {
                pessoaController.salvarPessoa(pessoa);
                pessoa.setCurso(etCurso.getSelectedItem().toString());
                posicao = etCurso.getSelectedItemPosition();

                cursoController = new CursoController(this);
                cursoController.salvarPosicao(posicao);

                dbResultado = db.inserirDados(pessoa.getNome(),pessoa.getSobrenome(), pessoa.getTelefone(), pessoa.getCurso());
                Toast.makeText(this, dbResultado, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Informações incorretas!", Toast.LENGTH_SHORT).show();
                cursoController.deletarSpinner();
                pessoaController.deletarPessoa();
            }
        });

        btnLimpar.setOnClickListener(v -> {
            etNome.setText("");
            etSobrenome.setText("");
            etTelefone.setText("");
            etCurso.setSelection(0);

            cursoController.deletarSpinner();
            pessoaController.deletarPessoa();

            Toast.makeText(this, "Pessoa deletada!", Toast.LENGTH_SHORT).show();
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(this, "App finalizado!", Toast.LENGTH_SHORT).show();
            finish();
        });
        carregarPessoaSalva();
    }

    public void carregarPessoaSalva() {
        Pessoa pessoa = pessoaController.carregarPessoa();
        CursoController cursoController = new CursoController(this);

        etNome.setText(pessoa.getNome());
        etSobrenome.setText(pessoa.getSobrenome());
        etCurso.setSelection(cursoController.carregarCurso());
        etTelefone.setText(pessoa.getTelefone());
    }

}






































































































































































































































































































