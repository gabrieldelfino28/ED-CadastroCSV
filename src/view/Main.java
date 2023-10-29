package view;
/*
 * É necessário ter o arquivo Cadastro.csv no local C:\temp\
 * Objetivo dessa pequena aplicação Java é ler um arquivo de dados e escrever um novo.
 */
import controller.MCadastroController;

public class Main {

    public static void main(String[] args) {

        MCadastroController mcc = new MCadastroController();

        try{
            mcc.novoCadastro(41,60,8000);
            mcc.novoCadastro(31,40,5000);
            mcc.novoCadastro(21,30,3000);
        }catch (Exception err) {
            System.err.println(err.getMessage());
        }
    }
}
