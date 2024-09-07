import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "b_cli_client")
@NamedQuery(name = "ClientModel", query = "SELECT b_cli_client FROM ClientModel b_cli_client")
@Data
public class ClientModel implements Serializable{

}
