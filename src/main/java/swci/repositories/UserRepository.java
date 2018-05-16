/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swci.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import swci.models.SUser;

/**
 *
 * @author NOSIRAT
 */
@Repository
public interface UserRepository extends CrudRepository<SUser, Integer>{

    public SUser findOneByfbid(String FbId);
    
}
