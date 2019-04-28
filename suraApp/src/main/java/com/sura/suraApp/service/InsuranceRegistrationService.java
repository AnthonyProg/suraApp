package com.sura.suraApp.service;

import com.sura.suraApp.dao.ClientRepository;
import com.sura.suraApp.dao.PropertyRepository;
import com.sura.suraApp.dao.RegisterRepository;
import com.sura.suraApp.entities.Client;
import com.sura.suraApp.entities.Property;
import com.sura.suraApp.entities.Register;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Calendar;
import java.util.Date;


@Service
public class InsuranceRegistrationService {

    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    RegisterRepository registerRepository;
    @Autowired
    ClientRepository clientRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Register register(Property property) throws Exception{
        try(Session session = entityManager.unwrap(Session.class)){
            if(loadClient(property.getClient().getIdDocument(), session) != null){
                property.setClient(loadClient(property.getClient().getIdDocument(), session));
                propertyRepository.saveAndFlush(property);
                return createAndSaveRegister(property);
            }else{
                clientRepository.saveAndFlush(property.getClient());
                propertyRepository.saveAndFlush(property);
                return createAndSaveRegister(property);
            }
        }catch (Exception ignored){
            throw new Exception("Error creating insurance registration");
        }
    }

    private Client loadClient(long clientId, Session session) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
        Root<Client> root = criteriaQuery.from(Client.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("idDocument"), clientId));
        Query<Client> query = session.createQuery(criteriaQuery);
        return query.uniqueResult();
    }

    private Register createAndSaveRegister(Property property){
        Date registerDate = Calendar.getInstance().getTime();
        double totalPremiumValue = calculatePremium(property.getValue());
        Register register = new Register();
        register.setRegisterDate(registerDate);
        register.setPremiumValue(totalPremiumValue);
        register.setProperty(property);
        registerRepository.saveAndFlush(register);
        return register;
    }

    private double calculatePremium(Double propertyValue){
       double partialValue = (propertyValue * 0.05D) / 12;
       double commissions = partialValue * 0.01D;
       return partialValue + commissions;
    }
}
