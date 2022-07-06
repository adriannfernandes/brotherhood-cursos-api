package imersao.phoebus.brotherhood.requests;

import lombok.Data;

@Data
public class AlunoPutRequestBody {

    private Long Id;
    private String name;
    private String dataNascimento;
    private String phone;
    private String course;
}
