package org.tony.com.JPetStoreRest;

import org.springframework.samples.jpetstore.domain.Account;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AccountRestfulClientTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AccountRestfulClientTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AccountRestfulClientTest.class );
    }

    
    public void testGetAccount()
    {
        AccountRestfulClient tested = new AccountRestfulClient();
        Account account = tested.getAccount("j2ee");
        
        assertEquals("hexiang", account.getFirstName());
        
    }
}
