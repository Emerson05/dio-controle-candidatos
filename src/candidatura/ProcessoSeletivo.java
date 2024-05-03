package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        for (String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static  void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando){
                tentativasRealizadas++;
            }else {
                System.out.println("Contato realizado com suceesso");
            }

        }while(continuarTentando && tentativasRealizadas<3);{

            if (atendeu) {
                System.out.println("Conseguimos Contato com " + candidato + "Na " + tentativasRealizadas);
            } else {
                System.out.println("Não Conseguimos Contato com " + candidato + " Numero de tentativas: " + tentativasRealizadas);
            }
        }



    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }


    static void imprmirSelecionados(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto"};
        for (String candidato: candidatos){
            System.out.println("O candidato Selescionado foi " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge" };
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados <5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O Candidato " + candidato + "Solicitou este valor de Salario:" + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O Candidato " + candidato + "Foi Selecionado para a Vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;


        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o Candidato");
        }
        else if(salarioBase==salarioPretendido){
            System.out.println("Ligar para o Candidato com contra Proposta");
        }else {
            System.out.println("Aguardando Resultado dos Demais Candidatos");
        }
    }

}