/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swci.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Page;
import org.springframework.stereotype.Service;
import swci.models.SPage;
import swci.models.SUser;
import swci.repositories.PageRepository;
import swci.repositories.UserRepository;

/**
 *
 * @author NOSIRAT
 */
@Service 
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PageRepository pageRepository;

    public void add(SUser user) {
        SUser u= userRepository.findOneByfbid(user.fbid);
        if (u==null){
            userRepository.save(user);
        }
    }

    public void addFbUser(Facebook facebook) {
        String userId=facebook.userOperations().getUserProfile().getId();
        String username=facebook.userOperations().getUserProfile().getName();
        SUser user = new SUser( username, userId);
        add(user);
        
        for (Page page : facebook.likeOperations().getPagesLiked()) {
            SPage sPage = new SPage(page.getName(),page.getId());
            addPage(sPage);
        }
        
    }

    private void addPage(SPage spage) {
        SPage u= pageRepository.findOneByfbid(spage.fbid);
        if (u==null){
            pageRepository.save(spage);
        }
    }
    
}
