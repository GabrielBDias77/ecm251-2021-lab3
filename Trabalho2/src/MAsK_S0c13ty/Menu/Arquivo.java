package MAsK_S0c13ty.Menu;

import MAsK_S0c13ty.Model.Membros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arquivo {

    /**
     * metodo utilizado para criar o arquivo.csv
     * @param list lista dos membros ja cadastrados
     * @throws FileNotFoundException excecao de arquivo nao encontrado
     */
    public static void criarArquivo(ArrayList<Membros> list) throws FileNotFoundException {
        File arquivo = new File("arquivo_super_secreto_nao_pode_abrir.csv");

    try {
        PrintWriter out = null;

        out = new PrintWriter(arquivo);

        out.print("Nome");
        out.print(";");
        out.print("ID");
        out.print(";");
        out.println("Funcao");

        PrintWriter finalOut = out;
        list.forEach(membro -> {

            finalOut.print(membro.getNome());
            finalOut.print(";");
            finalOut.print(membro.getId());
            finalOut.print(";");
            finalOut.println(membro.getTipo());

        });

        out.close();

    } catch (
    FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
    }
}

}

