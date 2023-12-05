package com.example.archi.archi.tools;


import com.example.archi.archi.model.standard.ModelTO;

public interface CRMDataConverter<T> {
	public ModelTO convertDatas(T dataType);
}
