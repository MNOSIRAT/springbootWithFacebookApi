/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swci.repositories;

/**
 *
 * @author NOSIRAT
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import swci.models.SPage;
import swci.models.SUser;

/**
 *
 * @author NOSIRAT
 */
@Repository
public interface PageRepository extends CrudRepository<SPage, Integer>{

    public SPage findOneByfbid(String FbId);
    
}
