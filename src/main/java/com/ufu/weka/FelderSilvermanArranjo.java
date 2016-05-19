package com.ufu.weka;

public enum FelderSilvermanArranjo {

	SenAtiSeqVis("SenAtiSeqVis"),
	SenAtiSeqVer("SenAtiSeqVer"),
	SenAtiGloVis("SenAtiGloVis"),
	SenAtiGloVer("SenAtiGloVer"),
	SenRefSeqVis("SenRefSeqVis"),
	SenRefSeqVer("SenRefSeqVer"),
	SenRefGloVis("SenRefGloVis"),
	SenRefGloVer("SenRefGloVer"),
	
	IntAtiSeqVis("IntAtiSeqVis"),
	IntAtiSeqVer("IntAtiSeqVer"),
	IntAtiGloVis("IntAtiGloVis"),
	IntAtiGloVer("IntAtiGloVer"),
	IntRefSeqVis("IntRefSeqVis"),
	IntRefSeqVer("IntRefSeqVer"),
	IntRefGloVis("IntRefGloVis"),
	IntRefGloVer("IntRefGloVer");
	
	private final String valor;
	
	FelderSilvermanArranjo(String valorOpcao) {
		valor = valorOpcao;
	}
	
	public String getValor() {
		return valor;
	}
}

