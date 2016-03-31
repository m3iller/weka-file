package com.ufu.weka;

public class LearningObject {

	private Integer id;
	
	private Integer global;
	private Integer sequencial;
	private Integer visual;
	private Integer verbal;
	private Integer ativo;
	private Integer reflexivo;
	private Integer intuitivo;
	private Integer sensitivo;
	
	public Integer getGlobal() {
		return global;
	}
	public void setGlobal(Integer global) {
		this.global = global;
	}
	public Integer getSequencial() {
		return sequencial;
	}
	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}
	public Integer getVisual() {
		return visual;
	}
	public void setVisual(Integer visual) {
		this.visual = visual;
	}
	public Integer getVerbal() {
		return verbal;
	}
	public void setVerbal(Integer verbal) {
		this.verbal = verbal;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	public Integer getReflexivo() {
		return reflexivo;
	}
	public void setReflexivo(Integer reflexivo) {
		this.reflexivo = reflexivo;
	}
	public Integer getIntuitivo() {
		return intuitivo;
	}
	public void setIntuitivo(Integer intuitivo) {
		this.intuitivo = intuitivo;
	}
	public Integer getSensitivo() {
		return sensitivo;
	}
	public void setSensitivo(Integer sensitivo) {
		this.sensitivo = sensitivo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LearningObject other = (LearningObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.ativo + "," + this.reflexivo+ "," +
				 this.sensitivo + "," + this.intuitivo + ","  +
				 this.sequencial + "," + this.global + "," +
				this.visual + "," + this.verbal;
				
	}
}
