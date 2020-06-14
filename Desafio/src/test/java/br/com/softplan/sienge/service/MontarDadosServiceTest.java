package br.com.softplan.sienge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.sienge.service.MontarDadosService;

public class MontarDadosServiceTest {

	private static final String CAMINHO_ARQUIVO_JSON = "dados-entrada-servicos-composicoes.json";
	private static final String CAMINHO_ARQUIVO_JSON_ERRADO = "dados-entrada-servicos-composicoes2.json";
	
	private MontarDadosService montarDados;
	
	@Before
	public void setUp() {
		montarDados = new MontarDadosService();
	}
	
	@Test(expected = java.io.IOException.class)
	public void caminhoArquivoJSONErrado() throws UnsupportedEncodingException, FileNotFoundException {
		List<String> listaGerada = this.montarDados.listarDados(CAMINHO_ARQUIVO_JSON_ERRADO);
		List<String> listaEsperada = this.listaComDadosIguais();
		assertEquals(listaEsperada, listaGerada);
	}
	
	@Test
	public void montarComposicaoComDadosIguais() throws UnsupportedEncodingException, FileNotFoundException {
		List<String> listaGerada = this.montarDados.listarDados(CAMINHO_ARQUIVO_JSON);
		List<String> listaEsperada = this.listaComDadosIguais();
		
		assertEquals(listaEsperada, listaGerada);
	}
	
	@Test
	public void montarComposicaoComDadosDiferentes() throws UnsupportedEncodingException, FileNotFoundException {
		List<String> listaGerada = this.montarDados.listarDados(CAMINHO_ARQUIVO_JSON);
		List<String> listaEsperada = this.listaComDadosDiferentes();
		assertNotEquals(listaEsperada, listaGerada);
	}

	public List<String> listaComDadosIguais() {
		 List<String> listaComposicaoEsperada = new ArrayList<String>();
		 listaComposicaoEsperada.add("94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016 UN 128,61");
		 listaComposicaoEsperada.add("98561 IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018 M2 28,75");
		 listaComposicaoEsperada.add("87286 ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014 M3 289,98");
		 listaComposicaoEsperada.add("88830 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHP DIURNO. AF_10/2014 CHP 1,25");
		 listaComposicaoEsperada.add("88831 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014 CHI 0,22");
		 return listaComposicaoEsperada;
	 }
	 	 
	public List<String> listaComDadosDiferentes() {
		 List<String> listaComposicaoEsperada = new ArrayList<String>();
		 listaComposicaoEsperada.add("94793 REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016 UN 128,61");
		 listaComposicaoEsperada.add("98561 IMPERMEABILIZAÇÃO DE PAREDES COM ARGAMASSA DE CIMENTO E AREIA, COM ADITIVO IMPERMEABILIZANTE, E = 2CM. AF_06/2018 M2 28,75");
		 listaComposicaoEsperada.add("87286 ARGAMASSA TRAÇO 1:1:6 (CIMENTO, CAL E AREIA MÉDIA) PARA EMBOÇO/MASSA ÚNICA/ASSENTAMENTO DE ALVENARIA DE VEDAÇÃO, PREPARO MECÂNICO COM BETONEIRA 400 L. AF_06/2014 M3 289,98");
		 listaComposicaoEsperada.add("88830 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHP DIURNO. AF_10/2014 CHP 1,25");
		 listaComposicaoEsperada.add("88834 BETONEIRA CAPACIDADE NOMINAL DE 400 L, CAPACIDADE DE MISTURA 280 L, MOTOR ELÉTRICO TRIFÁSICO POTÊNCIA DE 2 CV, SEM CARREGADOR - CHI DIURNO. AF_10/2014 CHI 0,22");
		 return listaComposicaoEsperada;
	 }
	
}
