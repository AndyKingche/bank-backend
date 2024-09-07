import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="b_cli_person")
@NamedQuery(name="PersonModel.findAll", query="SELECT b_cli_person FROM PersonModel b_cli_person")
@Data
public class PersonModel implements Serializable{



}
