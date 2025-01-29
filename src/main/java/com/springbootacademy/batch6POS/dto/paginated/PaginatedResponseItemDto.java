package com.springbootacademy.batch6POS.dto.paginated;

import com.springbootacademy.batch6POS.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDto {
    private List<ItemDTO> list;
    private long dataCount;
}
