package Domain.Entities.Base;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class DomainEventsData extends EntityId{
    public LocalDate CreatedOn;
    public String CreatedById;

    public LocalDate UpdatedOn;
    public String UpdatedById;

    public LocalDate DeletedOn;
    public String DeletedById;

    public DomainEventsData() {
    }

    public LocalDate getCreatedOn() {
        return CreatedOn;
    }

    protected void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    protected void setCreatedById(String createdById) {
        CreatedById = createdById;
    }

    public LocalDate getUpdatedOn() {
        return UpdatedOn;
    }

    protected void setUpdatedOn(LocalDate updatedOn) {
        UpdatedOn = updatedOn;
    }

    public String getUpdatedById() {
        return UpdatedById;
    }

    protected void setUpdatedById(String updatedById) {
        UpdatedById = updatedById;
    }

    public LocalDate getDeletedOn() {
        return DeletedOn;
    }

    protected void setDeletedOn(LocalDate deletedOn) {
        DeletedOn = deletedOn;
    }

    public String getDeletedById() {
        return DeletedById;
    }

    protected void setDeletedById(String deletedById) {
        DeletedById = deletedById;
    }
}
