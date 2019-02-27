package br.com.bancopan.api.model;

import java.util.List;

public class EstadoMunicipio {
	
	private Long idEstado;
	private List<Municipios> listaMunicipios;
	
	public EstadoMunicipio(Long idEstado, List<Municipios> lista) {
		this.idEstado = idEstado;
		this.listaMunicipios = lista;
	}
	
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado (Long idEstado) {
		this.idEstado = idEstado;
	}

	public List<Municipios> getListaMunicipios() {
		return listaMunicipios;
	}

	public void setListaMunicipios(List<Municipios> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
	}
	
}
