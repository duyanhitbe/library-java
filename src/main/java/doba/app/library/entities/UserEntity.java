package doba.app.library.entities;

import doba.app.library.base.BaseEntity;
import doba.app.library.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at IS NULL")
public class UserEntity extends BaseEntity {
    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;
}
