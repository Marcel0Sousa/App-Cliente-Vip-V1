package br.com.v2.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import br.com.v2.appclientevip.R;

public class CadastroUsuarioActivity extends AppCompatActivity {

    // 1º
    Button btnCadastrar;
    EditText edtNome, edtEmail, edtSenhaA, edtSenhaB;
    CheckBox ckTermo;
    Boolean isFormularioOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        // 2º
        initFormulario();
        // 3º
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4º
                isFormularioOK = true;

                if (TextUtils.isEmpty(edtNome.getText().toString())) {
                    edtNome.setError("*");
                    edtNome.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(edtEmail.getText().toString())) {
                    edtEmail.setError("*");
                    edtEmail.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(edtSenhaA.getText().toString())) {
                    edtSenhaA.setError("*");
                    edtSenhaA.requestFocus();
                    isFormularioOK = false;
                }

                if (TextUtils.isEmpty(edtSenhaB.getText().toString())) {
                    edtSenhaB.setError("*");
                    edtSenhaB.requestFocus();
                    isFormularioOK = false;
                }

                if (!ckTermo.isChecked()) {
                    isFormularioOK = false;
                }
                // 5º
                if (isFormularioOK) {

                    if (!validarSenha()) {
                        edtSenhaA.setError("*");
                        edtSenhaB.setError("b");
                        edtSenhaA.requestFocus();
                        Toast.makeText(getApplicationContext(), R.string.SenhaNaoConferem, Toast.LENGTH_LONG).show();
                    } else {

                        Intent iMenuPrincipal = new Intent(CadastroUsuarioActivity.this, MainActivity.class);
                        startActivity(iMenuPrincipal);

                    }
                }

            }
        });

    }

    private void initFormulario() {
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenhaA = findViewById(R.id.edtSenhaA);
        edtSenhaB = findViewById(R.id.edtSenhaB);
        ckTermo = findViewById(R.id.ckTermo);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        isFormularioOK = false;
    }

    public void ValidarTermo(View view) {
        if (!ckTermo.isChecked()) {
            Toast.makeText(getApplicationContext(), R.string.AceitarTermo, Toast.LENGTH_LONG).show();
        }
    }

    public boolean validarSenha() {
        boolean retorno = false;

        int senhaA, senhaB;

        senhaA = Integer.parseInt(edtSenhaA.getText().toString());
        senhaB = Integer.parseInt(edtSenhaB.getText().toString());

        retorno = (senhaA == senhaB);

        return retorno;
    }

}