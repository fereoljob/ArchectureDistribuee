package com.example.archi.archi.tools;

import java.util.List;

import com.example.archi.archi.model.standard.ModelTO;

public interface CRMDataConverter<T> {
	public List<ModelTO> convertDatas(T dataType);
}
