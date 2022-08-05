package trabalho_1_lpp;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Data {

    private int dia;
    private int mes;
    private int ano;
    private Data escolhida;
    public Data clone;
    private Data Copia;
    private boolean apresentaData = true;
    private boolean bissexto = false;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data() {
        dia = 1;
        mes = 1;
        ano = 1900;
    }
    
    public Data(Data copia) {
        clone.dia = copia.dia;
        clone.mes = copia.mes;
        clone.ano = copia.ano;
    }

    public Data clone() {
        clone = new Data();
        clone.dia = this.dia;
        clone.mes = this.mes;
        clone.ano = this.ano;
        System.out.println(clone);
        return clone;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        //verifica meses para saber quantos dias terá cada
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia >= 1 || dia <= 31) {
                this.dia = dia;
            } else {
                //se o número inserido for inválido não será possível efetuar qualquer operação
                System.out.println("O número do dia " + this.dia + " inserido é inválido");
                this.dia = dia;
                this.apresentaData = false;
            }
        }
        //verifica meses para saber quantos dias terá cada
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia >= 1 || dia <= 30) {
                this.dia = dia;

            } //se o número inserido for inválido não será possível efetuar qualquer operação
            else {
                System.out.println("O número do dia inserido é inválido");
                this.dia = dia;
                this.apresentaData = false;
            }
        }
        //caso o mês for fevereiro terá de ser verificada a variável bissexto
        if (mes == 2) {
            if (this.bissexto == true) {
                if (dia >= 1 && dia <= 29) {
                    this.dia = dia;
                } else {
                    //se o número inserido for inválido não será possível efetuar qualquer operação
                    System.out.println("O número do dia inserido é inválido");
                    this.dia = dia;
                    this.apresentaData = false;
                }
            } else {
                if (dia >= 1 && dia <= 28) {
                    this.dia = dia;
                } else {
                    //se o número inserido for inválido não será possível efetuar qualquer operação
                    System.out.println("O número do dia inserido é inválido");
                    this.dia = dia;
                    this.apresentaData = false;
                }
            }
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        //verificar se o mês pretendido está entre os possíves
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            //se o número inserido for inválido não será possível efetuar qualquer operação
            System.out.println("O número do mês inserido é inválido");
            this.mes = mes;
            this.apresentaData = false;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        //verificar se o ano pretendido está entre os possíves
        if (ano >= 1900 && ano <= 2100) {
            this.ano = ano;
        } else {
            //se o número inserido for inválido não será possível efetuar qualquer operação
            System.out.println("O ano inserido é inválido");
            this.ano = ano;
            this.apresentaData = false;
        }
    }

    public boolean isApresentaData() {
        return apresentaData;
    }

    public void setApresentaData(boolean apresentaData) {
        this.apresentaData = apresentaData;
    }

    public boolean isBissexto() {
        return bissexto;
    }

    public void setBissexto(boolean bissexto) {
        this.bissexto = bissexto;
    }

    public void diasDecorridos() {
        if (this.apresentaData == true) {
            Data escolhida = new Data();
            Calendar data_escolhida = Calendar.getInstance();
            Calendar data_predefinida = Calendar.getInstance();
            //escolher a data a qual comparar
            data_escolhida.set(this.ano, this.mes, this.dia);
            //escolher a data que vai ser comparada
            data_predefinida.set(escolhida.ano, escolhida.mes, escolhida.dia);
            //passagem do dia do ano para milissegundos e a respetiva passagem para dias
            if (this.mes == 2) {
                if (this.bissexto == true) {
                    double diaspass = (((data_escolhida.getTimeInMillis() - data_predefinida.getTimeInMillis()) / 86400000) + 3);
                    int intdiaspass = (int) diaspass;
                    System.out.println("Passaram " + intdiaspass + " dias desde 1900.");
                } else {
                    double diaspass = (((data_escolhida.getTimeInMillis() - data_predefinida.getTimeInMillis()) / 86400000) + 4);
                    int intdiaspass = (int) diaspass;
                    System.out.println("Passaram " + intdiaspass + " dias desde 1900.");
                }
            } else {
                double diaspass = (((data_escolhida.getTimeInMillis() - data_predefinida.getTimeInMillis()) / 86400000) + 1);
                int intdiaspass = (int) diaspass;
                System.out.println("Passaram " + intdiaspass + " dias desde 1900.");
            }

        }
    }

    public void DataSistema() {
        if (this.apresentaData == true) {
            //obter a data atual do sistema
            LocalDate data_atual = LocalDate.now();
            int dia_atual, mes_atual, ano_atual;
            //obtenção do dia atual
            dia_atual = data_atual.getDayOfMonth();
            //obtenção do mês atual
            mes_atual = data_atual.getMonthValue();
            //obtenção do ano atual
            ano_atual = data_atual.getYear();
            Data atual = new Data(dia_atual, mes_atual, ano_atual);
            System.out.println("Data atual: " + atual);
        }
    }

    public void bissexto() {
        if (this.apresentaData == true) {
            //caso uma das condições efetuadas seja possível o ano será bissexto passando a variável a verdadeiro
            //o resto da divisão do ano por 400 for 0
            if (this.getAno() % 400 == 0) {
                this.bissexto = true;
                if (this.ano < 2021) {
                    System.out.println("O ano " + this.ano + " foi ano bissexto.");
                } else if (this.ano > 2021) {
                    System.out.println("O ano " + this.ano + " irá ser ano bissexto.");
                } else {
                    System.out.println("O ano " + this.ano + " é ano bissexto.");
                }
            } // divisível por 4 e não divisível por 100
            else if ((this.getAno() % 4 == 0) && (this.getAno() % 100 != 0)) {
                this.apresentaData = true;
                if (this.ano < 2021) {
                    System.out.println("O ano " + this.ano + " foi ano bissexto.");
                } else if (this.ano > 2021) {
                    System.out.println("O ano " + this.ano + " irá ser ano bissexto.");
                } else {
                    System.out.println("O ano " + this.ano + " é ano bissexto.");
                }
            } else {
                if (this.ano < 2021) {
                    System.out.println("O ano " + this.ano + " não foi ano bissexto.");
                } else if (this.ano > 2021) {
                    System.out.println("O ano " + this.ano + " não irá ser ano bissexto.");
                } else {
                    System.out.println("O ano " + this.ano + " não é ano bissexto.");
                }
            }
        }
    }

    public void formatoData() {
        if (this.apresentaData == true) {
            //verificação do utilizador se quer formato por extenso ou normal
            Scanner leitura = new Scanner(System.in);
            System.out.println("1- Mostrar nome do mês");
            System.out.println("2- Mostrar apenas com os números");
            System.out.print("Escolha uma das opções: ");
            String opcao = leitura.nextLine();
            System.out.println();
            if (opcao.equals("1")) {
                switch (this.mes) {
                    case 1:
                        System.out.println(this.dia + " de Janeiro de " + this.ano);
                        break;
                    case 2:
                        System.out.println(this.dia + " de Fevereiro de " + this.ano);
                        break;
                    case 3:
                        System.out.println(this.dia + " de Março de " + this.ano);
                        break;
                    case 4:
                        System.out.println(this.dia + " de Abril de " + this.ano);
                        break;
                    case 5:
                        System.out.println(this.dia + " de Maio de " + this.ano);
                        break;
                    case 6:
                        System.out.println(this.dia + " de Junho de " + this.ano);
                        break;
                    case 7:
                        System.out.println(this.dia + " de Julho de " + this.ano);
                        break;
                    case 8:
                        System.out.println(this.dia + " de Agosto de " + this.ano);
                        break;
                    case 9:
                        System.out.println(this.dia + " de Setembro de " + this.ano);
                        break;
                    case 10:
                        System.out.println(this.dia + " de Outubro de " + this.ano);
                        break;
                    case 11:
                        System.out.println(this.dia + " de Novembro de " + this.ano);
                        break;
                    case 12:
                        System.out.println(this.dia + " de Dezembro de " + this.ano);
                        break;
                }
            }
            if (opcao.equals("2")) {
                System.out.println("Data: " + this.dia + "/" + this.mes + "/" + this.ano);
            }
        }
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}
