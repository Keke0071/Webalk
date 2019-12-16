package hu.me.lev.BookExample.persist;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;

    @ToString
    @Entity
    @Table(name = "manufacturer")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AuthorerEntity {

        @Id
        @Min(1)
        private Long id;
        @NotBlank
        private  String name;
        private Date Created;
        @OneToMany (mappedBy = "authorerEntity")
        private List<BookEntity> books;

    }
