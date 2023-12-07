package com.example.archi.archi.tools;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.archi.archi.model.ModelTO;
import com.example.archi.archi.thriftService.InternalLeadDto;
@Component("internalConverter")
public class InternalCRMDataConverter implements CRMDataConverter<InternalLeadDto> {

    @Override
    public ModelTO convertDatas(InternalLeadDto dataType) {
        ModelTO model = new ModelTO(dataType.getFirstName(), dataType.getLastName(),
         dataType.getAnnualRevenue(), dataType.getPhone(), dataType.getStreet(), dataType.getPostalCode(),
          dataType.getCity(), dataType.getCountry(), dataType.getCompany(), dataType.getCreationDate(), dataType.getState());
        return model;
    }
    
}
