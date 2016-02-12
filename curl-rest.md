Calling rest API through cURL.
Assuming app url is http://localhost:8080/organization-rest

- Get List of Companies
    - curl -v -H "Accept:application/json" http://localhost:8080/organization-rest/company/list
    
- Get Company
    - curl -v -H "Accept:application/json" http://localhost:8080/organization-rest/company/QWERTY

- Add Company
    - curl -v -H "Content-Type:application/json" -X PUT http://localhost:8080/organization-rest/company -d '{ "id": "IYTYTR", "name": "Oliver Bakers", "address": "SL11EP", "city": "Slough", "country": "UK", "email": "contact@ob.com", "phone": "+447348762255", "employees" : [ { "id" : "E1232", "firstName" : "Amit", "lastName" : "Kumar"}, { "id" : "E1243", "firstName" : "Chris", "lastName" : "Kuehen" } ] }'

- Update Company
    - curl -v -H "Content-Type:application/json" -X POST http://localhost:8080/organization-rest/company -d '{ "id": "IYTYTR", "name": "Oliver Bakers", "address": "SL11EP", "city": "Slough", "country": "UK", "email": "contact@ob.com", "phone": "+447348762255", "employees" : [ { "id" : "E1232", "firstName" : "Amit", "lastName" : "Kumar"}, { "id" : "E1243", "firstName" : "Chris", "lastName" : "Kuehen" } ] }'                                                                                                                   	

- Add Owners
    - curl -v -H "Content-Type:application/json" -X PUT http://localhost:8080/organization-rest/company/QWERTY/owners -d '{ "owners":[ "BitWise", "Tera Mines", "Delta group" ] }'