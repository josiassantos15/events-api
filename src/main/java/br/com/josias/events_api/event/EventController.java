package br.com.josias.events_api.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("events")
public class EventController implements EventOperations {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping()
    public Event addNewEvent(@RequestBody Event newEvent) {
        return service.addNewEvent(newEvent);
    }

    @GetMapping()
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{prettyName}")
    public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName) {
        Event evt = service.getByPrettyName(prettyName);
        if (Objects.nonNull(evt)) {
            return ResponseEntity.ok().body(evt);
        }
        return ResponseEntity.notFound().build();
    }
}
