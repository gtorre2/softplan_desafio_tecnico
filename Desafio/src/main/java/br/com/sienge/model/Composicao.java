package br.com.sienge.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Composicao{
	
	@SerializedName("codigoComposicao")
	@Expose
	private Integer codigoComposicao;
	
	@SerializedName("descricaoComposicao")
	@Expose
	private String descricaoComposicao;
	
	@SerializedName("unidadeComposicao")
	@Expose
	private String unidadeComposicao;
	
	@SerializedName("tipoItem")
	@Expose
	private String tipoItem;
	
	@SerializedName("codigoItem")
	@Expose
	private Integer codigoItem;
	
	@SerializedName("descricaoItemComposicao")
	@Expose
	private String descricaoItemComposicao;
	
	@SerializedName("unidadeItem")
	@Expose
	private String unidadeItem;
	
	@SerializedName("quantidadeComposicao")
	@Expose
	private String quantidadeComposicao;
	
	@SerializedName("valorUnitario")
	@Expose
	private String valorUnitario;

	private Double valorTotalComposicao;
	
	public Composicao() {
		super();
	}

	public Composicao(Integer codigoComposicao, String descricaoComposicao, String unidadeComposicao, String tipoItem,
			Integer codigoItem, String descricaoItemComposicao, String unidadeItem, String quantidadeComposicao,
			String valorUnitario, Double valorTotalComposicao) {
		this.codigoComposicao = codigoComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.tipoItem = tipoItem;
		this.codigoItem = codigoItem;
		this.descricaoItemComposicao = descricaoItemComposicao;
		this.unidadeItem = unidadeItem;
		this.quantidadeComposicao = quantidadeComposicao;
		this.valorUnitario = valorUnitario;
		this.valorTotalComposicao = valorTotalComposicao;
	}

	public Integer getCodigoComposicao() {
		return codigoComposicao;
	 }
	 
	 public void setCodigoComposicao(Integer codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	 }
	 
	public String getDescricaoComposicao() {
		return descricaoComposicao;
	}
	public void setDescricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
	}
	public String getUnidadeComposicao() {
		return unidadeComposicao;
	}
	public void setUnidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
	}
	public String getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}
	public Integer getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getDescricaoItemComposicao() {
		return descricaoItemComposicao;
	}
	public void setDescricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
	}
	public String getUnidadeItem() {
		return unidadeItem;
	}
	public void setUnidadeItem(String unidadeItem) {
		this.unidadeItem = unidadeItem;
	}
	public String getQuantidadeComposicao() {
		return quantidadeComposicao;
	}
	public void setQuantidadeComposicao(String quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public Double getValorTotalComposicao() {
		return valorTotalComposicao;
	}

	public void setValorTotalComposicao(Double valorTotalComposicao) {
		this.valorTotalComposicao = valorTotalComposicao;
	}
	
}
