package br.com.josias.events_api.subscription;

import br.com.josias.events_api.commons.GeneralOperations;
import br.com.josias.events_api.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Subscription Controller", description = "Manage all subscription resources")
public interface SubscriptionOperations extends GeneralOperations {
    @Operation(
            summary = "Save a subscription in the event",
            description = "Endpoint to save a subscription in the event"
    )
    ResponseEntity<?> createSubscription(
            @Parameter(description = "Pretty name of the event")
            @PathVariable() String prettyName,
            @Parameter(description = "User object that needs to be saved")
            @RequestBody User subscriber,
            @Parameter(description = "User ID")
            @PathVariable(required = false) Integer userId);

    @Operation(
            summary = "Genarate ranking by event",
            description = "Endpoint to generate ranking by event"
    )
    ResponseEntity<?> generateRankingByEvent(
            @Parameter(
                    description = "String event pretty name"
            )
            @PathVariable String prettyName);

    @Operation(
            summary = "Generate ranking by event and user",
            description = "Endpoint to generate ranking by event and user"
    )
    ResponseEntity<?> generateRankingByEventAndUser(
            @Parameter(
                    description = "String event pretty name"
            )
            @PathVariable String prettyName,
            @Parameter(
                    description = "Integer user indentifier"
            )
            @PathVariable Integer userId);
}
