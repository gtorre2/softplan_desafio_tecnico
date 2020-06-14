package br.com.softplan.exercicio1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class GeradorObservacaoTest {

	private GeradorObservacao geradorObservacao;
	
	@Before
	public void setUp() {
		geradorObservacao = new GeradorObservacao();
	}
	
	@Test
	public void geraObservacaoVaziaQuandoNaoExistemNotas() {
		Map<Integer, BigDecimal> codigosMap = new HashMap<>();
		String observacaoGerada = this.geradorObservacao.geraObservacao(codigosMap);
		assertTrue(observacaoGerada.isEmpty());
	}
	
	@Test
	public void geraObservacaoParaUmaNota() {
		Map<Integer, BigDecimal> codigosMap = new HashMap<>();
		codigosMap.put(1, new BigDecimal("10.00"));
		String observacaoGerada = this.geradorObservacao.geraObservacao(codigosMap);

		String observacaoEsperada = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10.0. Total é R$ 10.0";
		assertEquals(observacaoEsperada, observacaoGerada);
	}
	
	@Test
	public void geraObservacaoParaDuasNotas() {
		Map<Integer, BigDecimal> codigos = new LinkedHashMap<>();

		codigos.put(1, new BigDecimal("10.00"));
		codigos.put(2, new BigDecimal("35.00"));

		String observacaoGerada = this.geradorObservacao.geraObservacao(codigos);
		
		String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10.0, 2 cujo valor é R$ 35.0. Total é R$ 45.0";

		assertEquals(observacaoEsperada, observacaoGerada);
	}
	
	@Test
	public void geraObservacaoParaMultiplasNotas() {
		Map<Integer, BigDecimal> codigos = new LinkedHashMap<>();

		codigos.put(1, new BigDecimal("10.00"));
		codigos.put(2, new BigDecimal("35.00"));
		codigos.put(3, new BigDecimal("5.00"));
		codigos.put(4, new BigDecimal("1.500"));
		codigos.put(5, new BigDecimal("0.30"));

		String observacaoGerada = this.geradorObservacao.geraObservacao(codigos);
		
		String observacaoEsperada = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10.0, 2 cujo valor é R$ 35.0, 3 cujo valor é R$ 5.0, 4 cujo valor é R$ 1.5, 5 cujo valor é R$ 0.3. Total é R$ 51.8";
		assertEquals(observacaoEsperada, observacaoGerada);
	}
}