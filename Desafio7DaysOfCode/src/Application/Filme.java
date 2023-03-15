package Application;

public class Filme {
	
	private String titulo;
	private String urlIamgem;
	private Double nota;
	private Integer ano;
	
	
	public Filme() {
		
	}
	
	
	public Filme(String titulo, String urlIamgem, Double nota, Integer ano) {
		this.titulo = titulo;
		this.urlIamgem = urlIamgem;
		this.nota = nota;
		this.ano = ano;
	}
	
	
	public String getTitulo() {
		return titulo;
	}
	public String getUrlIamgem() {
		return urlIamgem;
	}
	public Double getNota() {
		return nota;
	}
	public Integer getAno() {
		return ano;
	}

	
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void setUrlIamgem(String urlIamgem) {
		this.urlIamgem = urlIamgem;
	}


	public void setNota(String nota) {
		this.nota = Double.parseDouble(nota);
	}


	public void setAno(String ano) {
		this.ano = Integer.parseInt(ano);
	}


	@Override
	public String toString() {
		return "[Titulo:"+this.titulo+ " Ano: "+this.ano+" Nota: "+this.nota+"]";
	}
}
