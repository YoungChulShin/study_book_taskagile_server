package task.agile.taskagile.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "app")
@Validated
public class ApplicationProperties {
  /**
   * 시스템에 의해 전송된 이메일의 기본 'from' 값
   */
  @Email
  @NotBlank
  private String mailFrom;

  @NotNull
  private FileStorageSetting fileStorage;

  public String getMailFrom() {
    return mailFrom;
  }

  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  public FileStorageSetting getFileStorage() {
    return fileStorage;
  }

  public void setFileStorage(FileStorageSetting fileStorage) {
    this.fileStorage = fileStorage;
  }

  private static class FileStorageSetting {

    @NotEmpty
    @NotBlank
    private String active;

    public String getActive() {
      return active;
    }

    public void setActive(String active) {
      this.active = active;
    }
  }
}
