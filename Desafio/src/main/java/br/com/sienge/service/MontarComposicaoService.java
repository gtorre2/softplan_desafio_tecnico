package br.com.sienge.service;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;

import br.com.sienge.model.Composicao;

public class MontarComposicaoService {

	public Map<Integer, Composicao> listarComposicoes(Composicao[] composicoes, 
			Map<Integer, Composicao> mapaComposicao) {
		
		for(Composicao composicao : composicoes) {
			if (mapaComposicao.containsKey(composicao.getCodigoComposicao())) {
	 			String dadosMontados = montaDados(composicao);
	 			Composicao composicaoJson = mapaComposicao.get(composicao.getCodigoComposicao());
	 			composicaoJson.setValorTotalComposicao(composicaoJson.getValorTotalComposicao() + new Double(dadosMontados.replaceAll( "," , "." ).trim()));
	 		} else {
	 			String dadosMontadosMapaVazio = montaDados(composicao);
	 			BigDecimal valorZero = BigDecimal.ZERO;
	 			composicao.setValorTotalComposicao(valorZero.doubleValue());
	 			composicao.setValorTotalComposicao(composicao.getValorTotalComposicao() + new Double(dadosMontadosMapaVazio.replaceAll( "," , "." ).trim()));
        		mapaComposicao.put(composicao.getCodigoComposicao(), composicao);
	 		}
	 	}
	 	
	 	return mapaComposicao;
		
	}

	private String montaDados(Composicao composicao) {
		String quantidadeComposicao = composicao.getQuantidadeComposicao().replaceAll( "," , "." ).trim();
        String valorUnitarioComposicao = composicao.getValorUnitario().replaceAll( "," , "." ).trim();
        
        BigDecimal quanitdade = new BigDecimal(quantidadeComposicao);
        BigDecimal valorUnitario = new BigDecimal(valorUnitarioComposicao);
        
        valorUnitario = quanitdade.multiply(valorUnitario);
        String resultado = String.format(Locale.getDefault(), "%.2f", valorUnitario);
		
		return resultado;
		
	}

}
