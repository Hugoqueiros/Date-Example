package trabalho_1_lpp;

import java.util.Calendar;
import java.util.Scanner;

public class Trabalho_1_LPP {
    
    /*o conceito encapsulamento neste trabalho foi implementado nas variáveis dia
    mês e ano que se tornaram privados e foram criados os métodos get e set para
    se aceder as variáveis*/
    
    /*o conceito abstração neste trabalho foi implementado através da emissão
    horas minutos e segundos na data
    */

    public void go() {
        
        Data data = new Data();
        
        //definição do ano
        data.setAno(1900);
        //definição do mês
        data.setMes(1);
        //definição do dia
        data.setDia(2);
        //chamada do método do formato da data
        data.formatoData();
        //chamada do método da verificação de ano bissexto
        data.bissexto();
        //chamada do método dos dias decorridos
        data.diasDecorridos();
        //chamada do método da data atual do sistema
        data.DataSistema();
        //data.clone();
    }

    public static void main(String[] args) {
        new Trabalho_1_LPP().go();
    }
}
