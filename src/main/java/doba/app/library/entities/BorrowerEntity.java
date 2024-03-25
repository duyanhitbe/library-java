package doba.app.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import doba.app.library.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "borrowers")
@SQLDelete(sql = "UPDATE borrowers SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at IS NULL")
public class BorrowerEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToMany(targetEntity = BookEntity.class, mappedBy = "borrowers")
    @JsonIgnore
    List<BookEntity> books;

    public BorrowerEntity(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
