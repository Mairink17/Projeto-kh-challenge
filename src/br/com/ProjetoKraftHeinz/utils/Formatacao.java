package br.com.ProjetoKraftHeinz.utils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;


public class Formatacao {

    public static String formataCnpj(String cnpj) throws ParseException {

        try {
            MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            cnpj = mask.valueToString(cnpj);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return cnpj;
    }
}
