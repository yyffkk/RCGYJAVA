package com.api.util.Seal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SealCircle {
    private Integer line;
    /**
     * 宽
     */
    private Integer width;
    /**
     * 高
     */
    private Integer height;
}
