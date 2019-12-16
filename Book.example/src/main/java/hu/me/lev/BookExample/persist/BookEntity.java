package hu.me.lev.BookExample.persist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "car")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookEntity{

    @Id
    private Integer isbn;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @Min(0)
    private  Integer available;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private AuthorerEntity authorerEntity;



}