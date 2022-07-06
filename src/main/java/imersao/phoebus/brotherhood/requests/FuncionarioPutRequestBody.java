package imersao.phoebus.brotherhood.requests;

import lombok.Data;

@Data
public class FuncionarioPutRequestBody {

    private Long id;

    private String name;
    private String role;
    private String email;
}
