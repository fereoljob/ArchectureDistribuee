package com.example.archi.archi.CRMClient;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.archi.archi.model.ModelTO;
import com.example.archi.archi.thriftService.InternalCRMService;
import com.example.archi.archi.thriftService.InternalLeadDto;
import com.example.archi.archi.tools.CRMDataConverter;
@Component
public class InternalCRMClientConnection implements Client {
    @Autowired
    @Qualifier("internalConverter")
    private CRMDataConverter<InternalLeadDto> converter; 
    @Override
    public List<ModelTO> getAllUsers() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public List<ModelTO> findLeadsByDate(String startDate, String endDate) {
        TTransport tr = null ;
        try {
            tr = getTransport();
        }catch(TTransportException e){
            e.printStackTrace();
        }
        TProtocol protocol = new  TBinaryProtocol(tr);
        InternalCRMService.Client client = new InternalCRMService.Client(protocol);
        List<InternalLeadDto> listLeads = new ArrayList<>();
        try  {
            listLeads = client.findLeadsByDate(startDate, endDate);
        }catch(TException e){
            e.printStackTrace();
        }
        List<ModelTO> modelTOList = new ArrayList<>();
        listLeads.forEach(element -> {modelTOList.add(converter.convertDatas(element));});
        tr.close();
        return modelTOList;
            

    }

    @Override
    public List<ModelTO> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
         TTransport tr = null ;
        try {
            tr = getTransport();
        }catch(TTransportException e){
            e.printStackTrace();
        }
        TProtocol protocol = new  TBinaryProtocol(tr);
        InternalCRMService.Client client = new InternalCRMService.Client(protocol);
        List<InternalLeadDto> listLeads = new ArrayList<>();
        try  {
            listLeads = client.findLeads(lowAnnualRevenue, highAnnualRevenue, state);
        }catch(TException e){
            e.printStackTrace();
        }
        List<ModelTO> modelTOList = new ArrayList<>();
        listLeads.forEach(element -> {modelTOList.add(converter.convertDatas(element));});
        tr.close();
        return modelTOList;
    }

    private TTransport getTransport() throws TTransportException{
    TTransport transport;
    transport = new TSocket("localhost", 9090);
    transport.open();
      return transport;

    }
    
}
