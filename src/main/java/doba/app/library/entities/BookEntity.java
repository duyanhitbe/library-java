package doba.app.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import doba.app.library.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;
import java.util.UUID;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@SQLDelete(sql = "UPDATE books SET deleted_at = NOW() WHERE id=?")
@SQLRestriction("deleted_at IS NULL")
public class BookEntity extends BaseEntity {
    @Column(name = "category_id")
    @JsonProperty("category_id")
    private UUID categoryId;

    @Column(name = "book_info_id")
    @JsonProperty("book_info_id")
    private UUID bookInfoId;

    @OneToOne(targetEntity = BookInfoEntity.class)
    @JoinColumn(name = "book_info_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonProperty("book_info")
    private BookInfoEntity bookInfo;

    @ManyToOne(targetEntity = CategoryEntity.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToMany(targetEntity = BorrowerEntity.class)
    @JoinTable(
            name = "book_borrower",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "borrower_id")
    )
    @JsonIgnore
    List<BorrowerEntity> borrowers;

    public BookEntity(UUID categoryId, UUID bookInfoId) {
        this.categoryId = categoryId;
        this.bookInfoId = bookInfoId;
    }
}
