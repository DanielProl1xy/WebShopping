package commerce.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/admin")
public class AdminShopController {
    
    @ModelAttribute
    private void checkAccess() {
        if(!hasAdminRights()) {
            throw new SecurityException("Access denied: Admin rights are required to see this site.");
        }
    }    
    
    @GetMapping
    @ResponseBody
    public String viewAdminMenu() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    
    private boolean hasAdminRights() {
        // TODO: check access
        return false;
    }
}
