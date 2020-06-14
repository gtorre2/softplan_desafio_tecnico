package br.com.softplan.sienge.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import br.com.sienge.model.Composicao;
import br.com.sienge.util.LerArquivoJson;

public class LerArquivoJsonTest {

	private static final String CAMINHO_ARQUIVO_JSON = "dados-entrada-servicos-composicoes.json";
	private static final String CAMINHO_ARQUIVO_JSON_ERRADO = "dados-entrada-servicos-composicoes2.json";
	
	private static final Integer CODIGO_COMPOSICAO = 94793;
	private static final String DESCRICAO_COMPOSICAO = "REGISTRO DE GAVETA BRUTO, LATÃO, ROSCÁVEL, 1 1/4, COM ACABAMENTO E CANOPLA CROMADOS, INSTALADO EM RESERVAÇÃO DE ÁGUA DE EDIFICAÇÃO QUE POSSUA RESERVATÓRIO DE FIBRA/FIBROCIMENTO FORNECIMENTO E INSTALAÇÃO. AF_06/2016";
	private static final String UNIDADE_COMPOSICAO = "UN";
	private static final String TIPO_ITEM = "INSUMO";
	private static final Integer CODIGO_ITEM = 3148;
	private static final String DESCRICAO_ITEM = "FITA VEDA ROSCA EM ROLOS DE 18 MM X 50 M (L X C)";
	private static final String UNIDADE_ITEM = "UN";
	private static final String QUANTIDADE_COMPOSICAO = "0,0190000";
	private static final String VALOR_UNITARIO = "9,40";
	
	private LerArquivoJson lerArquivoJson;
	private Composicao composicao;
	private Composicao composicaoDiferente;
	
	@Before
	public void setUp() {
		lerArquivoJson = new LerArquivoJson();
	}
	
	@Before
    public void initTest() {
        composicao = criarEntidade();
        composicaoDiferente = criarEntidadeDiferente();
    }
	
	private Composicao criarEntidade() {
		Composicao composicao = new Composicao(CODIGO_COMPOSICAO, DESCRICAO_COMPOSICAO, 
								UNIDADE_COMPOSICAO, TIPO_ITEM, CODIGO_ITEM, DESCRICAO_ITEM, 
								UNIDADE_ITEM, QUANTIDADE_COMPOSICAO, VALOR_UNITARIO, null);
		return composicao;
	}
	
	private Composicao criarEntidadeDiferente() {
		Composicao composicao = new Composicao(94797, DESCRICAO_COMPOSICAO, 
								UNIDADE_COMPOSICAO, TIPO_ITEM, CODIGO_ITEM, DESCRICAO_ITEM, 
								UNIDADE_ITEM, QUANTIDADE_COMPOSICAO, VALOR_UNITARIO, null);
		return composicao;
	}
	
	@Test(expected = java.io.IOException.class)
	public void lerArquivoJsonCaminhoErrado() throws UnsupportedEncodingException, FileNotFoundException {
		Composicao[] composicoesGerada = this.lerArquivoJson.receberArquivoJson(CAMINHO_ARQUIVO_JSON_ERRADO);
		Composicao[] composicoesEsperada = new Composicao[1];
		composicoesEsperada[0] = this.composicao;
		
		assertEquals(composicoesEsperada[0].getCodigoComposicao(), composicoesGerada[0].getCodigoComposicao());
	}
	
	@Test
	public void lerArquivoJsonEMontarDados() throws UnsupportedEncodingException, FileNotFoundException {
		Composicao[] composicoesGerada = this.lerArquivoJson.receberArquivoJson(CAMINHO_ARQUIVO_JSON);
		Composicao[] composicoesEsperada = new Composicao[1];
		composicoesEsperada[0] = this.composicao;
		
		assertEquals(composicoesEsperada[0].getCodigoComposicao(), composicoesGerada[0].getCodigoComposicao());
	}
	
	@Test
	public void lerArquivoJsonEMontarDadosDiferentes() throws UnsupportedEncodingException, FileNotFoundException {
		Composicao[] composicoesGerada = this.lerArquivoJson.receberArquivoJson(CAMINHO_ARQUIVO_JSON);
		Composicao[] composicoesEsperada = new Composicao[1];
		composicoesEsperada[0] = this.composicaoDiferente;
		
		assertNotEquals(composicoesEsperada[0].getCodigoComposicao(), composicoesGerada[0].getCodigoComposicao());
	}
	
}
