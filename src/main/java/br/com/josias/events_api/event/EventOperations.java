package br.com.josias.events_api.event;

import br.com.josias.events_api.commons.GeneralOperations;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Event Controller", description = "Manage all event resources")
public interface EventOperations extends GeneralOperations {

    @Operation(
            summary = "Save a new event",
            description = "Endpoint to save an event"
    )
    Event addNewEvent(
            @Parameter(description = "Event object that needs to be saved")
            @RequestBody Event newEvent);

    @Operation(
            summary = "Get all events",
            description = "Endpoint to get all events"
    )
    List<Event> getAllEvents();

    @Operation(
            summary = "Get event by pretty name",
            description = "Endpoint to get event by pretty name"
    )
    ResponseEntity<Event> getEventByPrettyName(
            @Parameter(
                    description = "String event pretty name"
            )
            @PathVariable String prettyName);
}
