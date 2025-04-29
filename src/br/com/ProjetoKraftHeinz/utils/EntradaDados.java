package br.com.ProjetoKraftHeinz.utils;

import javax.swing.*;

public class EntradaDados {

        public static String texto(String mensagem){
            return JOptionPane.showInputDialog(mensagem);
        }
        public static double valor(String mensagem){
            return Double.parseDouble(JOptionPane.showInputDialog(mensagem).replace(',', '.'));
        }
    public static int inteiro(String mensagem){
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem).replace(',', '.'));
    }
        public static boolean logico(String mensagem){
            int resp = JOptionPane.showConfirmDialog(null, mensagem,
                    "Pergunta", JOptionPane.YES_NO_OPTION);
            if (resp == 1) {
                return false;
            } else {
                return true;
            }
        }
        public static void console(String log){
            System.out.println(log);
        }
        public static void show(String mensagem){
            JOptionPane.showMessageDialog(null,
                    mensagem,"Apresentação", 1);
        }
        public static char caracter(String mensagem ){
            return Character.toUpperCase(JOptionPane.showInputDialog(mensagem).charAt(0));
        }

        public static int opcoes(String mensagem , String título, String[] escolhaRelatorio){
            int nValorEscolhido = JOptionPane.showOptionDialog(
                    null
                    , mensagem       // Mensagem
                    , título               // Titulo
                    , JOptionPane.YES_NO_OPTION
                    , JOptionPane.PLAIN_MESSAGE
                    , null // Icone. Você pode usar uma imagem se quiser, basta carrega-la e passar como referência
                    , escolhaRelatorio // Array de strings com os valores de cada botão. Veja o exemplo abaixo **
                    , ""    // Label do botão Default
            );
            return nValorEscolhido;

        }
    }


