package br.com.v2.appclientevip.api;

import java.util.Calendar;

/**
 * Classe de apoio contendo métodos que podem
 * ser reutilizados em todo o o projeto
 * <p>
 * Versão v2
 */
public class AppUtil {

    public static final int TIME_SPLASH = 5000;
    public static final String PREF_APP = "app_cliente_vip_pref";

    /**
     * @return devolve a data atual
     */
    public static String getDataAtual() {
        String dataAtual = "00/00/0000";
        String dia, mes, ano;

        try {

            Calendar calendar = Calendar.getInstance();

            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));

            // p1 : p2 : p3
            dia = (Calendar.DAY_OF_MONTH < 10) ? "0" + dia : dia;

            dia = (dia.length() > 2) ? dia.substring(1,3) : dia;

            int mesAtual = (Calendar.MONTH) + 1;
            mes = (mesAtual < 10) ? "0" + mes : mes;

            dataAtual = dia + "/" + mes + "/" + ano;

        } catch (Exception e) {

        }

        return dataAtual;

    }

    /**
     * @return devolve a hora atual
     */
    public static String getHoraAtual() {
        String hora, minuto, segundo;
        String horaAtual = "00:00:00";
        int iHora, iMinuto, iSegundo;

        try {

            Calendar calendar = Calendar.getInstance();

            iHora = calendar.get(Calendar.HOUR_OF_DAY);
            iMinuto = calendar.get(Calendar.MINUTE);
            iSegundo = calendar.get(Calendar.SECOND);

            // p1 : p2 : p3
            hora = (iHora <= 9) ? "0" + iHora : Integer.toString(iHora);
            minuto = (iMinuto <= 9) ? "0" + iMinuto : Integer.toString(iMinuto);
            segundo = (iSegundo <= 9) ? "0" + iSegundo : Integer.toString(iSegundo);
            horaAtual = hora + ":" + minuto + ":" + segundo;

        } catch (Exception e) {

        }

        return horaAtual;

    }

}
