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
 * An object that can optionally include information about the error.
 */

@Schema(name = "Error", description = "An object that can optionally include information about the error.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-28T10:03:45.070482+02:00[Asia/Jerusalem]")
public class Error implements Serializable {

  private static final long serialVersionUID = 1L;

  private String msg;

  private Integer statusCode;

  public Error msg(String msg) {
    this.msg = msg;
    return this;
  }

  /**
   * A detailed error message.
   * @return msg
  */
  
  @Schema(name = "msg", description = "A detailed error message.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("msg")
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Error statusCode(Integer statusCode) {
    this.statusCode = statusCode;
    return this;
  }

  /**
   * The integer representing the HTTP status code (e.g. 500, 404).
   * @return statusCode
  */
  
  @Schema(name = "status_code", description = "The integer representing the HTTP status code (e.g. 500, 404).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status_code")
  public Integer getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(Integer statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.msg, error.msg) &&
        Objects.equals(this.statusCode, error.statusCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg, statusCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

