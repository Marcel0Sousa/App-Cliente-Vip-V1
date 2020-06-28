package br.com.v2.appclientevip.controller;

import br.com.v2.appclientevip.model.Cliente;

public class ClienteController {

    public static boolean validarDadosDoCliente() {
        boolean retorno = false;

        return retorno;
    }

    public static Cliente getClienteFake() {
        Cliente fake = new Cliente();

        fake.setPrimeiroNome("Marcelo");
        fake.setSobreNome("Sousa");
        fake.setEmail("noob@email.com");
        fake.setSenha("12345");
        fake.setPessoaFisica(true);

        return fake;
    }
}
