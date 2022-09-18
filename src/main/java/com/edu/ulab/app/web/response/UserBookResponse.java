package com.edu.ulab.app.web.response;

import com.edu.ulab.app.mapper.BookMapper;
import com.edu.ulab.app.web.request.BookRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserBookResponse {
    private Long userId;
    private List<Long> booksIdList;
}
