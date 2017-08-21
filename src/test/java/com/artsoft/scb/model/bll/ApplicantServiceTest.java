package com.artsoft.scb.model.bll;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.artsoft.scb.model.dao.ApplicantRepository;
import com.artsoft.scb.model.dao.DocumentTypeRepository;
import com.artsoft.scb.model.entity.Applicant;
import com.artsoft.scb.model.entity.DocumentType;

//http://www.baeldung.com/spring-boot-testing
@RunWith(SpringRunner.class)
public class ApplicantServiceTest {

	@TestConfiguration
    static class ApplicantServiceTestContextConfiguration {
  
        @Bean
        public ApplicantService applicantService() {
            return new ApplicantService();
        }
    }
	
	@Autowired
    private ApplicantService applicantService;
 
    @MockBean
    private ApplicantRepository applicantRepository;
	
    @MockBean
    private DocumentTypeRepository documentTypeRepository;
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void whenNoDocumentType_thenException() {
    	
    	boolean isCreated = false;
        
    	Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");        
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("hola");
        
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
        
    @Test
    public void whenNoExistsDocumentType_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
    	Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("hola");
        
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenNoDocumentNumber_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
    	Applicant alex = new Applicant();  
    	alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("hola");
        
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenNoEmail_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
    	Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
    	alex.setDocumentType(documentType);
    	  alex.setFirstName("Walter");
          alex.setFirstLastName("Alonso");
          alex.setPassword("hola");
          
    	 Mockito.when(documentTypeRepository.findOne(1))
         .thenReturn(documentType); 
    	 
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenWrongEmail_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
        Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alexhotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("hola");
    	 
    	 Mockito.when(documentTypeRepository.findOne(1))
         .thenReturn(documentType); 
    	 
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenEmptyLastName_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
        Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("");
        alex.setPassword("hola");
    	 
    	 Mockito.when(documentTypeRepository.findOne(1))
         .thenReturn(documentType); 
    	 
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenNoPassword_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
        Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
            	 
    	 Mockito.when(documentTypeRepository.findOne(1))
         .thenReturn(documentType); 
    	 
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenEmptyPassword_thenException() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
        Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("");
        
    	 Mockito.when(documentTypeRepository.findOne(1))
         .thenReturn(documentType); 
    	 
		try {
			isCreated = applicantService.createApplicant(alex);
			fail();
		} catch (Exception e) {
			assertNotNull(e);
		}      
         assertFalse(isCreated);
     }
    
    @Test
    public void whenValidApplicant_thenApplicantIsSaved() {
    	
    	boolean isCreated = false;
    	DocumentType documentType = new DocumentType();
        documentType.setId(1);
        
    	Applicant alex = new Applicant();
    	alex.setDocumentNumber("1014207335");
        alex.setEmail("alex@hotmail.com");
        alex.setDocumentType(documentType);
        alex.setFirstName("Walter");
        alex.setFirstLastName("Alonso");
        alex.setPassword("hola");
        
        Mockito.when(documentTypeRepository.findOne(1))
          .thenReturn(documentType);        
        Mockito.when(applicantRepository.save(alex))
        .thenReturn(alex);
        
		try {
			isCreated = applicantService.createApplicant(alex);
		} catch (Exception e) {
			fail();
		}      
         assertTrue(isCreated);
     }    
}
