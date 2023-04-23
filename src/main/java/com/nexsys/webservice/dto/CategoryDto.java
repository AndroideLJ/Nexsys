package com.nexsys.webservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

        private int cid;
        private String title;

}
