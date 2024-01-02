namespace java com.example.archi.infra.tools.thriftService

struct InternalLeadDto {
    1: string name
    2: double annualRevenue
    3: string phone
    4: string street
    5: string postalCode
    6: string city
    7: string country
    8: string creationDate
    9: string company
    10: string state
}

service InternalCRMService {
    list<InternalLeadDto> findLeads(1: double lowAnnualRevenue, 2: double highAnnualRevenue ,3: string state)
    list<InternalLeadDto> findLeadsByDate(1: string startDate, 2: string endDate)
    void deleteLead(1: InternalLeadDto lead)
    void addLead(1: InternalLeadDto leadDto)
}

