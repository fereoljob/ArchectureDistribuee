package com.example.archi.archi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.example.archi.archi.CRMClient.Client;
import com.example.archi.archi.model.ModelTO;
import com.example.archi.archi.model.VirtualLeadDTO;

@Service
public class VirtualCRMServiceIMPL implements  VirtualCRMService{	
	
	private List<Client> listClients;

	public VirtualCRMServiceIMPL(List<Client> listCli) throws IOException{
		listClients = listCli;
	}
	
	@Override
	public List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue,String state) {
		List<VirtualLeadDTO> listClientDto = new ArrayList<>();
		for(Client c : listClients){
			(c.findLeads(lowAnnualRevenue, highAnnualRevenue, state)).forEach( elem -> {listClientDto.add(VirtualMapper.fromModelToVirtual(elem));});

		}
		return listClientDto;
	}

	@Override
	public List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
