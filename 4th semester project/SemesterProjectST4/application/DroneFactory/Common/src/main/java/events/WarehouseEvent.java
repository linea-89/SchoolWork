package events;

import com.hazelcast.internal.json.JsonObject;
import org.springframework.context.ApplicationEvent;

public class WarehouseEvent {

    public enum EventType{
        WAITING(-1),

        STARTING(0),

        IDLE(1),
        EXECUTING(2),
        ERROR(3),
        ;

        private final int eventId;

        EventType(int eventId) {
            this.eventId = eventId;
        }

        public int getEventId() {
            return eventId;
        }

        public static EventType getEventType(int i) {
            for (EventType event: EventType.values()) {
                if(event.getEventId() == i) {
                    return event;
                }
            }
            return null;
        }
    }

    private final EventType eventType;

    public WarehouseEvent(int eventId) {
        this.eventType = EventType.getEventType(eventId);
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        JsonObject jsonEvent = new JsonObject();
        jsonEvent.add("System", "Warehouse");
        jsonEvent.add("State", getEventType().getEventId());
        return jsonEvent.toString();
    }
}