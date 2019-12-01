package lab2.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Showroom {
    private UUID id;
    private String name;
    private String address;
    private Integer capacityInCars;

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 256)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showroom showroom = (Showroom) o;
        return Objects.equals(id, showroom.id) &&
                Objects.equals(name, showroom.name) &&
                Objects.equals(address, showroom.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Basic
    @Column(name = "capacity_in_cars", nullable = true)
    public Integer getCapacityInCars() {
        return capacityInCars;
    }

    public void setCapacityInCars(Integer capacityInCars) {
        this.capacityInCars = capacityInCars;
    }
}
