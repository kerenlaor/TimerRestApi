package target.src.main.java.com.schemas.modelRest;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Response of the parent.
 */

@Schema(name = "TimerCountdownResponse", description = "Response of the parent.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-28T10:03:45.070482+02:00[Asia/Jerusalem]")
public class TimerCountdownResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private Integer numberOfSecondsLeft;

  public TimerCountdownResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TimerCountdownResponse numberOfSecondsLeft(Integer numberOfSecondsLeft) {
    this.numberOfSecondsLeft = numberOfSecondsLeft;
    return this;
  }

  /**
   * Get numberOfSecondsLeft
   * @return numberOfSecondsLeft
  */
  
  @Schema(name = "numberOfSecondsLeft", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberOfSecondsLeft")
  public Integer getNumberOfSecondsLeft() {
    return numberOfSecondsLeft;
  }

  public void setNumberOfSecondsLeft(Integer numberOfSecondsLeft) {
    this.numberOfSecondsLeft = numberOfSecondsLeft;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimerCountdownResponse timerCountdownResponse = (TimerCountdownResponse) o;
    return Objects.equals(this.id, timerCountdownResponse.id) &&
        Objects.equals(this.numberOfSecondsLeft, timerCountdownResponse.numberOfSecondsLeft);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numberOfSecondsLeft);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimerCountdownResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numberOfSecondsLeft: ").append(toIndentedString(numberOfSecondsLeft)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

