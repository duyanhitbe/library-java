package doba.app.library.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.Date;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_infos")
@SQLDelete(sql = "UPDATE book_infos SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at IS NULL")
public class BookInfoEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "publication_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("publication_date")
    private Date publicationDate;
}
