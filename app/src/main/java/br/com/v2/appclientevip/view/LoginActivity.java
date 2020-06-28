package br.com.v2.appclientevip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.v2.appclientevip.R;
import br.com.v2.appclientevip.api.AppUtil;
import br.com.v2.appclientevip.controller.ClienteController;
import br.com.v2.appclientevip.model.Cliente;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;

    Cliente cliente;

    TextView txtRecuperarSenha, txtLerPolitica;
    EditText edtEmail, edtSenha;
    CheckBox ckLembrar;
    Button btnAcessar, btnSejaVip;

    boolean isFormularioOK, isLembrarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initFormulario();

        btnAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFormularioOK = validarFormulario()) {

                    if (validarDadosDoUsuario()) {

                        salvarSharePreferences();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        return;
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Verifique os dados", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        txtRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Carregando tela de recuperação senha", Toast.LENGTH_LONG).show();
            }
        });

        txtLerPolitica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Carregando tela com política de privacidade", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validarDadosDoUsuario() {

        return ClienteController.validarDadosDoCliente();

    }

    private boolean validarFormulario() {
        boolean retorno = true;

        if (TextUtils.isEmpty(edtEmail.getText().toString())){
            edtEmail.setError("*");
            edtEmail.requestFocus();
            retorno = false;
        }

        if (TextUtils.isEmpty(edtSenha.getText().toString())){
            edtSenha.setError("*");
            edtEmail.requestFocus();
            retorno = false;
        }

        return retorno;
    }

    private void initFormulario() {
        txtRecuperarSenha = findViewById(R.id.txtRecuperarSenha);
        txtLerPolitica = findViewById(R.id.txtLerPolitica);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        ckLembrar = findViewById(R.id.ckLembrar);
        btnAcessar = findViewById(R.id.btnAcessar);
        btnSejaVip = findViewById(R.id.btnSejaVip);

        isFormularioOK = false;

        cliente = ClienteController.getClienteFake();

        restaurarSharePreferences();
    }

    public void lembrarSenha(View view) {
        isLembrarSenha = ckLembrar.isChecked();

    }

    private void salvarSharePreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();

        dados.putBoolean("loginAutomatico", isLembrarSenha);
        dados.putString("loginAutomatico", edtEmail.getText().toString());
        dados.apply();

    }

    private void restaurarSharePreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        isLembrarSenha = preferences.getBoolean("loginAutomatico", false);
        int teste = 0;
    }
}