package br.com.softplan.exercicio1;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        GeradorObservacao geradorObservacao = new GeradorObservacao();
        Map<Integer, BigDecimal> codigos = new LinkedHashMap<>();

        codigos.put(1, new BigDecimal("10.00"));
        codigos.put(2, new BigDecimal("35.00"));
        codigos.put(3, new BigDecimal("5.00"));
        codigos.put(4, new BigDecimal("1.500"));
        codigos.put(5, new BigDecimal("0.30"));

        System.out.println(geradorObservacao.geraObservacao(codigos));
    }

}
