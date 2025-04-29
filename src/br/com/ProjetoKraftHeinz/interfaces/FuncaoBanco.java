package br.com.ProjetoKraftHeinz.interfaces;

import javax.management.relation.Role;

public interface FuncaoBanco <T extends Role>{

    public void cadastrar (T obj);
}
