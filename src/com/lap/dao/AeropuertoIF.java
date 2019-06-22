package com.lap.dao;

import java.util.List;

import com.lap.dto.AeropuertoDTO;

public interface AeropuertoIF {

	public List getAllVuelos();
	public String getCompania(String codigo);
	public AeropuertoDTO getAeropuerto(String codigo);
}
