package br.com.softplan.sienge.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.com.sienge.model.Composicao;
import br.com.sienge.service.MontarComposicaoService;

public class MontarComposicaoServiceTest {
	
	private static final Integer CODIGO_COMPOSICAO = 88830;
	private static final String DESCRICAO_COMPOSICAO = "TESTE";
	private static final String UNIDADE_COMPOSICAO = "UN";
	private static final String TIPO_ITEM = "CHI";
	private static final Integer CODIGO_ITEM = 33245;
	private static final String DESCRICAO_ITEM = "ITEM TESTE";
	private static final String UNIDADE_ITEM = "INSUMO";
	private static final String QUANTIDADE_COMPOSICAO = "1,0000000";
	private static final String VALOR_UNITARIO = "0,86";
	private static final Double VALOR_TOTAL_COMPOSICAO = new Double(2);
	
	private MontarComposicaoService montarComposicao;
	
	private Composicao composicao;
	
	@Before
	public void setUp() {
		montarComposicao = new MontarComposicaoService();
	}
	
	@Before
    public void initTest() {
        composicao = criarEntidade();
    }
	
	private Composicao criarEntidade() {
		Composicao composicao = new Composicao(CODIGO_COMPOSICAO, DESCRICAO_COMPOSICAO, 
								UNIDADE_COMPOSICAO, TIPO_ITEM, CODIGO_ITEM, DESCRICAO_ITEM, 
								UNIDADE_ITEM, QUANTIDADE_COMPOSICAO, VALOR_UNITARIO, VALOR_TOTAL_COMPOSICAO);
		return composicao;
	}

	@Test
	public void montarComposicaoComDadosIguais() {
		Composicao[] composicoes = new Composicao[1];
	    composicoes[0] = this.composicao;
		
		Map<Integer, Composicao> mapaComposicao = new LinkedHashMap<Integer, Composicao>();
		mapaComposicao.put(88830, composicao);

		Map<Integer, Composicao> mapaGerado = this.montarComposicao.listarComposicoes(composicoes, mapaComposicao);
		
		Map<Integer, Composicao> mapaEsperado = new LinkedHashMap<Integer, Composicao>();
		mapaEsperado.put(88830, this.composicao);
		
		assertEquals(mapaEsperado, mapaGerado);
	}
	
	@Test
	public void montarComposicaoComDadosDiferentes() {
		Composicao[] composicoes = new Composicao[1];
	    composicoes[0] = this.composicao;
		
		Map<Integer, Composicao> mapaComposicao = new LinkedHashMap<Integer, Composicao>();
		mapaComposicao.put(88830, this.composicao);

		Map<Integer, Composicao> mapaGerado = this.montarComposicao.listarComposicoes(composicoes, mapaComposicao);
		
		Map<Integer, Composicao> mapaEsperado = new LinkedHashMap<Integer, Composicao>();
		mapaEsperado.put(88833, this.composicao);
		
		assertNotEquals(mapaEsperado, mapaGerado);
	}
	
}
