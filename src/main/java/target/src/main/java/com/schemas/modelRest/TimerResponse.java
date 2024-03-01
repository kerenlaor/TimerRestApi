package target.src.main.java.com.schemas.modelRest;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import target.src.main.java.com.schemas.modelRest.TimerData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * this response shows all timers defined in the system
 */

@Schema(name = "TimerResponse", description = "this response shows all timers defined in the system")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-28T10:03:45.070482+02:00[Asia/Jerusalem]")
public class TimerResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer pageNumber;

  private Integer pageSize;

  
  private List<TimerData> timers;

  private Integer totalRowCount;

  public TimerResponse pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

  /**
   * Get pageNumber
   * @return pageNumber
  */
  
  @Schema(name = "pageNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageNumber")
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public TimerResponse pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /**
   * Get pageSize
   * @return pageSize
  */
  
  @Schema(name = "pageSize", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pageSize")
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public TimerResponse timers(List<TimerData> timers) {
    this.timers = timers;
    return this;
  }

  public TimerResponse addTimersItem(TimerData timersItem) {
    if (this.timers == null) {
      this.timers = new ArrayList<>();
    }
    this.timers.add(timersItem);
    return this;
  }

  /**
   * Get timers
   * @return timers
  */
  
  @Schema(name = "timers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timers")
  public List<TimerData> getTimers() {
    return timers;
  }

  public void setTimers(List<TimerData> timers) {
    this.timers = timers;
  }

  public TimerResponse totalRowCount(Integer totalRowCount) {
    this.totalRowCount = totalRowCount;
    return this;
  }

  /**
   * Get totalRowCount
   * @return totalRowCount
  */
  
  @Schema(name = "totalRowCount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalRowCount")
  public Integer getTotalRowCount() {
    return totalRowCount;
  }

  public void setTotalRowCount(Integer totalRowCount) {
    this.totalRowCount = totalRowCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TimerResponse timerResponse = (TimerResponse) o;
    return Objects.equals(this.pageNumber, timerResponse.pageNumber) &&
        Objects.equals(this.pageSize, timerResponse.pageSize) &&
        Objects.equals(this.timers, timerResponse.timers) &&
        Objects.equals(this.totalRowCount, timerResponse.totalRowCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, timers, totalRowCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TimerResponse {\n");
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    timers: ").append(toIndentedString(timers)).append("\n");
    sb.append("    totalRowCount: ").append(toIndentedString(totalRowCount)).append("\n");
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

