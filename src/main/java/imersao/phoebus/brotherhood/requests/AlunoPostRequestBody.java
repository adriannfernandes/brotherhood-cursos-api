package imersao.phoebus.brotherhood.requests;

import lombok.Data;

@Data
public class AlunoPostRequestBody {

    private Long id;

    private String name;
    private String dataNascimento;
    private String phone;
    private String course;
}
