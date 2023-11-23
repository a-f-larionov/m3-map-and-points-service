package m3.gameplay.dto.rq;

import lombok.*;
import lombok.experimental.SuperBuilder;
import m3.lib.dto.rq.UserIdRqDto;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OnFinishRqDto extends UserIdRqDto {

    private Long pointId;
    private Long score;
    private Long chestId;
}