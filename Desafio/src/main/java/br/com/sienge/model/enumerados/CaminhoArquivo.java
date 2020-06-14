package br.com.sienge.model.enumerados;

public enum CaminhoArquivo {

	CAMINHO_ARQUIVO_JSON("dados-entrada-servicos-composicoes.json");
    	
    private final String path;
	
	CaminhoArquivo(String path){
        this.path = path;
    }

    public String getPath() {
    	return path;
    }
    
}
