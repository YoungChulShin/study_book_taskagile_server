package task.agile.taskagile.web.payloads;

import lombok.Getter;
import lombok.Setter;
import task.agile.taskagile.domain.application.commands.RegistrationCommand;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegistrationPayload {

  @Size(min = 2, max = 50, message = "username must be between 2 and 50 characters")
  @NotNull
  private String username;

  @Email(message = "Email address should be valid")
  @Size(max = 100, message = "Email address must not be more than 100 characters")
  @NotNull
  private String emailAddress;

  @Size(min = 6, max = 30, message = "password must be between 6 and 30 characters")
  @NotNull
  private String password;

  public RegistrationCommand toCommand() {
    return new RegistrationCommand(username, emailAddress, password);
  }
}
