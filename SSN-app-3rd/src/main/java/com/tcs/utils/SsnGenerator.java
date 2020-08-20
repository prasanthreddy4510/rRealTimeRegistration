package com.tcs.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import com.tcs.entities.SsnDetailsEntity;

@Component
public class SsnGenerator implements IdentifierGenerator{
	
	 Random r = new Random();
	    Session session;

	    int attempt = 0;

	    public int generate9DigitNumber()
	    {
	        int aNumber = (int) ((Math.random() * 900000000) + 100000000); 
	        return aNumber;
	    }


	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		 session = (SharedSessionContractImplementor) session;
	        Integer id = generateRandomIndex();
	        return id;
		 
	}
	

    public Integer generateRandomIndex()
    {
            for (int i = 0; i < 3; i++)
    {
        Integer a = generate9DigitNumber();

        if (session.get(SsnDetailsEntity.class, a) == null)
        {
            return a;
        } 
    }

    for (int i = 100000000; i < 999999999; i++)
    {
        if (session.get(SsnDetailsEntity.class, i) == null)
        {
            return i;
        }
    }
        return null;
    }


	 
}
