package MAsK_S0c13ty.Menu;

import MAsK_S0c13ty.Enum.Horario;
import MAsK_S0c13ty.Model.*;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * classe onde o menu sera executado.
 */
public class Menu {

    private static Horario horarioAtual = Horario.Normal;
    private boolean continuarExecucao;
    private Scanner scanner;



    private ArrayList<Membros> listaMembros = new ArrayList<>();


    /**
     * Funcao utilizada para rodar o menu enquanto o usuario nao finaliza-la.
     */
    public void executar() {
        while (continuarExecucao) {
            exibirMenu();
            int opcao = scanner.nextInt();
            avaliaropcao(opcao);
        }
    }

    /**
     * Menu utilizado para printar na tela do usuario as acoes disponiveis
     */
    private void exibirMenu() {
        System.out.println("\n\n===================================");
        System.out.println("            MAsK_S0c13ty ");
        System.out.println("===================================");
        System.out.println("Seu horário atual é: " + horarioAtual);
        System.out.println("1 - Saber seu horário atual");
        System.out.println("2 - Mudar seu horário atual");
        System.out.println("3 - Cadastro de novos membros");
        System.out.println("4 - remover um membro");
        System.out.println("5 - Postar mensagem");
        System.out.println("6 - Apresentar membros");
        System.out.println("7 - Sair do Sistema");
    }

    /**
     * Metodo utilizado para ler e fazer acoes dependendo do que o usuario pedir selecionar
     *
     * @param opcao opcao que o usuario selecionou
     */
    private void avaliaropcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("\n\n Seu horário atual é: " + horarioAtual + "\n\n");
                break;

            case 2:
                System.out.println("\n\nQual o horário que vode deseja (Normal ou Extra)");
                String qualhora = scanner.next();
                if (qualhora.equals("Normal") | qualhora.equals("normal")) {
                    horarioAtual = Horario.Normal;
                    System.out.println("\n\n Seu horário foi alterado com suceso!\n\n");
                } else {
                    if (qualhora.equals("Extra") | qualhora.equals("extra")) {
                        horarioAtual = Horario.Extra;
                        System.out.println("\n\n Seu horário foi alterado com suceso!\n\n");
                    } else {
                        System.out.println("\n Opcao invalida,tente novamente\n");

                    }
                }
                break;

            case 3:
                CadastroMembros();

                break;

            case 4:
                RemoverMembros();

                break;

            case 5:


                for (Membros membros : listaMembros) {
                        System.out.println(membros.getNome() + ":" );
                        membros.postar(horarioAtual);
                        System.out.println("\n");
                    }


                break;

            case 6:

                int id = 0;
                for(Membros membros: listaMembros){
                    System.out.println("id: "+ id);
                    membros.apresentacao();
                    id= id+1;}
                break;

            case 7:
                this.continuarExecucao = false;

                break;



        }
    }


    /**
     * Metodo utilizado para cadastrar novos membros.
     */
    private void CadastroMembros() {
        System.out.println("Deseja adicionar novos membros(Sim ou Não)");
        String respostaCadastro = scanner.next();
        if (respostaCadastro.equals("Sim") | respostaCadastro.equals("sim")) {
            System.out.println("Qual o nome do membro?");
            String nome = scanner.next();
            System.out.println("Qual o email do membro?");
            String email = scanner.next();
            System.out.println("Qual a funcao do membro:\n" +
                    "1- Mobile_Members.\n" +
                    "2- Heavy_Lifters\n" +
                    "3- Script_Guys\n" +
                    "4- Big_Brothers");
            int escolha = scanner.nextInt();
            System.out.println("Qual o id do membro?");
            int id = scanner.nextInt();
            switch (escolha) {
                case 1:
                    this.listaMembros.add(new MobileMembers(nome, email, id));
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 2:
                    this.listaMembros.add(new HeavyLifters(nome, email, id));
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 3:
                    this.listaMembros.add(new ScriptGuys(nome, email, id));
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                case 4:
                    this.listaMembros.add(new BigBrothers(nome, email, id));
                    System.out.println("Cadastro realizado com sucesso!");
                    break;
                default:
                    System.out.println("Erro no cadastro.Tente Novamente!");


            }
            Arquivo arquivo = new Arquivo();
            try {
                arquivo.criarArquivo(listaMembros);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

        /**
         * Metodo utilizado para remover membros
         */
        private void RemoverMembros () {
            System.out.println("Deseja remover um membro (Sim ou Não)");
            String respostaRemover = scanner.next();
            if (respostaRemover.equals("Sim") | respostaRemover.equals("sim")) {
                System.out.println("ID do usuario a ser removido:");
                int id = scanner.nextInt();
                listaMembros.remove(id);
                System.out.println("Usuario removido com sucesso!");

            }
        }


    /**
     * Metodo que faz o Menu rodar ate o usuario para-lo
     */
    public Menu() {

            this.continuarExecucao = true;
            this.scanner = new Scanner(System.in);


        }

    }



