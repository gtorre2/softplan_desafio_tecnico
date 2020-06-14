package br.com.sienge.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;

import br.com.sienge.model.Composicao;

public class LerArquivoJson{
	
	private static final String PADRAO_CODIFICACAO = "UTF-8";
	
	public Composicao[] receberArquivoJson(String arquivoEntrada) throws UnsupportedEncodingException, FileNotFoundException {
		BufferedReader bufferedReader = null;
		Composicao[] composicoes = null;
		File arquivoJson = new File(arquivoEntrada);
		bufferedReader = montarBufferReader(arquivoJson);
		composicoes = lerDadadosArquivoJson(bufferedReader);
		
		return composicoes;
	}
		
	private BufferedReader montarBufferReader(File arquivoJson) throws UnsupportedEncodingException, FileNotFoundException {
		InputStreamReader reader = new InputStreamReader(new FileInputStream(arquivoJson), PADRAO_CODIFICACAO);
		BufferedReader bufferedReader = new BufferedReader(reader);

		return bufferedReader;
	}

	private Composicao[] lerDadadosArquivoJson(BufferedReader bufferedReader) {
		Gson gson = new Gson();
		Composicao[] composicaoArray = null;
		composicaoArray = gson.fromJson(bufferedReader, Composicao[].class);
		
		return composicaoArray;
	}
	
}
