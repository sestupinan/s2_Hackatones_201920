/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hackatones.test.persistence;

import co.edu.uniandes.csw.hackatones.entities.InteresEntity;
import co.edu.uniandes.csw.hackatones.persistence.InteresPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;





/**
 *
 * @author ja.torresl
 */
@RunWith(Arquillian.class)
public class InteresPresistenceTest {
   
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(InteresEntity.class)
                .addClass(InteresPersistence.class)
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Inject
    InteresPersistence cp;

    
    @PersistenceContext
    EntityManager em;
        
    @Test
    public void createTest(){
        
        PodamFactory factory = new PodamFactoryImpl();
        InteresEntity interes = factory.manufacturePojo(InteresEntity.class);
        InteresEntity result = cp.create(interes);
        Assert.assertNotNull(result);
        
        InteresEntity entity = em.find(InteresEntity.class, result.getNombre());
        Assert.assertEquals(interes.getId(), entity.getId());
        Assert.assertEquals(interes.getNombre(), entity.getNombre());
        Assert.assertEquals(interes.getDescripcion(), entity.getDescripcion());
        
    }
}
