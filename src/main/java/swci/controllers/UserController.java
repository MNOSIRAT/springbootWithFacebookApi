package swci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import swci.services.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;
    
    
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public UserController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        
        userService.addFbUser(facebook);
        
        
        System.out.println("NOOOOOOOOOOOOOOO");
        PagedList<Page>pages =facebook.likeOperations().getPagesLiked();
        System.out.println("pages num =" +  pages.size());
        for (Page page : pages) {
            System.out.println("id  = " +page.getId());
            System.out.println("name  = " +page.getName());
        }
        model.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        PagedList<Post> feed = facebook.feedOperations().getFeed();
        model.addAttribute("feed", feed);
        
        return "hello";
    }

}
