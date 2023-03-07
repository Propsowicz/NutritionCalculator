package Domain.Entities.Base;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class EntityId {
    @Id
    public String Id;

    protected String CreateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public EntityId() {
    }

    public String getId() {
        return Id;
    }

    protected void setId(String id) {
        Id = id;
    }
}
