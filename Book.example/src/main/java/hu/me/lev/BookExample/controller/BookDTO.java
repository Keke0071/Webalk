package hu.me.lev.BookExample.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

    @Data
    @ToString
    @AllArgsConstructor
    public class BookDTO {
        @Min(0)
        private  Integer isbn;
        @NotBlank
        private  String name;
        @NotBlank
        private String type;
        @Min(0)
        private Integer available;
        @Min(0)
        private Long author_id;
    }


