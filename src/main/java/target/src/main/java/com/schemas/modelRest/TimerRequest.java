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
 * an object represents timer post request
 */

@Schema(name = "TimerRequest", description = "an object represents timer post request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-28T10:03:45.070482+02:00[Asia/Jerusalem]")
public class TimerRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer hours;

  private Integer minutes;

  private Integer seconds;

  private String webhookUrl;

  public TimerRequest hours(Integer hours) {
    this.hours = hours;
    return this;
  }

  /**
   * Get hours
   * @return hours
  */
  
  @Schema(name = "hours", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("hours")
  public Integer getHours() {
    return hours;
  }

  public void setHours(Integer hours) {
    this.hours = hours;
  }

  public TimerRequest minutes(Integer minutes) {
    this.minutes = minutes;
    return this;
  }

  /**
   * Get minutes
   * @return minutes
  */
  
  @Schema(name = "minutes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minutes")
  public Integer getMinutes() {
    return minutes;
  }

  public void setMinutes(Integer minutes) {
    this.minutes = minutes;
  }

  public TimerRequest seconds(Integer seconds) {
    this.seconds = seconds;
    return this;
  }

  /**
   * Get seconds
   * @return seconds
  */
  
  @Schema(name = "seconds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seconds")
  public Integer getSeconds() {
    return seconds;
  }

  public void setSeconds(Integer seconds) {
    this.seconds = seconds;
  }

  public TimerRequest webhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
    return this;
  }

  /**
   * Get webhookUrl
   * @return webhookUrl
  */
  
  @Schema(name = "webhookUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("webhookUrl")
  public String getWebhookUrl() {
    return webhookUrl;
  }

  public void setWebhookUrl(String webhookUrl) {
    this.webhookUrl = webhookUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimerRequest timerRequest = (TimerRequest) o;
    return Objects.equals(this.hours, timerRequest.hours) &&
        Objects.equals(this.minutes, timerRequest.minutes) &&
        Objects.equals(this.seconds, timerRequest.seconds) &&
        Objects.equals(this.webhookUrl, timerRequest.webhookUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hours, minutes, seconds, webhookUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimerRequest {\n");
    sb.append("    hours: ").append(toIndentedString(hours)).append("\n");
    sb.append("    minutes: ").append(toIndentedString(minutes)).append("\n");
    sb.append("    seconds: ").append(toIndentedString(seconds)).append("\n");
    sb.append("    webhookUrl: ").append(toIndentedString(webhookUrl)).append("\n");
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

