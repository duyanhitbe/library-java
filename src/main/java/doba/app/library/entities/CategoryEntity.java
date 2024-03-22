package doba.app.library.entities;

import doba.app.library.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
@SQLDelete(sql = "UPDATE categories SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at IS NULL")
public class CategoryEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
}
