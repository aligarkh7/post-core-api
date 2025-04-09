package kz.dar.academy.postcoreapi.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String postId;
    @Column(unique = true)
    private String clientId;
    @Column(unique = true)
    private String postRecipientId;
    @Column(nullable = false, length = 50)
    private String postItem;
    @Column(nullable = false, length = 50)
    private String status;
}
