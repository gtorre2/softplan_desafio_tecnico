package br.com.softplan.exercicio1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.StringJoiner;

public class GeradorObservacao {

    private static final String TEXTO_SINGULAR = "Fatura da nota fiscal de simples remessa: ";
    private static final String TEXTO_PLURAL = "Fatura das notas fiscais de simples remessa: ";
    private static final String MOEDA_PAIS = "R$ ";
    private static final String CUJO_VALOR = " cujo valor é ";
    private static final String TOTAL = ". Total é ";

    public String geraObservacao(Map<Integer, BigDecimal> codigos) {
        StringBuilder textoMontado = new StringBuilder();
        if (codigos.isEmpty()) {
            return textoMontado.toString();
        }
        textoPadraoNoSingulaOuNoPlural(codigos, textoMontado);
        StringBuilder textoFinal = montaCodigosSeparadosPorVirgulaComFinalConjugado(codigos, textoMontado);
        return textoFinal.toString();

    }

    private StringBuilder montaCodigosSeparadosPorVirgulaComFinalConjugado(Map<Integer, BigDecimal> codigosMap, StringBuilder textoMontado) {
        StringJoiner sj = new StringJoiner( ", " );
        double total = 0.0;
        for(Integer i : codigosMap.keySet() ) {
            sj.add( i + CUJO_VALOR + MOEDA_PAIS + codigosMap.get( i ).floatValue() );
            total += codigosMap.get( i ).doubleValue();
        }

        StringBuilder sb;
        sb = new StringBuilder( textoMontado ).append( sj.toString() ).append( TOTAL + MOEDA_PAIS ).append( total );

        return sb;

    }

    private void textoPadraoNoSingulaOuNoPlural(Map<Integer, BigDecimal> codigos, StringBuilder textoMontado) {
        if(dadoQueCodigosMaiorQueUm(codigos)) {
            textoMontado.append(TEXTO_PLURAL);
        } else {
            textoMontado.append(TEXTO_SINGULAR);
        }
    }

    private boolean dadoQueCodigosMaiorQueUm(Map<Integer, BigDecimal> codigos) {
        return codigos.size() > 1;
    }

}