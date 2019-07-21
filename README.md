# hibernate-map

    git clone https://github.com/joes-code/hibernate-map.git
    cd hibernate-map
    mvn clean test

The test will fail with below exception.

    javax.persistence.PersistenceException: org.hibernate.TypeMismatchException: Provided id of the wrong type for class com.joe.example.hibernate_map.test.entity.AssetDetail. Expected: class com.joe.example.hibernate_map.test.entity.AssetDetailId, got class com.joe.example.hibernate_map.test.entity.AssetId
    
    	at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:154)
    	at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:181)
    	at org.hibernate.internal.ExceptionConverterImpl.convert(ExceptionConverterImpl.java:188)
    	at org.hibernate.internal.SessionImpl.fireMerge(SessionImpl.java:916)
    	at org.hibernate.internal.SessionImpl.merge(SessionImpl.java:890)
    	at com.joe.example.hibernate_map.test.service.HibernateTest.update(HibernateTest.java:61)
    	at com.joe.example.hibernate_map.test.service.HibernateTest.testSaveAndUpdate(HibernateTest.java:52)

But if you comment out the following line in the test, it passes.

    session.detach(asset);