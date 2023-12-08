package com.example.archi.archi.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.archi.archi.CRMClient.Client;
import com.example.archi.archi.geoLocalisationClient.GeoLocalisationClient;
import com.example.archi.archi.model.ModelTO;
import com.example.archi.archi.model.VirtualLeadDTO;

@Service
public class VirtualCRMServiceIMPL implements  VirtualCRMService{	
	
	private List<Client> listClients;
	private GeoLocalisationClient geoClient;
	public VirtualCRMServiceIMPL(List<Client> listCli,GeoLocalisationClient geoCli) throws IOException{
		listClients = listCli;
		geoClient = geoCli;
	}
	
	@Override
	public List<VirtualLeadDTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue,String state) {
		List<VirtualLeadDTO> listClientDto = new ArrayList<>();
		for(Client c : listClients){
			(c.findLeads(lowAnnualRevenue, highAnnualRevenue, state)).forEach( elem -> {listClientDto.add(VirtualMapper.fromModelToVirtual(elem));});

		}
		for(VirtualLeadDTO cli : listClientDto) {
			System.out.println("Street : " +cli.getStreet());
			System.out.println(geoClient.extractLongAndLat(cli.getStreet()));
		}
		
		return listClientDto;
	}

	@Override
	public List<VirtualLeadDTO> findLeadsByDate(String startDate, String endDate) throws TException {
		// TODO Auto-generated method stub
		return null;
	}

}
