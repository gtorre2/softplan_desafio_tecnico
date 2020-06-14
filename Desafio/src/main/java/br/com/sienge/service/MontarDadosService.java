package br.com.sienge.service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.sienge.model.Composicao;
import br.com.sienge.util.LerArquivoJson;

public class MontarDadosService {
	
	LerArquivoJson util = new LerArquivoJson();
	MontarComposicaoService montarComposicao = new MontarComposicaoService();
	
	public List<String> listarDados (String caminhoArquivo) throws UnsupportedEncodingException, FileNotFoundException {
		Map<Integer, Composicao> mapaComposicao = new LinkedHashMap<Integer, Composicao>();
		
		Composicao[] composicoes = util.receberArquivoJson(caminhoArquivo);
		List<String> listaRetorno = new ArrayList<>();
		
		if(!composicoes.toString().isEmpty()) {
			mapaComposicao = new LinkedHashMap<Integer, Composicao>();
			mapaComposicao = montarComposicao.listarComposicoes(composicoes, mapaComposicao);
			listaRetorno = listarDadosMapa(mapaComposicao);
		}
		
		return listaRetorno;
				
	}

	private List<String> listarDadosMapa(Map<Integer, Composicao> mapaComposicao) throws NumberFormatException{
		List<String> list = new ArrayList<>();
		for (Map.Entry<Integer, Composicao> composicao : mapaComposicao.entrySet()){
			StringBuilder builder = new StringBuilder();	
			String totalGeral = String.format(Locale.getDefault(), "%.2f", composicao.getValue().getValorTotalComposicao());
			builder.append(composicao.getValue().getCodigoComposicao()).append(" ");
			builder.append(composicao.getValue().getDescricaoComposicao().toUpperCase()).append(" ");
			builder.append(composicao.getValue().getUnidadeComposicao().toUpperCase()).append(" ");
			builder.append(totalGeral);
			list.add(builder.toString());
		}
		
		return list;
	}
	
}
