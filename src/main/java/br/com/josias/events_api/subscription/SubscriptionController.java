package br.com.josias.events_api.subscription;

import br.com.josias.events_api.commons.exception.EventNotFoundException;
import br.com.josias.events_api.commons.exception.SubscriptionConflictException;
import br.com.josias.events_api.commons.exception.UserIndicadorNotFoundException;
import br.com.josias.events_api.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {
    private SubscriptionService service;

    @PostMapping({"/subscription/{prettyName}", "/subscription/{prettyName}/{userId}"})
    public ResponseEntity<?> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber, @PathVariable(required = false) Integer userId){
        try{
            SubscriptionResponse res = service.createNewSubscription(prettyName, subscriber, userId);
            if (res != null){
                return ResponseEntity.ok(res);
            }

        }catch(EventNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
        catch(SubscriptionConflictException e){
            return ResponseEntity.status(409).body(new ErrorMessage(e.getMessage()));
        }
        catch(UserIndicadorNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/subscription/{prettyName}/ranking")
    public ResponseEntity<?> generateRaningByEvent(@PathVariable String prettyName){
        try{
            return ResponseEntity.ok(service.getCompleteRanking(prettyName).subList(0, 3));
        }catch(EventNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }

    @GetMapping("/subscription/{prettyName}/ranking/{userId}")
    public ResponseEntity<?> generateRaningByEventAndUser(@PathVariable String prettyName, @PathVariable Integer userId){
        try{
            return ResponseEntity.ok(service.getRankingByUser(prettyName, userId));
        }catch(Exception ex){
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }
    }
}
