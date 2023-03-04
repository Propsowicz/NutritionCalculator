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

    public void setCreatedOn(LocalDate createdOn) {
        CreatedOn = createdOn;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    public void setCreatedById(String createdById) {
        CreatedById = createdById;
    }

    public LocalDate getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(LocalDate updatedOn) {
        UpdatedOn = updatedOn;
    }

    public String getUpdatedById() {
        return UpdatedById;
    }

    public void setUpdatedById(String updatedById) {
        UpdatedById = updatedById;
    }

    public LocalDate getDeletedOn() {
        return DeletedOn;
    }

    public void setDeletedOn(LocalDate deletedOn) {
        DeletedOn = deletedOn;
    }

    public String getDeletedById() {
        return DeletedById;
    }

    public void setDeletedById(String deletedById) {
        DeletedById = deletedById;
    }
}
