import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by fzy at 14:44 on 2020/10/16.
 */
@Data
@AllArgsConstructor
public class HelloObject implements Serializable {
    private Integer id;
    private String message;
}
