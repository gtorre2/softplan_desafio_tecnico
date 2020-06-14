package br.com.sienge.principal;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.sienge.model.enumerados.CaminhoArquivo;
import br.com.sienge.service.MontarDadosService;

public class Sienge {
	
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		MontarDadosService montarDados = new MontarDadosService();
		List<String> listaComposicoes = montarDados.listarDados(CaminhoArquivo.CAMINHO_ARQUIVO_JSON.getPath());
		listaComposicoes.forEach(composicao -> System.out.println(composicao));
	}
	
}
