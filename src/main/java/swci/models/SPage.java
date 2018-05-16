/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swci.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author NOSIRAT
 */

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class SPage {
    
    @Id
    @GeneratedValue
    public int Id ;

    public String name;
    public String fbid;

    public SPage(String name, String FbId) {
        this.name = name;
        this.fbid = FbId;
    }
    
    
}