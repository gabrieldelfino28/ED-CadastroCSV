package controller;

import linkedlist.model.LinkedList;
import model.Cliente;

import java.io.*;

public class MCadastroController {
    public MCadastroController() {
        super();
    }

    private void novoArquivo(LinkedList<Cliente> l, String nomeArquivo) throws Exception {
        File f = new File("C:\\TEMP\\" + nomeArquivo);
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            buffer.append(l.get(i).toString()).append("\r\n");
        }

        FileWriter openF = new FileWriter(f);
        PrintWriter writer = new PrintWriter(openF);
        writer.write(buffer.toString());
        writer.flush();
        writer.close();
        openF.close();

        System.out.println("Arquivo " + f + " gerado!");
    }

    public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws Exception {
        LinkedList<Cliente> l = new LinkedList<>();
        File f = new File("C:\\TEMP\\cadastro.csv");

        if (f.exists() && f.isFile()) {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String linha = buffer.readLine();

            while (linha != null) {

                String[] cInfo = linha.split(";");
                int idade = Integer.parseInt(cInfo[2]);
                double credito = Double.parseDouble(cInfo[3].replace(",", "."));
                Cliente aux = new Cliente(cInfo[0], cInfo[1], idade, credito);

                if (aux.idade > idadeMin - 1 && aux.idade < idadeMax + 1) {
                    if (aux.limiteCredito > limiteCredito) {
                        l.addLast(aux);
                    }
                }
                linha = buffer.readLine();//Contador até o EndOfFile
            }
            String nomeArquivo = "Cadastro_idade-" + idadeMin + "-a-" + idadeMax + "-limite-" + limiteCredito + ".csv";
            novoArquivo(l, nomeArquivo);
        } else {
            throw new IOException("Arquivo e/ou diretório inválido");
        }
    }
}
